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

//        Thread t1 = new Thread(new Person("p1"));
//        Thread t2 = new Thread(new Person("p2"));
//        Thread t3 = new Thread(new Person("p3"));
        Person p1 = new Person("p1");
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p1);
        Thread t3 = new Thread(p1);

        t1.start();
        t2.start();
        t3.start();
        System.out.println(Thread.activeCount());
        while (Thread.activeCount() > 2) Thread.yield();

        System.out.println("haha");
        System.out.println(Person.count);

    }
}
/**
 * 支持多线程的Person
 */
 class  Person implements Runnable{
    //Thread的名字
    String threadName;
    static int count = 300000;

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
            Thread.currentThread().setName(threadName);
            for (int i = 0; i < 100000; i++) {
                count--;
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
