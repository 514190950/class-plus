package com.gxz.generator.read;

import lombok.Data;
import lombok.Getter;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
@Data
public class MethodPlus {

    private Method prototype;

    private ParameterPlus[] parameters;

    private String comment;


    public MethodPlus(Method prototype) {
        this.prototype = prototype;
    }


    public String getName() {
        return prototype.getName();
    }

    public Class<?> getReturnType() {
        return prototype.getReturnType();
    }

    public Object invoke(Object obj, Object... args) throws InvocationTargetException, IllegalAccessException {
        return prototype.invoke(obj, args);
    }

    public Annotation[] getDeclaredAnnotations() {
        return prototype.getDeclaredAnnotations();
    }


}
