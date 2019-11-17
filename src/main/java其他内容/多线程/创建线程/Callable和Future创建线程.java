package java其他内容.多线程.创建线程;

import java.util.concurrent.*;

/**
 * 一.用到的接口:
 * Callable接口: 是函数式接口,只有一个方法call(),可以返回类型V(泛型)
 * Future接口可以: 1.取消线程 2.检查线程是否被取消或是否完成 3.也可以获取线程运行结果
 * FutureTask接口: 实现RunnableFuture接口,可以接受Callable或Runnable接口的子类来实例化
 *
 * 二.使用Callable和Future创建线程的流程如下:
 * 1.Visitor类实现Callable接口,重写call()方法
 * 2.new一个Visitor对象,以此为入参,new一个FutureTask对象.
 * 3.以这个FutureTask对象为入参,new一个Thread,调用start()方法,开始进程
 */
public class Callable和Future创建线程 {
}

class Visitor implements Callable<String> {

    public static void main(String[] args) {
        Visitor v1 = new Visitor();
        FutureTask<String> ft1 = new FutureTask<>(v1);

        new Thread(ft1, "ft1").start();


    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "线程运行中");

        return "你好啊!!!";
    }
}
