package java基础.日期和时间;

import org.junit.Test;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Calendar_ {
    /**
     * 获取抽象类Calendar的实例
     */
    @Test
    public void 获取实例() {
        //Calendar是抽象类,只能通过getInstance()方法来获取示例
        Calendar c = Calendar.getInstance();
        System.out.println(c);
    }

    /**
     * calendar可以和date, long互转
     */
    @Test
    public void calendar的转换() {
        Calendar calendar = Calendar.getInstance();
        //1. 和date互转
        //calendar  ==>  date
        Date time = calendar.getTime();
        //date  ==>  calendar
        calendar.setTime(time);

        //2. 和long互转
        //calendar  ==>  long
        long timeInMillis = calendar.getTimeInMillis();
        //long  ==>  calendar
        calendar.setTimeInMillis(timeInMillis);

        System.out.println(calendar);
    }

    /**
     * calendar比date强大之处
     */
    @Test
    public void 强大的get方法() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));//当前年份
        System.out.println(calendar.get(Calendar.MONTH));//当前月份, 月份范围是0-11月...
        System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));//本月的第几周
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));//今年的第几周
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));//一年的第几天
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//今天几号
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));//一周的第几天 周日是第一天,周六是第七天
        System.out.println(calendar.get(Calendar.HOUR));//12小时制
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));//24小时制
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));//不清楚啊

    }
}
