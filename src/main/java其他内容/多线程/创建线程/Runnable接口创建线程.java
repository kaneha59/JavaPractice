package java其他内容.多线程.创建线程;

/**
 * 流程
 * 1.Person类继承Runnable接口,实现run()方法
 * 2.Person类内置Thread成员变量
 * 3.Person类写一个start()方法,创建Thread实例,并调用Thread的start()方法,进入就绪状态
 * 4.线程获取CPU资源,运行run()方法.
 */
public class Runnable接口创建线程 {

    /**
     * main方法
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(new Person("p1"));
        Thread t2 = new Thread(new Person("p2"));
        t1.start();
t1.interrupt();
        t2.start();
        System.out.println("haha");

    }
}
/**
 * 支持多线程的Person
 */
 class Person implements Runnable{
    //Thread的名字
    String threadName;

    /**
     * 构造方法
     */
    Person(String name) {
        threadName = name;
    }

    /**
     * 运行
     */
    @Override
    public void run() {
        synchronized (this) {

        }
        try {
            Thread.yield();
            Thread.sleep(100);
            System.out.println(threadName + "---before sleeping...");
            Thread.sleep(200);
            System.out.println(threadName + "---after sleeping...");
            System.out.println(Thread.interrupted() + "ato");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
