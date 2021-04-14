package com.gxz.generator.read;

import com.gxz.generator.read.springframework.ParameterPlus;

import java.lang.reflect.Method;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
public class MethodPlus {

    private Method prototype;

    private ParameterPlus[] parameterPluses;


    public MethodPlus(Method prototype){
        this.prototype = prototype;
    }

    public String getName(){
        return prototype.getName();
    }





}
