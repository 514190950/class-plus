package com.gxz.generator.execute;

import com.github.therapi.runtimejavadoc.*;
import com.gxz.generator.read.ClassPlus;
import com.gxz.generator.read.FieldPlus;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.io.IOException;
import java.util.List;

/**
 * 这是这个类的解释
 * 这个类是用来测试类解析好不好使的额
 * @author gxz
 * @date 2021/4/21
 * asdf
 * asdf
 * asdf
 */
@Data
public class Example {

    /**
     * 我看看这个静态变量是啥意思
     */
    private static final CommentFormatter formatter = new CommentFormatter();

    /**
    * 我来看看a是啥意思
     */
    private String a;



    /**
     * 这是main方法的意思
     * @param args arg是啥哈意思呢
     * @throws Exception 我草这个牛逼熬
     * @return a asdf
     */
    public static void main(String[] args) throws Exception {
        Example example = new Example();
        ClassPlus<?> classPlus = ClassPlus.forName("com.gxz.generator.execute.Example");
        System.out.println(classPlus.getComment().getDesc());
        FieldPlus name = classPlus.getField("a");
        name.setAccessible(true);
        name.set(example, "asdfasdf");
        System.out.println(example.getA());
        System.out.println(classPlus.getField("a").getPrototype()==name.getPrototype());
    }
}
