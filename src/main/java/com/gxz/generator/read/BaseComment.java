package com.gxz.generator.read;


/**
 * @author gxz
 * @date 2021/4/17 17:29
 * 注释
 */

public interface BaseComment<Comment, Doc> {

    Comment parse(Doc baseJavadoc) throws IllegalArgumentException;

    boolean success();


}
