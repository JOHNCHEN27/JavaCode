package com.lncanswer.colletionAdvanced.collection.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author LNC
 * @version 1.0
 * @description
 * @date 2023/9/16 16:07
 */
public class TreeSetBase {

    /**
     * TreeSetBase：不重复、无索引、可排序
     * 可排序是指：按照元素的默认规则（由小到大）排序
     * TreeSet底层：基于红黑树的数据结果实现排序，增删查改的性能都很好
     *
     * 对于自定义对象，需要实现Comparable接口，指定自己的排序规则 如：按年龄进行排序
     * 实现Comparable接口中的compareTo方法，在方法里指定排序规则 如：return this.age - o.age
     * 按照对象的年龄（某个属性）进行排序
     * 底层红黑树会根据对象的属性不断调用compareTo方法进行比较 每次从根节点开始比较
     * 直到找到相应的存储位置，红黑树会自动调整
     * 方法的返回值分为三种：负数、正数、0
     * 负数表示 要将当前添加的元素存入红黑树的左边
     * 正数表示 要将当前添加的元素存入红黑树的右边
     * 0表示元素已经存在 不会添加 舍弃掉
     */
     public static void main(String [] args){
         TreeSetBase treeSetBase =new TreeSetBase();
         //验证TreeSet默认排序规则
        // treeSetBase.TreeSetSort();

         //使用比较器自定义排序规则
         treeSetBase.TreeSetCompareSort();
     }



    /**
     * TreeSet集合默认的排序规则
     * 对于数值类型，Integer，Double，默认按照从小到大的顺序进行排序
     * 对于字符、字符串类型：按照字符在ASCII码表中的数字升序进行排序
     *当存入的时候会自动根据当前类型的大小进行排序 取的时候也是按顺序来取
     */
    public void TreeSetSort(){
        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(9);
        treeSet.add(6);

        //增强for遍历 将遍历的值存放到第三方遍历中，通过第三方遍历拿到遍历的值
        for (Integer integer : treeSet) {
            //增强for 第三方遍历遍历
            System.out.println("增强for遍历：" + integer +" ");
        }
        //迭代器遍历 hasnext判断当前指针指向的位置是否有元素 next取当前位置的元素并移动指针到下一个位置
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println("迭代器遍历：" +next + "  ");
        }
        //lambda表达式遍历 底层遍历集合将数据返回给accept方法中的参数
        treeSet.forEach( it -> System.out.println("lambda表达式遍历：" + it + "  "));
    }


    /**
     * TreeSet集合排序方式有两种：一种是自然排序 默认   第二种是比较器排序
     * 比较器排序在集合创建时使用lambda表达式进行排序
     */
    public void TreeSetCompareSort(){
        //创建TreeSet集合，创建时指定排序规则 为比较器排序
        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
            //修改成lambda方式此方法必须是一个函数实接口
            //实现Comparetor接口方法 指定排序规则
            @Override
            public int compare(String o1, String o2) {
                //根据对象的长度进行排序
                int i = o1.length() - o2.length();
                //如果长度一样，再按照首字母进行排序  字符串类型调用compareTo方法就是默认的排序规则
                i = i == 0 ? o1.compareTo(o2) : i;
                return i;
            }
        });

        //添加元素
        ts.add("c");
        ts.add("ab");
        ts.add("df");
        ts.add("qwer");

        //打印集合
        System.out.println(ts);
    }
}
