package com.lncanswer.stream;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LNC
 * @version 1.0
 * @description stream流
 * @date 2023/9/19 19:15
 */
public class StreamBase {
    /**
     * 单列集合中Colletion的stream方法、数组的stream方法
     * Stream接口中静态方法of：可以传递一堆零散的数据，也可以传递数组，但是数组必须是引用数据类型
     * 如果传递基本数据类型，会把整个数组当做一个元素，放到stream流中
     * 对于双列集合使用stream流需要先将里面的数据转换成单列集合，如：entrySet、keySet方法
     *
     * stream流可以理解为一条流水线，它将数据放在一条流水线上，可以对这些数据进行操作（过滤、遍历等）
     *
     * @param args
     */
    public static void main(String[] args) {
        //stream流遍历list集合
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6);
        //forEach是利用lambda表达式进行遍历操作 stream将列表的数据放在一条线上
        list.stream().forEach(item -> System.out.print(item + " "));

        //stream流遍历双列集合，首先将双列集合转换成Set单列集合
        HashMap<String,Integer> map = new HashMap<>();
        map.put("qqq",1);
        map.put("sad",2);
        map.put("ca",3);
        //先获得键值对的集合对象，再对键值对集合对象进行遍历
        map.entrySet().stream().forEach(item -> System.out.print("  " + item));
        //也可以先获得键的集合对象 在遍历
        map.keySet().stream().forEach(item-> System.out.println(item));

        //stream流 遍历数组 Array调用stream方法
        int [] arr ={231,432,6547,64,138,109};
        Arrays.stream(arr).forEach(item -> System.out.println(item));

        //stream接口of方法遍历零散元素
        Stream.of(1,100).forEach(item -> System.out.println(item));

        //stream流中间方法的使用
        StreamBase streamBase = new StreamBase();
        streamBase.MiddleMethod();

        //stream流终结方法的使用
        streamBase.endMethod();
    }

    /**
     * stream流中的中间方法：filter（过滤）、limit（获取前几个元素）、skip（跳过前几个元素）
     *  distinct 元素去重，依赖hashCodeh和equals方法，底层是hashSet
     *  concat 合并a，b两个流为一个流
     *  map 转换流中的数据类型
     *  使用中间方法对流进行操作之后会返回一个新的流，原来的流会被关闭不能在使用
     *  修改stream流中的数据，不会影响原来集合或数组的值
     */
    public void MiddleMethod(){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,7,8,99,101);
        //ship表示跳过前面几个元素，limit表示取前面几个元素
        list.stream().skip(3).limit(3).forEach(item ->System.out.print(" "+item +" "));
        list.stream().limit(6).skip(3).forEach(item ->System.out.print("  " + item));
    }

    /**
     * stream流中的终结方法：Foreach（遍历）、count（统计）、
     * toArray() 收集流中的数据，放到数组中
     * collect() 收集流中的数据，放到集合中
     */
    public void endMethod(){
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"朝小野,18","杨华和,20","超英,20","柳市,22","杨晓霞,32","张甜甜,30");

        //将流中的数据收集到map集合中 转换成map的第一个参数为键的规则，第二个参数为值的规则
        Map<String, Integer> collectMap = list.stream().collect(Collectors.toMap(new Function<String, String>() {
            //形参s 代表stream流中的每一个数据，数据类型对于流中每一个数据的类型
            //返回值的类型表示键的类型
            @Override
            public String apply(String s) {
                return s.split(",")[0];
            }
        }, new Function<String, Integer>() {
            //将名字作为键，将年龄作为值
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s.split(",")[1]);
            }
        }));
        System.out.println(collectMap);


    }
}
