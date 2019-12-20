package java基础.异常;

import org.junit.Test;

import java.io.IOException;

public class java异常 {
    @Test
    public void catchException1() {
        try {
            this.execute1();
        } catch (Exception e) {
            System.out.println("调用的方法不用抛出异常,在外部也可以catch到!");
            e.printStackTrace();
        }
    }

    private void execute1() {
        this.makeOneException1();
    }

    private void makeOneException1() {
        throw new NullPointerException();
    }

}
