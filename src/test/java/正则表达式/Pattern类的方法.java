package 正则表达式;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Pattern类的方法 {
    /**
     * matches()静态方法,用于判断是否完全匹配整个字符串,返回boolean
     * 完全匹配返回true,不能完全匹配返回false
     * 关键词: 静态方法
     */
    @Test
    public void matches_(){
        String sentence = "my name is zhangsan";
        String regex = ".";

        System.out.println("------public static boolean matches(String regex, CharSequence input)方法测试------");
        System.out.println("测试字符串为: 'my name is zhangsan'");
        System.out.println("'.'只能匹配单个任意字符,无法完全匹配,返回: " + Pattern.matches(".", sentence));
        System.out.println("'.+'可以匹配无限多个任意字符,完全匹配,返回: " + Pattern.matches(".+", sentence));
    }

    /**
     * split()用于分割字符串,返回String数组
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

}
