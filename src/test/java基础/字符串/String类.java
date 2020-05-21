package java基础.字符串;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 写了暂时比较陌生的String方法
 */
public class String类 {

    @Test
    public void test(){
        String str = "abcdefg hijklmn opq rst uvw xyzz";

        // 1.去掉开头或结尾的空格
        String str1 = "  aabbcc  ";

        // 2.拼接字符串

        // 3.包含字符串

        // 4.判断内容相同(两种比较方法的区别?String重写过的equals()方法要了解)

        // 5.正则完全匹配的方法?

        // 6.String变char数组?

        // 7.replace(), replaceAll(), replaceFirst()的用法和区别

        // 8.截取字符串

        // 9.分隔字符串,该方法是否会替换掉匹配内容?
        // 10.是否以给定字符串开头或结尾?

        // 11.将两个字符串的局部内容进行匹配返回boolean?

        // 12.根据索引查询对应char或根据char查询索引

        // 13.intern()的作用?
                // 先判断串池中是否有该对象,有则返回串池中该字符串的引用,
                // 没有则再串池中新建该对象,再返回该引用

        // 14.截取一段字符串并装入一个char数组?

        //15. String的静态方法format()怎么用?(参考同目录下的"String的format()方法.txt")

//        System.out.println(String.format("%9s%n%<6s", "abc"));
//        System.out.println(String.format("%2$d 比 %1$d 大5", 2, 7));
//        System.out.println(String.format("%6d和%% 呀%6d一样大", 34, 34));

    }

    @Test
    public void 创建字符串() {
        String a1 = "AA";
        String a2 = new String("BB");
        String a3 = "CC" + new String("DD");

        // a1: 首先在串池中创建"AA"(已有则不创建),并返回池中"AA"的引用给变量a1
        // a2: 首先在串池中创建"BB"(已有则不创建),再在堆中开辟"BB"
        // a3: 首先在堆中新建"CCDD",再在串池中产生一个指向堆中"CCDD"的引用
        System.out.println(a3 == a3.intern()); //true
        System.out.println(a2 == a2.intern()); //false
        System.out.println(a3 == "CCDD"); //true
        System.out.println(a2 == "BB"); //false

        //  为什么a3 == "CCDD"为true?
        //      "CCDD"在运行时,首先判断串池中是否有该对象,而此时串池中有指向堆中"CCDD"对象的引用,
        //      所以"CCDD"这句话并没有在串池新建对象,而是指向了串池中的那个引用,即堆中的"CCDD"对象.

        // String a3 = "CC" + new String("DD");
        //  语句中的"CC"在运行时,实际上已经在串池中新建了对象,但并没有把引用赋值给任何变量.
        //  该语句运行后结果如下
        //      堆:      "DD", "CCDD"
        //      串池:    "CC", "DD", 堆中"CCDD"的引用
    }

    @Test
    public void java8及以前() {
        String str = "abcdefg hijklmn opq rst uvw xyzz";

        //codePointAt(int index)
        //获取字符串某下标对应字符的unicode编码
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
        //将指定字符(串)替换,用replace(),使用正则替换,用replaceAll()
        String replace = str.replace("z", "Z12");

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
