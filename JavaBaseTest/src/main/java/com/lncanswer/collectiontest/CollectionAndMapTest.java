package com.lncanswer.collectiontest;

import java.awt.*;
import java.text.CollationElementIterator;
import java.util.*;
import java.util.List;

/**
 * @author LNC
 * @version 1.0
 * @description 所有集合练习
 * @date 2023/9/17 16:57
 */
public class CollectionAndMapTest {

    public static void main(String[] args) {
        CollectionAndMapTest cam = new CollectionAndMapTest();
        //随机点名
        cam.test1();
        //概念随机点名
        System.out.println("概率随机点名 --------------");
        cam.test2();
    }

    /**
     * 班级有n个学生 实现随机点名
     */
    public void test1(){
        //随机输入学生
        Scanner scanner =new Scanner(System.in);
        int i = scanner.nextInt();
        //利用random随机数进行随机点名
        Random r = new Random();
        int [] arr = new int[i];
        for (int j = 1; j <= i; j++) {
            arr[0]  =j+1;
        }
        System.out.println("随机点名："  + (r.nextInt(arr.length)+1));

        //利用Collections工具类的shuffle方法来进行随机选择
        List<Integer> list = new ArrayList<>();
        for (int j = 1; j <= i; j++) {
            list.add(j+1);
        }
        Collections.shuffle(list);
        System.out.println("随机点名："  + (r.nextInt(arr.length)+1));
    }

    /**
     * 班级有n个学生 70概率随机到男生 30概率随机到女生
     */
    public void test2(){
        //用普通的random已经不满足需求 需要自定义方法
        //用一个列表来存放7个1 3个0 来表示概率 1表示男生 0表示女生
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,1,1,1,1,1,1,0,0,0);
        Collections.shuffle(list);
        //打乱顺序之后随机取值
        Random random = new Random();
        //获取随机值的下标
        int index = random.nextInt(list.size());
        //通过下标拿到数据
        Integer number = list.get(index);
        System.out.println(number);

        //创建两个集合分别用来存储男生和女生
        List<String> mamList = new ArrayList<>();
        Collections.addAll(mamList,"q","w","e","g");
        List<String> maleList = new ArrayList<>();
        Collections.addAll(maleList,"da","girl","mm");
        if (number ==1){
            //在男生集合随机抽取
            System.out.println(mamList.get(random.nextInt(mamList.size())));
        }else{
            System.out.println(maleList.get(random.nextInt(maleList.size())));
        }
    }
}

