package java.正则表达式;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 正则表达式 {

    /**
     * 更改regex,练习正则表达式
     */
    @Test
    public void 正则练习(){
        String sentence = "cb-ceb-ceeb-ceeeb-ceeeeb,.?!@#$%^&*()";
        String regex = ".+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);

        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }

    /**
     * 匹配汉字的练习
     */
    @Test
    public void 汉字匹配(){
        String sentence = "我的名字是barry,来自NewYork.";
        String regex = "[^\\x00-\\xff]+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);

        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
