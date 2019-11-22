package java基础.日期和时间;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Date_ {
    /**
     * Date类:
     */
    @Test
    public void date_Test() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    }

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
     * 返回起始时间至今的毫秒数(Long格式)
     */
    @Test
    public void getTime() {
        Date date = new Date();
        System.out.println(date.getTime());
    }

    /**
     *把时间设置为起始时间 + 毫秒数,作用等同于传参的构造方法
     */
    @Test
    public void setTime() {
        Date date = new Date();
        System.out.println(date);
        date.setTime(3000);
        System.out.println(date);
    }

    /**
     * 比较两个date对象的时间前后,返回boolean
     */
    @Test
    public void before() {
        Date date1 = new Date();
        Date date2 = new Date(5000);
        boolean result = date1.before(date2);
        System.out.println(result);
    }

    /**
     * 转换成instant对象;
     * TODO
     */
    @Test
    public void toInstant(){
        Date date1 = new Date(5000);
        System.out.println(date1);
        Instant instant = date1.toInstant();
        System.out.println(instant);
    }
}
