package com.gxz.generator.read;


import com.github.therapi.runtimejavadoc.ParamJavadoc;
import lombok.Data;

import java.lang.reflect.Method;


/**
 * @author gxz
 * @date 2021/4/17 19:50
 */
@Data
public class ParamComment implements BaseComment<ParamComment, ParamJavadoc> {

    private static final String PARAM = "param";

    private String name;

    private String desc;

    private boolean success;

    private Method method;


    @Override
    public ParamComment parse(ParamJavadoc paramJavadoc) throws IllegalArgumentException {
        ParamComment paramComment = new ParamComment();
        paramComment.setName(paramJavadoc.getName());
        paramComment.setDesc(paramJavadoc.getComment().toString());
        paramComment.success = true;
        return paramComment;
    }

    @Override
    public boolean success() {
        return success;
    }
}
