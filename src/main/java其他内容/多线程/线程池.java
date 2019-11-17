package java其他内容.多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 获取线程池的几种方法? TODO
 */
public class 线程池 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            Dog dog = new Dog(Integer.toString(i));
            Future<String> submit = executorService.submit(dog);
        }
        //关闭线程池
        executorService.shutdown();


    }

}
