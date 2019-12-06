package java基础.继承;

import org.junit.Test;

/**
 * 重写方法内需要用super显式地调用父类方法,父类方法的代码才会起作用
 * 不用super调用父类方法时,是完全重写.
 */
public class 继承 {
    private class Person {
        public void write() {
            System.out.println("我是Person...");
        }
    }

    private class Student extends Person{
        @Override
        public void write() {
            //super.write();
            super.write();
            System.out.println("我是student...");
        }
    }

    /**
     * 测试方法
     */
    @Test
    public void extendsTest() {
        Student student = new Student();
        student.write();
    }
}
