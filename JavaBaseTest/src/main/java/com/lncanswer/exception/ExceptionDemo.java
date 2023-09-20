package com.lncanswer.exception;

/**
 * @author LNC
 * @version 1.0
 * @description 异常处理
 * @date 2023/9/20 15:46
 */
public class ExceptionDemo {
    /**
     * 异常分为RunTimeException（运行时异常） 和编译时异常
     * 编译时异常，在编译阶段会报错，必须手动处理
     * 运行时异常，在运行阶段才会报错，
     */
    public static void main(String[] args) {
       ExceptionDemo exceptionDemo = new ExceptionDemo();
       //捕捉异常
        exceptionDemo.testRuntimeException();

    }

    /**
     * java默认处理异常的方式是：JVM捕捉异常 然后将异常类型、信息打印在控制台，并且不再执行之后的代码
     * try catch捕捉异常：当异常出现之后打印错误信息之后程序还可以继续往下执行
     */
    public void  testRuntimeException(){
        int [] arr ={1,2,3,4,5};
        try{
            //可能出现异常的代码
            System.out.println(arr[10]);
        }catch (RuntimeException e){
            System.out.println("索引越界了");
        }
        //try catch捕获异常不会终止程序的执行
        System.out.println("执行");

    }

    /**
     * 底层异常接口Throwable成员方法：
     * public String getMessage() 返回此throwable的详细详细字符串
     * public String toString()    返回此可抛出的简短描述
     * public void printStackTrace() 将错误信息打印在控制台
     */

    /**
     * 抛出处理：throws 写在方法定义处，表示声明一个异常 告诉调用者可能会产生哪些异常
     * throw 写在方法内，结束方法 手动抛出异常对象，交给调用者 方法中下面的代码不再执行
     */
}
