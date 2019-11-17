package java其他内容.多线程;

import java.util.concurrent.Callable;

public class Dog implements Callable<String> {
    String content;
    Dog(String content) {
        this.content = content;
    }

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(500L);
        this.bark();
        return content;
    }

    private void bark() {
        System.out.println("汪汪汪!" + content);
    }
}
