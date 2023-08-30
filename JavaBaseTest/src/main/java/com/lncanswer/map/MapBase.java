package com.lncanswer.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class MapBase {
    public static void main(String [] args){
        Map<String ,String> map = new HashMap<>();
        /**
         * Map:双列集合 存放的是一对键值对  第一个元素为键 第二个元素为值
         * 通过键 可以找到相应的值， 键是唯一的
         * Map中的方法： put、get、remove、keySet等
         * put方法 如果不存在键值，则会添加到map集合中， 如果已经存在相应的键值，
         * 那么会将原有的值覆盖，并且返回一个被覆盖的值
         */
        map.put("xiaoxiao","小小");
        map.put("wuwu","呜呜");

       String value =  map.get("wuwu");
        System.out.println("修改之前:"+ value);

       //put存放数据时，如果存在键值，则会覆盖并且返回被覆盖的值
        String wu = map.put("wuwu", "你好");
        System.out.println("修改之后："+map.get("wuwu"));
        System.out.println("返回被覆盖的值:" + wu);

        /**
         * 通过Map的keySet方法获取Map中所有的键值集合
         */
        Set<String> ksys = map.keySet();
        //遍历键值集合Set 打印数据
        for(String key : ksys){
            //利用for增加的形式拿到每个键值里面的数据 再进行打印
            String s = map.get(key);
            System.out.println(key+ " = " + s);
        }
        //利用迭代器的方式遍历
        Iterator<String> iterator = ksys.iterator();

        /**
         * 通过Map中的entrySet方法获取所有的键值对集合， entry表示键值对
         */
        Set<Map.Entry<String, String>> entries = map.entrySet();
        //遍历entrySet
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value1 = entry.getValue();
            System.out.println(key + " = " + value1);
        }

        /**
         * 通过Lambda表达式遍历
         */
        System.out.println("Lambda表达式遍历------------");
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s + " = " + s2);
            }
        });
        //lambda表达式如果方法只有一行 可以将大括号 分号 返回值(return)全部省略
        map.forEach((key,valye) ->  System.out.println(key + " = " + valye));


    }
}
