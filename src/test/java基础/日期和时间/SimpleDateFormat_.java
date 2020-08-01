package java基础.日期和时间;

import org.junit.Test;

import java.text.ParseException;
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

    /**
     * 借助SimpleDateFormat实现 String和Date互转
     */
    @Test
    public void string和date互转() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //1. String  ==>  Date
        String str1 = "1996-09-18 07:18:09";
        Date parse = sdf.parse(str1); // parse()方法会抛出编译期异常(ParseException),所以必须处理或抛出该异常
        System.out.println(parse);

        //2. Date  ==>  String
        String format = sdf.format(parse);
        System.out.println(format);
    }

    /**
     * SimpleDateFormat的其他方法
     */
    @Test
    public void toPattern() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        //1.toPattern() 获取该SimpleDateFormat对象的模板字符串(pattern)
        String s = sdf.toPattern();
        System.out.println(s);
    }
}
