package com.lncanswer.io.zipstream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author LNC
 * @version 1.0
 * @description 文件夹压缩
 * @date 2023/9/22 19:40
 */
public class ZipStreamTest1 {
    /**
     * 用压缩流去压缩文件夹
     */
    public static void main(String[] args) throws IOException {
        //1、创建文件夹路径
        File src =  new File("D:\\aaa");
        //2、创建File对象压缩的路径（父级路径）
        File destParent = src.getParentFile();  // D:\\
        //3、创建File对象表示压缩包的路径  加上  .zip后缀
        File dest = new File(destParent,src.getName()+".zip");
        //4、创建压缩流压缩包
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(dest));
        //获取src里每一个文件，变成ZipEntry对象，放入到压缩包中
         toZip(src,zipOutputStream,src.getName());
        //释放资源
        zipOutputStream.close();
    }


    /**
     * 将src里每一个文件变中ZipEntry对象，放入到压缩包中
     * 参数一：数据源   参数二：压缩流    参数三：压缩包内部路径
     */
    public static void toZip(File src,ZipOutputStream zipOutputStream,String name) throws IOException {
        //进入src文件夹 获取所有的文件、文件夹列表
        File [] files = src.listFiles();
        //遍历数组
        for (File file : files){
            //判断是否是文件
            if (file.isFile()){
                //是文件，将其变成ZipEntry对象，放入压缩包当中
                ZipEntry entry = new ZipEntry(name +"\\" + file.getName());
                zipOutputStream.putNextEntry(entry);
                //读取文件的数据
                FileInputStream fileInputStream = new FileInputStream(file);
                int b;
                while ((b =fileInputStream.read())!= -1){
                    zipOutputStream.write(b);
                }
                fileInputStream.close();
                zipOutputStream.closeEntry();
            }else {
                //如果是文件夹，递归操作
                toZip(file,zipOutputStream,name + "\\" +file.getName());
            }
        }

    }
}
