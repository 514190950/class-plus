package com.gxz.generator.read;


import com.github.therapi.runtimejavadoc.Comment;
import com.github.therapi.runtimejavadoc.CommentElement;
import com.github.therapi.runtimejavadoc.CommentText;
import com.github.therapi.runtimejavadoc.MethodJavadoc;
import com.github.therapi.runtimejavadoc.OtherJavadoc;
import com.github.therapi.runtimejavadoc.ParamJavadoc;
import com.github.therapi.runtimejavadoc.ThrowsJavadoc;
import com.gxz.generator.read.springframework.util.CollectionUtils;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author gxz
 * @date 2021/4/17 17:49
 */
@Data
public class MethodComment implements BaseComment<MethodComment, MethodJavadoc> {

    private static final String RETURN = "return";
    private static final String AUTHOR = "author";

    private String name;

    private String author;

    private String returnComment;

    private ParamComment[] params;

    private ExceptionComment[] exceptions;

    private String desc;

    private boolean success = false;


    @Override
    public MethodComment parse(MethodJavadoc methodJavadoc) throws IllegalArgumentException {
        if(methodJavadoc == null || methodJavadoc.isEmpty()){
            return this;
        }
        this.name = methodJavadoc.getName();
        this.desc = methodJavadoc.getComment().toString();
        fillParam(methodJavadoc.getParams());
        fillReturn(methodJavadoc.getReturns());
        fillException(methodJavadoc.getThrows());
        fillAuth(methodJavadoc.getOther());
        success = true;
        return this;
    }

    @Override
    public boolean success() {
        return success;
    }

    private void fillAuth(List<OtherJavadoc> other) {
        if (other != null) {
            Optional<OtherJavadoc> first = other.stream().filter(doc -> AUTHOR.equals(doc.getName())).findFirst();
            first.ifPresent(otherJavadoc -> this.author = otherJavadoc.getComment().toString());
        }
    }

    private void fillException(List<ThrowsJavadoc> throwsJavadocs) {
        this.exceptions = throwsJavadocs.stream().map(throwsJavadoc -> new ExceptionComment().parse(throwsJavadoc)).collect(Collectors.toList()).toArray(new ExceptionComment[]{});
    }

    private void fillReturn(Comment commentElements) {
        this.returnComment = commentElements.toString();
    }

    private void fillParam(List<ParamJavadoc> paramJavadocs) {
        if (!CollectionUtils.isEmpty(paramJavadocs)) {
            this.params = paramJavadocs.stream()
                    .map(paramJavadoc -> new ParamComment().parse(paramJavadoc))
                    .collect(Collectors.toList())
                    .toArray(new ParamComment[]{});
        }
    }



}
