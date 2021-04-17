package com.gxz.generator.read;


import com.github.therapi.runtimejavadoc.ClassJavadoc;
import com.github.therapi.runtimejavadoc.CommentFormatter;

/**
 * @author gxz
 * @date 2021/4/17 18:58
 */
public class CommentParse {


    private static final CommentFormatter FORMATTER = new CommentFormatter();

    private final static String AUTHOR = "author";
    private final static String DATE = "date";
    private final static String SINCE = "since";
    private final static String VERSION = "version";
    private final static String DEPRECATED = "deprecated";
    private final static String RESULT = "return";
    private final static String PARAM = "param";
    private final static String EXCEPTION = "exception";
    private final static String ERROR = "throws";


    private CommentParse() {

    }

    public static ClassComment parseClassComment(ClassJavadoc classJavadoc) {
        if (classJavadoc.isEmpty()) {
            return null;
        }
        ClassComment classComment = new ClassComment();
        String format = FORMATTER.format(classJavadoc.getComment());

        return null;
    }

    /**
     * 填充类注释
     *
     * @param format       注释内容
     * @param classComment 类注释
     */
    private void fillClassComment(String format, ClassComment classComment) {
        StringBuilder context = new StringBuilder();
        String[] split = format.split("\r");

    }



}
