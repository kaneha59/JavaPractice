package java其他内容.多线程.创建线程;

/**
 * 流程
 * 1.Student类继承Thread类,重写run()方法
 * 2.Student类内有Thread成员变量
 * 3.为Student类写一个start()方法,用于实例化Thread,并调用Thread的start()方法,进入线程池
 * 4.在main()方法中运行,线程获取CPU资源后,执行run()方法
 *
 */
public class Thread类创建线程 {
    public static void main(String[] args) {
        Student s1 = new Student("s1");
        Student s2 = new Student("s2");
        s1.start();
        s2.start();
    }
}

class Student extends Thread {

    private Thread t;
    private String threadName;

    Student(String name) {
        threadName = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(t.getId());
            System.out.println(threadName + "---before running...");
            t.sleep(2000);
            System.out.println(threadName + "---after running...");
            System.out.println(t.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void start() {
        if(t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}