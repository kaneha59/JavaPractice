package java基础.正则表达式;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Pattern类的方法 {
    /**
     * public static boolean matches(String regex, CharSequence input) {...}
     * 用于判断是否完全匹配整个字符串,返回boolean
     * 关键词: 静态方法
     * PS: CharSequence意思是Char序列,该接口是String,StringBuilder,StringBuffer等类的实现接口
     */
    @Test
    public void matches_(){
        String sentence = "my name is zhangsan";

        System.out.println(Pattern.matches(".", sentence));
        System.out.println(Pattern.matches(".+", sentence));
    }

    /**
     * public String[] split(CharSequence input) {...}
     * public String[] split(CharSequence input, int limit) {...}
     * 用于分割字符串,返回String数组.有2个重载方法
     * 关键词: 重载方法
     */
    @Test
    public void split_(){
        String sentence = "my name is zhangsan";
        String regex = " ";

        Pattern compile = Pattern.compile(regex);

        //一个参数
        String[] split1 = compile.split(sentence);
        System.out.println("一个参数: " + Arrays.asList(split1));
        //两个参数,第二个参数是限制数组的容量(分割字符串的个数)
        String[] split2 = compile.split(sentence, 2);
        System.out.println("两个参数: " + Arrays.asList(split2));
    }

    /**
     * public String pattern() {...}
     * 可以返回Pattern对象的正则表达式
     */
    @Test
    public void pattern_(){
        String regex = "a+?";
        Pattern compile = Pattern.compile(regex);
        System.out.println(compile.pattern());
    }

    /**
     * public Predicate<String> asPredicate() {...}
     * 源码: return s -> matcher(s).find();
     * 使用Matcher的find()方法,部分匹配,作为Predicate对象返回
     */
    @Test
    public void asPredicate_(){
        String regex = "ceb";
        Pattern compile = Pattern.compile(regex);
        Predicate<String> predicate = compile.asPredicate();
        System.out.println("1: " + predicate.test("ceba"));
    }

    /**
     * 源码: return s -> matcher(s).matches();
     * 使用的是Matcher的matches()方法,是完全匹配
     */
    @Test
    public void asMatcherPredicate_(){
        String regex = "ceb";
        Pattern compile = Pattern.compile(regex);
        Predicate<String> predicate = compile.asMatchPredicate();
        System.out.println("1: " + predicate.test("ceba"));

        //和上边的方法有什么区别?
        //贴上源码,自己理解
        // asPredicate()  ==>  return s -> matcher(s).find();
        // asMatchPredicate()  ==>  return s -> matcher(s).matches();
        //find()是部分匹配,matches()是完全匹配
    }

}
