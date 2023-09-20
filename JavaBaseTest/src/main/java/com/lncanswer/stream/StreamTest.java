package com.lncanswer.stream;

import com.lncanswer.entity.Actor;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LNC
 * @version 1.0
 * @description  stream流练习
 * @date 2023/9/20 9:54
 */
public class StreamTest {

    public static void main(String[] args) {
        StreamTest streamTest = new StreamTest();
        streamTest.filterNum();

        //map数据转换
        streamTest.mapList();

        streamTest.sumTest();

     }


     /*
     定义一个集合，并添加一些整数1,2,3...
     过滤数据
      */
     public void filterNum(){
         List<Integer> list = new ArrayList<>();
         Collections.addAll(list,1,2,3,4,5,6,7,8,9,10);
         //过滤奇数只流下整数
         list.stream().filter(item -> item%2==0).forEach(item-> System.out.print(" " +item));

         //过滤偶数并把结果保留i起来
         list = list.stream().filter(item -> item%2!=0).collect(Collectors.toList());

         list.forEach(item -> System.out.print(" " +item));
     }


    /**
     * 创建一个ArrayList集合，并添加字符串，字符串中前面是姓名，h后面是年龄
     */
    public void mapList(){
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"zhangsan,18","lisi,24","wangwu,25");

        //map中的第一个参数表示键的规则，第二个参数表示值的规则
        Map<String, Integer> collect = list.stream().filter(s -> Integer.parseInt(s.split(",")[1])>=24)
                .collect(Collectors.toMap(s -> s.split(",")[0], s ->
                Integer.parseInt(s.split(",")[1])));
        collect.forEach((String s,Integer a) -> System.out.println( s + "-> " + a));
    }

    /**
     * 两个ArrayList集合，第一个集合：存储六名男演员的名字和年龄，
     * 第二个集合中，存储六名女演员的名字和年龄 名字和年龄用逗号分开
     * 要求：
     * 男演员只要名字为三个字的前两人，女演员只要姓杨的，并且不要第一个
     * 把过滤后的男演员姓名和女演员姓名合并到一起
     * 将上一步的演员信息封装成Actor对象中
     * 将所有演员对象都保存到List集合
     * 演员类Actor 属性有：name、age
     */
    public void sumTest(){
        ArrayList<String> manList = new ArrayList<>();
        ArrayList<String> maleList = new ArrayList<>();
        Collections.addAll(manList,"蔡困困,24","你好啊,25","柳依依,28","五五,18","OO,18","小灿灿，20");
        Collections.addAll(maleList,"朝小野,18","杨华和,20","超英,20","柳市,22","杨晓霞,32","张甜甜,30");

        Stream<String> manStream = manList.stream().filter(s -> s.split(",")[0].length() == 3).limit(2);
        Stream<String> maleStream = maleList.stream().filter(s -> s.split(",")[0].startsWith("杨")).skip(1);
        Stream<String> concat = Stream.concat(manStream, maleStream);
        //concat.forEach(item -> System.out.print(" " + item));
        //将合并的演员信息封装到Actor对象
        List<Actor> collect = concat.map(item -> {
            Actor actor = new Actor(item.split(",")[0], Integer.parseInt(item.split(",")[1]));
            return actor;
        }).collect(Collectors.toList());

         collect.forEach(s -> System.out.println(s.getName() +":" + s.getAge() + "  "));

    }
}
