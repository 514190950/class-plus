package com.gxz.generator.read;


import java.lang.reflect.AnnotatedType;

/**
 * @author gxz gongxuanzhang@foxmail.com
 * 这是增强版本的Class内容 对Class所有内容进行了封装
 **/
public class ClassPlus<T> {

    private Class<T> prototype;

    private FieldComposition fieldComposition;

    private MethodComposition methodComposition;


    public AnnotatedType[] getAnnotatedInterfaces() {
        return prototype.getAnnotatedInterfaces();
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
