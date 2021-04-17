package com.gxz.generator.read;


import com.github.therapi.runtimejavadoc.BaseJavadoc;
import com.github.therapi.runtimejavadoc.ClassJavadoc;
import com.github.therapi.runtimejavadoc.Comment;
import com.github.therapi.runtimejavadoc.CommentText;
import com.github.therapi.runtimejavadoc.OtherJavadoc;
import lombok.Data;

import java.util.List;

/**
 * @author gxz
 * @date 2021/4/17 17:49
 */
@Data
public class ClassComment implements BaseComment<ClassComment, ClassJavadoc> {

    private final static String AUTHOR = "author";
    private final static String DATE = "date";

    private String author;
    private String date;
    private String desc;


    @Override
    public ClassComment parse(ClassJavadoc baseJavadoc) {
        Comment comment = baseJavadoc.getComment();
        this.desc = comment.toString();
        List<OtherJavadoc> other = baseJavadoc.getOther();
        if (other != null) {
            for (OtherJavadoc otherJavadoc : other) {
                String value;
                switch (otherJavadoc.getName()) {
                    case AUTHOR:
                        value = ((CommentText)(otherJavadoc.getComment().getElements().get(0))).getValue().trim();
                        this.author = value;
                        break;
                    case DATE:
                        value = ((CommentText) (otherJavadoc.getComment().getElements().get(0))).getValue().trim();
                        this.date = value;
                        break;
                    default:
                        break;
                }
            }
        }
        return this;
    }

    @Override
    public boolean success() {
        return desc != null;
    }
}
