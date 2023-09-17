package com.lncanswer.colletionAdvanced.map;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiConsumer;

/**
 * @author LNC
 * @version 1.0
 * @description TreeMap
 * @date 2023/9/17 8:51
 */
public class TreeMapBase {
    /**
     * 可排序、无重复、无索引
     * TreeMap底层 跟TreeSet底层是一样的，底层由红黑树构成
     * 对于自定义对象，需要指定排序规则（按照什么来进行排序）
     * 有两种方式可以定义排序规则：
     * 1、在javaBean类实现Comparable接口，实现接口里CompareTo方法 进行比较 o1-o2升序 o2-o1降序
     * 2、创建Comparator对象，直接指定排序规则
     * @param args
     */
    public static void main(String [] args){

        //指定排序规则 降序排序，java默认的类型是升序排列
        //字符串类型默认按字符大小排列（本质是按ASCII码值对比）
        TreeMap<Integer,String> treeMap = new TreeMap<>(new Comparator<Integer>() {
            /**
             * 指定排序规则 ，o1表示要添加的元素  o2表示以及存在的元素
             * 这里使用已经存在的元素和要添加的元素相减 计算出来是降序排列
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             * @return
             */
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        treeMap.put(1,"zhangsan");
        treeMap.put(2,"lisi");
        treeMap.put(3,"wuang");

        Set<Map.Entry<Integer, String>> entries = treeMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
        }

        TreeMapBase treeMapBase = new TreeMapBase();
        //用计数器思想进行统计
        treeMapBase.countChar();
        //用map进行统计 改进计算器的弊端
        treeMapBase.MapCount();
    }


    /**
     * 统计字符串"aababcabcdabcde"每一个字符出现的次数
     * 输出结果：
     * a(5) b(4) c(3) d(2) e(1)
     */
    public void countChar(){
        int [] count = new int [5];
        TreeMap<Integer,String> treeMap = new TreeMap<>();
        String s = "aababcabcdabcde";
        for (int i = 0; i < s.length(); i++){
            treeMap.put(i+1, String.valueOf(s.charAt(i)));
        }
        int i =0;
        Set<Integer> integers = treeMap.keySet();
        for (Integer integer : integers) {
            if (!treeMap.get(integer).isEmpty()){
                if (treeMap.get(integer).equals("a")){
                   count[i] ++;
                }else if (treeMap.get(integer).equals("b")){
                    count[i+1]++;
                }else if (treeMap.get(integer).equals("c")){
                    count[i+2]++;
                }else if (treeMap.get(integer).equals("d")){
                    count[i+3] ++;
                }else {
                    count[i+4]++;
                }
            }
        }
        char [] a = {'a','b','c','d','e'};
        for ( int j = 0; j <5 ;j++) {
                System.out.print(a[j] + "(" + count[j] + ") ");
        }
    }

    /**
     * 新的排序思想；利用map集合 如果不需要排序用HashMap， 如果需要排序用TreeMap
     * 将不重复的内容作为键，将需要统计的内容作为值
     */
    public void MapCount(){
        String s = "aababcabcdabcde";
        //创建TreeMap
        TreeMap<Character,Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < s.length() ;i++) {
            //取出字符串中的每个字符
            char c = s.charAt(i);
            //判断字符在map中是否存在
            if (treeMap.containsKey(c)){
                //存在 则将统计数加1
                Integer integer = treeMap.get(c);
                integer++;
                treeMap.put(c,integer);
            }else {
                //不存在直接添加
                treeMap.put(c,1);
            }
        }
        treeMap.forEach(new BiConsumer<Character, Integer>() {
            @Override
            public void accept(Character character, Integer integer) {
                System.out.print(character + "(" + treeMap.get(character)+") ");
            }
        });
    }
}
