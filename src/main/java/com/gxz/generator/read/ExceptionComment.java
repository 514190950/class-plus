package com.gxz.generator.read;


import com.github.therapi.runtimejavadoc.OtherJavadoc;
import com.github.therapi.runtimejavadoc.ThrowsJavadoc;
import lombok.Data;

/**
 * @author gxz
 * @date 2021/4/17 19:51
 */
@Data
public class ExceptionComment implements BaseComment<ExceptionComment, ThrowsJavadoc> {

    private static final String EXCEPTION = "exception";
    private static final String THROWS = "throws";

    private String name;

    private String desc;


    @Override
    public ExceptionComment parse(ThrowsJavadoc baseJavadoc) throws IllegalArgumentException {
        this.name = baseJavadoc.getName();
        this.desc = baseJavadoc.getComment().toString();
        return this;
    }

    @Override
    public boolean success() {
        return this.desc != null;
    }
}

