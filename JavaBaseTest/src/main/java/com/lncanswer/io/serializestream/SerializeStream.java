package com.lncanswer.io.serializestream;

import com.lncanswer.entity.Student;
import com.lncanswer.entity.Student1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author LNC
 * @version 1.0
 * @description 序列化流
 * @date 2023/9/22 15:55
 */
public class SerializeStream {

    /**
     * 序列化流：ObjectOutputStream
     * 将对象序列化写入到本地文件中，需要将对象的类实现序列化接口，表示这个对象可以被序列化到文件中
     * 否则不能使用序列化流操作对象
     * 序列化指将对象进行包装，使得内容不被别人知道
     * @param args
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //序列化流
        ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("text.txt")));
        //将对象序列化到文件中
        Student1 student = new Student1("张三",20);
        Student1 student1 = new Student1("wuwu",19);
        Student1 student2  = new Student1("haha",22);

        //将对象存入list集合中再写入
        ArrayList<Student1> list = new ArrayList<>();
        Collections.addAll(list,student,student1,student2);
        outputStream.writeObject(list);
        //释放资源
        outputStream.close();

        //读取文件中序列化列表里的对象
        SerializeStream serializeStream = new SerializeStream();
        serializeStream.testSerializeObject();
    }

    /**
     * 反序列化流：将文件中的序列化对象读取到程序中
     * readObject（） 读取序列化对象
     * 需要注意的是，反序列化的时候要保证每个序列化号是唯一的，否则读取不了
     * 保证唯一的规则就是，在javabean类实现序列化接口时，指定这个类的序列化号，并且不能变化
     * 序列化到文件中的数据不能被修改，被修改不能读取
     */
    public void testSerializeObject() throws IOException, ClassNotFoundException {
        //读取文件中序列化的对象
        ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get("text.txt")));
        //读取的文件序列化对象进行强转
        ArrayList<Student1> list = (ArrayList<Student1>) inputStream.readObject();

        list.forEach(System.out::println);

    }
}
