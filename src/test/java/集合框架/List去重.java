package java.集合框架;

import org.junit.Test;

import java.util.stream.Stream;

public class List去重 {
    /**
     * 用Stream, 复合数据类型去重
     */
    @Test
    public void test(){
        Stream<Integer> stream = Stream.of(-3, 4, -5, 1, 11, -41, 12, 12);
        //TODO

    }

    /**
     * 重写HashCode()和equals(),然后用HashSet或者Stream的distinct()来去重
     */
    //TODO

    /**
     * 基本数据类型去重,3种方法.
     */
}
