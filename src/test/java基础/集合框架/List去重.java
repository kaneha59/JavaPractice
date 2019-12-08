package java基础.集合框架;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class List去重 {

    int[] ints;
    List<Integer> list;
    @Before
    public void before() {


    }

    /**
     * 用Stream, 复合数据类型去重
     */
    @Test
    public void test(){
    }

    /**
     * 重写HashCode()和equals(),然后用HashSet或者Stream的distinct()来去重
     */
    //TODO
    Stream<Integer> stream = Stream.of(3, 3, 5, 5, 11, -41, 12, 12);

    /**
     * 基本数据类型去重,3种方法.
     */
}
