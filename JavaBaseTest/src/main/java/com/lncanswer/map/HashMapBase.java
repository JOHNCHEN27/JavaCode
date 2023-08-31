package com.lncanswer.map;

import com.lncanswer.entity.Student;

import java.util.*;
import java.util.function.BiConsumer;

public class HashMapBase {
    public static void main(String [] agrs){
        /**
         * 创建一个HashMap集合 键是学生对象,值是籍贯
         * 存储三个键值对元素并遍历
         * 要在学生对象中重写HashCode方法 才可以存放Hashmap中
         * HashMap使用场景为 当键为引用对象时
         * Map一般用来键为普通类型
         */

        HashMap<Student,String> hashMap = new HashMap<>();
        //创建学生对象
        Student s1 = new Student("lisi",20);
        Student s2 = new Student("wangwu", 21);
        Student s3 = new Student("ww", 22);
        //存入hashMap
        hashMap.put(s1,"江苏");
        hashMap.put(s2,"湖南");
        hashMap.put(s3,"深圳");

        //lambda表达式遍历hashMap
        hashMap.forEach(new BiConsumer<Student, String>() {
            @Override
            public void accept(Student student, String s) {
                System.out.println(student.toString() + " 籍贯：" +s);
            }
        });
        System.out.println("简化之后的Lambda表达式: ");
        hashMap.forEach(((student, s) -> System.out.println(student.toString() + " 籍贯： " +s)));


        /**
         * 案例： 某个班级有80名学生，出去游玩投票 一共有四个景点ABCD
         * 每个学生只能选择一个景点，请统计出最终哪个景点去的人数最多
         */
        //可以利用map的特征 把景点作为键 把次数作为值 来进行存储
        HashMap <String,Integer>hashM = new HashMap<>();
        //生成随机数对象
        Random r = new Random();
        //生成ABCD四个景点数组
        String [] arr = {"A","B","C","D"};
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            //for循环模拟八十个学生随机投票
            //随机生成四个景点的数组下标 根据下标进行投票 存放到一个集合中
            int index = r.nextInt(arr.length);
            //这里直接把四个景点添加到list集合中，用来保存每个人投票结果，
            String name =arr[index];
            list.add(name);
        }
        //将每个人的投票结果统计 放入到map中

        for (String name : list) {
            if(hashM.containsKey(name)){
                //如果包含值则进行加一  get返回该键值对应的值
                Integer count = hashM.get(name);
                count++;
                //把修改之后的值重新存入到hashMap中 覆盖原先的值
                hashM.put(name,count);
            }else {
                //如果不包含 说明还没进行存储 直接存入hashMap中
                hashM.put(name,1);
            }
        }
        //打印hashM查看结果
        System.out.println(hashM);
        //将结果统计完成之后，统计其中的最大值
        int max = 0;  //一般来说 max的值会设置成数组中的一个来计算，但是这里可能为0 所有直接设置0对比
        //先拿到所有的键值对 entrySet
        Set<Map.Entry<String,Integer>> entries = hashM.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            int count = entry.getValue();
            if(count > max){
                max = count;
            }
        }
        System.out.println("最大值为：" + max);
        for (Map.Entry<String, Integer> entry : entries) {
            int count = entry.getValue();
            if (count == max){
                System.out.println("投票结果最多的景点为："+entry.getKey() + "  票数为：" +count);
            }
        }

    }
}
