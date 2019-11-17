package java基础.其他;

import org.junit.Test;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class 日期 {
    /**
     * Date类:
     */
    @Test
    public void date_Test() {
        //1.无参构造方法,生成当前时间的日期
        Date date = new Date();

        //2.传入Long数值,生成对应时间(距离1970年的毫秒数)
        Date date1 = new Date(500000);

        //3.getTime()方法返回Date对象内时间距离1970年的毫秒数
        System.out.println("getTime(): " + date.getTime());

        //4.after(), before() 传入一个Date对象做参数,比较时间前后返回boolean
        System.out.println("after(): " + date.after(new Date(10000)));

        //5.setTime(设置date对象距离1970年的毫秒数)
        date.setTime(400000);
        System.out.println(date);
        //6. 不知道干嘛的
        // TODO
        date.toInstant();
    }

    /**
     * TODO
     */
    @Test
    public void simpleDateFormat_Test() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String format = sdf.format(new Date());
        System.out.println(format);
    }

    /**
     * TODO
     */
    @Test
    public void Calendar_Test() {
        Calendar instance = Calendar.getInstance();

    }
}
