package com.gxz.generator.read;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author gxz gongxuanzhang@foxmail.com
 * 增强版的反射内容
 **/
public class FieldPlus {


    public FieldPlus(Field prototype) {
        this.prototype = prototype;
    }

    private Field prototype;


    public String getName() {
        return prototype.getName();
    }

    public Object get(Object o) throws IllegalArgumentException, IllegalAccessException {
        prototype.setAccessible(true);
        return prototype.get(o);
    }

    public void set(Object obj, Object value) throws IllegalArgumentException, IllegalAccessException {
        prototype.set(obj, value);
    }

    public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        return prototype.getAnnotation(annotationClass);
    }

    public <T extends Annotation> T[] getAnnotationsByType(Class<T> annotationClass) {
        return prototype.getAnnotationsByType(annotationClass);
    }

    public Annotation[] getDeclaredAnnotations() {
        return prototype.getDeclaredAnnotations();
    }
}
