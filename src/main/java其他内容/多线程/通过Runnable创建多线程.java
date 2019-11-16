package java其他内容.多线程;

/**
 * 流程
 * 1.Person类继承Runnable接口,实现run()方法
 * 2.Person类内置Thread成员变量
 * 3.Person类内的一个方法,创建Thread实例,并调用Thread的start()方法,使线程进入就绪状态
 * 4.线程获取CPU资源,运行run()方法.
 */
public class 通过Runnable创建多线程 {

    /**
     * main方法
     */
    public static void main(String[] args) {
        Person p1 = new Person("p1");
        p1.start();
    }


}
/**
 * 支持多线程的Person
 */
 class Person implements Runnable{

    //支持多线程的类内有一个Thread变量;
    Thread t;
    //Thread的名字
    String threadName;

    //构造方法
    Person(String name) {
        threadName = name;
    }

    /**
     * 新建Thread对象,并调用start()方法,线程进入就绪状态;
     */
    public void start() {
        if(t == null) {
            t = new Thread(this, threadName);
            System.out.println("Creating Thread...");

            //
            t.start();
            System.out.println("Starting Thread");
        }
    }

    /**
     * 运行
     */
    @Override
    public void run() {
        try {
            System.out.println("before sleeping...");
            t.sleep(2000);
            System.out.println("after sleeping...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
