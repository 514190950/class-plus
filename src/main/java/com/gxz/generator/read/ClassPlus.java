package com.gxz.generator.read;


import com.github.therapi.runtimejavadoc.*;
import com.github.therapi.runtimejavadoc.Comment;
import lombok.Data;

import java.lang.reflect.AnnotatedType;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gxz gongxuanzhang@foxmail.com
 * 这是增强版本的Class内容 对Class所有内容进行了封装
 **/
@Data
public class ClassPlus<T> {

    private Class<T> prototype;

    private FieldComposition fieldComposition;

    private MethodComposition methodComposition;

    private ClassComment comment;


    /**
     * 增强Class
     *
     * @param fullyQualifiedClassName class类全名
     * @return ClassPlus
     */
    public static ClassPlus<?> forName(String fullyQualifiedClassName) throws ClassNotFoundException {
        return ClassPlusBuild.build(fullyQualifiedClassName);
    }

    private static void printMethodJavadoc(MethodJavadoc methodDoc) {
        System.out.println(methodDoc.getName() + methodDoc.getParamTypes());
        System.out.println(format(methodDoc.getComment()));

        if (!methodDoc.isConstructor()) {
            System.out.println("  returns " + format(methodDoc.getReturns()));
        }

        for (SeeAlsoJavadoc see : methodDoc.getSeeAlso()) {
            System.out.println("  See also: " + see.getLink());
        }
        for (OtherJavadoc other : methodDoc.getOther()) {
            System.out.println("  " + other.getName() + ": "
                    + format(other.getComment()));
        }
        for (ParamJavadoc paramDoc : methodDoc.getParams()) {
            System.out.println("  param " + paramDoc.getName() + " "
                    + format(paramDoc.getComment()));
        }
        for (ThrowsJavadoc throwsDoc : methodDoc.getThrows()) {
            System.out.println("  throws " + throwsDoc.getName() + " "
                    + format(throwsDoc.getComment()));
        }
        System.out.println();
    }

    private static String format(Comment c) {
        return new CommentFormatter().format(c);
    }

    private ClassPlus(Class<T> prototype) {
        this.prototype = prototype;
    }

    private static class ClassPlusBuild {

        public static ClassPlus<?> build(String fullyQualifiedClassName) throws ClassNotFoundException {
            Class<?> aClass = Class.forName(fullyQualifiedClassName);
            ClassPlus<?> classPlus = new ClassPlus<>(aClass);
            ClassJavadoc classDoc = RuntimeJavadoc.getJavadoc(fullyQualifiedClassName);
            //  填充Class信息
            ClassComment classComment = new ClassComment().parse(classDoc);
            classPlus.setComment(classComment);
            //  填充属性
            List<FieldComment> fieldComments = classDoc.getFields().stream().map(fieldJavadoc -> new FieldComment().parse(fieldJavadoc)).collect(Collectors.toList());
            classPlus.setFieldComposition(new FieldComposition(aClass.getDeclaredFields(), fieldComments));
            //  填充方法
            List<MethodComment> methodComments = classDoc.getMethods().stream().map(methodJavadoc -> new MethodComment().parse(methodJavadoc)).collect(Collectors.toList());
            classPlus.setMethodComposition(new MethodComposition(aClass.getDeclaredMethods(), methodComments));
            return classPlus;
        }
    }


    public AnnotatedType[] getAnnotatedInterfaces() {
        return prototype.getAnnotatedInterfaces();
    }

    public Class<T> getPrototype() {
        return prototype;
    }

    public String getName() {
        return prototype.getName();
    }

    public Class<?>[] getInterfaces() {
        return prototype.getInterfaces();
    }

    public String getSimpleName() {
        return prototype.getSimpleName();
    }

    public FieldPlus[] getFields() {
        return fieldComposition.getFiles();
    }

    public MethodPlus[] getMethods() {
        return methodComposition.getMethods();
    }

    public FieldPlus getField(String name) {
        return fieldComposition.select(name);
    }

    public MethodPlus getMethod(String name, Class<?>... parameterTypes) {
        return methodComposition.select(name, parameterTypes);
    }


}
