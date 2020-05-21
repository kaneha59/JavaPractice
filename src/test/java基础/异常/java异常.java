package java基础.异常;

import org.junit.Test;

import java.io.IOException;

public class java异常 {
    @Test
    public void catchException1() {
        try {
            this.execute1();
        } catch (Exception e) {
            System.out.println("调用的方法时产生的运行时异常会被外部的catch块捕捉到");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private void execute1() {
        this.makeOneException1();
        System.out.println("此行不会被打印: 抛出异常后程序终止进行...");
    }

    private void makeOneException1() {
        throw new NullPointerException();
    }

}
