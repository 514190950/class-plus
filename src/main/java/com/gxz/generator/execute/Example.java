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
 *
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
     *
     * @param canshu1 参数string
     * @return 返回你猜
     */
    public String fangfa(String canshu1){
        return null;
    }

    /**
     *
     * @param canshu2 参数string集合数组
     * @return 返回你猜
     */
    public String fangfa(List<String>[] canshu2){
        return null;
    }

    /**
     * 方法重载3
     * @param canshu3 参数string数组
     * @return 返回你猜
     */
    public String fangfa(int[][] canshu3){
        return null;
    }

    /**
     * 方法重载3
     * @param canshu5 参数int
     * @return 返回你猜
     */
    public String fangfa(int canshu5){
        return null;
    }

    /**
     *
     * @param canshu4 参数string集合
     * @return 返回你猜
     */
    public String fangfa(List<String> canshu4){
        return null;
    }

    /**
     * 这是main方法的意思
     *
     * @param args arg是啥哈意思呢
     * @return a asdf
     * @throws Exception 我草这个牛逼熬
     */
    public static void main(String[] args) throws Exception {
     /*   Example example = new Example();
        ClassPlus<?> classPlus = ClassPlus.forName("com.gxz.generator.execute.Example");
        System.out.println(classPlus.getComment().getDesc());
        FieldPlus name = classPlus.getField("a");
        name.setAccessible(true);
        name.set(example, "asdfasdf");
        System.out.println(example.getA());
        System.out.println(classPlus.getField("a").getPrototype() == name.getPrototype());*/
        Class a = long[][].class;
        System.out.println("long[][]  "+a.getName());
        a = short[][].class;
        System.out.println("short[][]  "+a.getName());
        a = int[][].class;
        System.out.println("int[][]  "+a.getName());
        a = byte[][].class;
        System.out.println("byte[][]  "+a.getName());
        a = char[][].class;
        System.out.println("char[][]  "+a.getName());
        a = boolean[][].class;
        System.out.println("boolean[][]  "+a.getName());
        a = float[][].class;
        System.out.println("float[][]  "+a.getName());
        a = double[][].class;
        System.out.println("double[][]  "+a.getName());
        a = double.class;
        System.out.println("double  "+a.getName());




    }
}
