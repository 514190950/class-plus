package com.gxz.generator.execute;

import com.github.therapi.runtimejavadoc.*;
import jdk.jfr.DataAmount;

import java.io.IOException;
import java.util.List;

public class Example {

    private static final CommentFormatter formatter = new CommentFormatter();

    public static void printJavadoc(String fullyQualifiedClassName) throws IOException, ClassNotFoundException {
        Class<?> aClass = Class.forName(fullyQualifiedClassName);
        String name = aClass.getName();
        DataAmount annotation = aClass.getAnnotation(DataAmount.class);
        System.out.println(annotation.value());
        ClassJavadoc classDoc = RuntimeJavadoc.getJavadoc(fullyQualifiedClassName);
        if (classDoc.isEmpty()) { // optionally skip absent documentation
            System.out.println("no documentation for " + fullyQualifiedClassName);
            return;
        }

        System.out.println(classDoc.getName());
        System.out.println(format(classDoc.getComment()));
        System.out.println();

        List<FieldJavadoc> fields = classDoc.getFields();
        for (FieldJavadoc field : fields) {
            System.out.println(field.getClass().getName());
            System.out.println(field.getName());
            System.out.println(field.getComment());
        }

        // @see tags
        for (SeeAlsoJavadoc see : classDoc.getSeeAlso()) {
            System.out.println("See also: " + see.getLink());
        }
        // miscellaneous and custom javadoc tags (@author, etc.)
        for (OtherJavadoc other : classDoc.getOther()) {
            System.out.println(other.getName() + ": " + format(other.getComment()));
        }

        System.out.println();
        System.out.println("CONSTRUCTORS");
        for (MethodJavadoc methodDoc : classDoc.getConstructors()) {
            printMethodJavadoc(methodDoc);
        }

        System.out.println();
        System.out.println("METHODS");
        for (MethodJavadoc methodDoc : classDoc.getMethods()) {
            printMethodJavadoc(methodDoc);
        }
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
        return formatter.format(c);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        printJavadoc("com.gxz.generator.execute.Ssdfsadf");
    }
}
