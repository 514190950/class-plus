package com.gxz.generator.read;


import lombok.Data;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author gxz gongxuanzhang@foxmail.com
 * 增强版的反射内容
 **/
@Data
public class FieldPlus {


    private Field prototype;

    private String name;

    private FieldComment comment;


    public FieldPlus(Field prototype, FieldComment comment) {
        this.prototype = prototype;
        this.name = prototype.getName();
        this.comment = comment;
    }


    public Object get(Object o) throws IllegalArgumentException, IllegalAccessException {
        prototype.setAccessible(true);
        return prototype.get(o);
    }

    public void setAccessible(boolean flag) {
        prototype.setAccessible(flag);
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
