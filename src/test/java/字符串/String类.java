package java.字符串;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * 写了暂时比较陌生的String方法
 */
public class String类 {

    @Test
    public void test(){
        String str = "abcdefg hijklmn opq rst uvw xyzz";

        //codePointAt(int index)
        //获取指定字符串的unicode编码
        System.out.println(str.codePointAt(0));

        //codePointBefore(int index)
        //获取字符串内指定字符的前一个字符的unicode编码,
        System.out.println(str.codePointBefore(1));

        //codePointCount(int beginIndex, int endIndex)
        //获取截取的字符串中用到的unicode总数,与length()不同
        System.out.println(str.codePointCount(0, 20));

        //substring()和subSequence()
        //区别,subSequence()返回的是CharSequence的子类,不是String
        System.out.println(str.substring(0, 10));
        System.out.println(str.subSequence(0, 10));

        //contentEquals()
        //contentEquals()传入stringBuffer对象做比较,返回boolean
        System.out.println(str.contentEquals(new StringBuffer("abcdefg hijklmn opq rst uvw xyzz")));

        //getChars(int srcBegin, int srcEnd, char dst[], int dstBegin)
        //把字符串截取,并变成char,导入传入的char[]中
        char[] c1 = new char[10];
        str.getChars(4, 8, c1, 3);
        for (int i = 0; i < c1.length; i++) {
            System.out.print(c1[i] + "-");
        }

        //lastIndexOf(String str, int fromIndex)
        //和indexOf()不同,lastIndexOf()是从后往前搜索
        System.out.println("\n" + str.lastIndexOf("g", 31));

        //replace(CharSequence target, CharSequence replacement)
        //还有重载方法,自己看
        //替换单个字符,用replace(),替换字符串,用replaceAll()
        String replace = str.replace("z", "Z");

        System.out.println(replace);

        //regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)
        //截取字符串并与传入的新串进行匹配,完全匹配返回true,5个入参要搞清楚
        boolean matchRes = str.regionMatches(true, 8, "hijklmn", 0, 7);
        System.out.println(matchRes);

        //offsetByCodePoints(int index, int codePointOffset)
        //返回此 String 中从给定的 index 处偏移 codePointOffset 个代码点的索引
        //还不太明白.    codePoint指的是unicode编码
        str.offsetByCodePoints(0, 3);
    }

    @Test
    public void java9_(){
        String str = "abcdefg hijklmn opq rst uvw xyzz";

        //chars()
        //转换成JAVA8的stream,可进行集合操作
        IntStream chars = str.chars();
        System.out.println(chars.count());

        //codePoints()
        //把字符串每个字符的unicode编码传入stream
        IntStream intStream = str.codePoints();
        intStream.forEach(x -> System.out.print(x + "-"));
    }

    /**
     * java11中新增的功能
     */
    @Test
    public void java11_(){
        String str = "abcdefg hijklmn opq rst uvw xyzz";

        //去除首尾空格,功能类似trim(),但略有不同
        str.strip();

        //去除开头的空格
        str.stripLeading();

        //去除结尾的空格
        str.stripTrailing();

        //repeat(int count)
        //把字符串重复n次,再返回新的字符串
        String repeat = str.repeat(3);
        System.out.println("--" + repeat);

        //isBlank()
        //判断是否是空串
        System.out.println(str.isBlank());
    }

    @Test
    public void java12_(){
        String str = "abcdefg hijklmn opq rst uvw xyzz";

        //describeConstable()
        //把字符串包装进一个Optional中并返回.包装类也有该方法,继承自Constable接口
        System.out.println(str.describeConstable().get());

        //indent(int n)
        //改变字符串缩进
        System.out.println(str.indent(10));

        //public <R> R transform(Function<? super String, ? extends R> f) {return f.apply(this);}
        //传入一个函数,可以随便玩
        String transform = str.transform(x -> x.concat("新增transform()"));
        System.out.println(transform);

    }
}
