package java基础.日期和时间;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Date_ {
    /**
     * 构造方法
     */
    @Test
    public void 构造方法(){
        //  1.无参构造方法,生成当前时间的日期
        Date date1 = new Date();
        System.out.println(date1);
        //  传入long格式毫秒数(1000毫秒=1秒),返回起始时间+毫秒数的date对象
        Date date2 = new Date(2000);
        System.out.println(date2);
    }

    /**
     * setTime()和getTime(),获取/设置毫秒数
     * Date可以和long互转
     */
    @Test
    public void getTime() {
        Date date = new Date();
        long time = date.getTime();
        date.setTime(time);
        System.out.println(date);
    }

    /**
     * before() / after()
     * 比较两个date对象的时间前后
     */
    @Test
    public void before() {
        Date date1 = new Date();
        Date date2 = new Date(5000);
        System.out.println(date1.before(date2));
        System.out.println(date1.after(date2));
    }

    /**
     * 转换成instant对象;
     * Instant是时间戳,具体作用未知...
     */
    @Test
    public void toInstant(){
        Date date1 = new Date(5000);
        System.out.println(date1);
        Instant instant = date1.toInstant();
        System.out.println(instant);
    }
}
