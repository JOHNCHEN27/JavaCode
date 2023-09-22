package com.lncanswer.io.zipstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author LNC
 * @version 1.0
 * @description 解压缩流
 * @date 2023/9/22 18:45
 */
public class ZipStreamTest {
    /**
     * 解压缩流：将压缩文件读取并解压到指定路径下
     */
    public static void main(String[] args) {
        //1、创建一个File（文件）表示需要解压的压缩包 假设为E盘下的压缩包
        File file = new File("E:\\aaa.zip");
        //2、创建一个File 表示需要解压缩到哪个路径
        File dest = new File("E:\\");

        //调用方法进行解压缩

    }

    /**
     * 定义一个方法进行解压缩
     */
    public static void unzip(File src, File dest) throws IOException {
        //创建解压缩流对象
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(src));
        //读取压缩文件中所有的文件、文件夹 获取压缩包里每一个zipEntry对象
        ZipEntry entry;
        //解压缩流对象有一个NextEntry方法可以读取压缩包里所有的文件、文件夹，全部读取完返回null
        while ((entry =zipInputStream.getNextEntry()) != null){
            //每当读取到一个对象时判断是文件还是文件夹
            if (entry.isDirectory()){
                //如果是文件夹则在目标路径下创建文件夹
                File file = new File(dest,entry.getName()); //源路径和当前文件夹名字拼接
                file.mkdir(); //创建这个文件夹
            }else {
                //如果是文件则在目标路径下创建文件
                FileOutputStream outputStream = new FileOutputStream(new File(dest,entry.toString()));
                //再将文件中的数据全部读取
                int b;
                while ((b = zipInputStream.read()) != -1){
                    outputStream.write(b);
                }
                outputStream.close();
                zipInputStream.closeEntry();
            }
        }
        zipInputStream.close();
    }

    /**
     * 压缩流：ZipOutputStream
     * 参数一：表示要压缩的文件   参数二：表示压缩到哪个路径下
     */
    public static void toZipStream(File src1,File dest1) throws IOException {
        //创建压缩流对象 File表示要压缩到哪个路径下的哪个文件
        ZipOutputStream zipOutputStream  = new ZipOutputStream( new FileOutputStream(new File(dest1,"a.zip")));
        //创建ZipEntry对象，表示压缩包里每一个文件或文件夹
        ZipEntry zipEntry = new ZipEntry("a.txt");
        //将文件或文件夹压缩到压缩包中
        zipOutputStream.putNextEntry(zipEntry);
        //将src中的数据写入到压缩包中
        FileInputStream fileInputStream = new FileInputStream(src1);
        int b;
        while ((b = fileInputStream.read()) != -1){
            zipOutputStream.write(b);
        }
        zipOutputStream.closeEntry();
        zipOutputStream.close();
    }

}
