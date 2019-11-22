package java基础.日期和时间;

import org.junit.Test;

import java.util.Calendar;

public class Calendar_ {
    @Test
    public void test() {
        Calendar instance = Calendar.getInstance();
    }

    /**
     * Calendar是抽象类,所以不能通过new来获取对象!
     * getInstance()有多个重载方法
     */
    @Test
    public void 获取实例() {
        Calendar c = Calendar.getInstance();
        System.out.println(c);
    }

    /**
     * 传入(类中定义好的)int常量,获取日历内指定内容
     * TODO 还有好多...
     */
    @Test
    public void get() {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.DATE));
        System.out.println("--------------------------");
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        System.out.println(c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println(c.get(Calendar.DAY_OF_YEAR));
        System.out.println("--------------------------");
        System.out.println(c.get(Calendar.HOUR));
        System.out.println(c.get(Calendar.HOUR_OF_DAY));
    }
}
