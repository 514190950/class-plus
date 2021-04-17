package com.gxz.generator.read;


import com.github.therapi.runtimejavadoc.FieldJavadoc;
import lombok.Data;

/**
 * @author gxz
 * @date 2021/4/17 17:49
 */
@Data
public class FieldComment implements BaseComment<FieldComment, FieldJavadoc> {

    private String desc;

    private String name;


    @Override
    public FieldComment parse(FieldJavadoc baseJavadoc) throws IllegalArgumentException {
        this.desc = baseJavadoc.getComment().toString();
        this.name = baseJavadoc.getName();
        return this;
    }

    @Override
    public boolean success() {
        return false;
    }
}
