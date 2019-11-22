package java基础.日期和时间;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormat_ {

    @Test
    public void test() {

    }

    /**
     * public SimpleDateFormat(String pattern){...}
     * public SimpleDateFormat(String pattern, Locale locale){...}
     * public SimpleDateFormat(String pattern, DateFormatSymbols formatSymbols){...}
     */
    @Test
    public void 构造函数(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //  TODO 其他两个是什么?
    }

    @Test
    public void format() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

        //  重载方法1
        //  public final String format(Date date){...}
        String format = sdf.format(new Date());
        System.out.println(format);

        //  TODO 其他重载方法...
    }

    /**
     * 获取匹配符
     */
    @Test
    public void toPattern() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String s = sdf.toPattern();
        System.out.println(s);
    }
}
