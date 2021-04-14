package com.gxz.generator.read;

import lombok.Getter;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Parameter;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
@Getter
public class ParameterPlus implements AnnotatedElement {

    private Parameter prototype;

    private String name;

    private String comment;


    public Class<?> getType() {
        return prototype.getType();
    }

    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
        return prototype.isAnnotationPresent(annotationClass);
    }

    @Override
    public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        return prototype.getAnnotation(annotationClass);
    }

    @Override
    public Annotation[] getAnnotations() {
        return prototype.getAnnotations();
    }

    @Override
    public <T extends Annotation> T[] getAnnotationsByType(Class<T> annotationClass) {
        return prototype.getAnnotationsByType(annotationClass);
    }

    @Override
    public <T extends Annotation> T getDeclaredAnnotation(Class<T> annotationClass) {
        return prototype.getDeclaredAnnotation(annotationClass);
    }

    @Override
    public <T extends Annotation> T[] getDeclaredAnnotationsByType(Class<T> annotationClass) {
        return prototype.getDeclaredAnnotationsByType(annotationClass);
    }

    @Override
    public Annotation[] getDeclaredAnnotations() {
        return prototype.getDeclaredAnnotations();
    }


}
