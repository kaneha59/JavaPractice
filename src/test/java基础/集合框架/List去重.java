package java基础.集合框架;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class List去重 {
    Integer[] ints = new Integer[] {1, 1, 2, 2, 3, 3};
    List<Integer> list;

    @Before
    public void before() {
        List<Integer> integers = Arrays.asList(ints);
        list = new ArrayList<>(integers);
    }

    @Test
    public void test(){
        //分为基本数据类型去重和引用数据类型去重

        //一. 基本数据类型去重
            //1. 新建一个List,使用contains判断,把不包含的元素放入新List中
            //2. 通过HashSet去重
            //3. 双层for循环,通过比较来找出重复元素并删除.
            //4. 用Stream去重.

    }

    /**
     * for循环去重是可行的!!!
     */
    @Test
    public void 双重for循环去重() {
        for (int a = 0; a < list.size() - 1; a++) {
            for (int z = list.size() - 1; z > a; z--) {
                if(list.get(a).equals(list.get(z))) {
                    list.remove(z);
                }
            }
        }
        System.out.println(list);
    }




    /**
     * 用Stream, 复合数据类型去重
     */


    /**
     * 重写HashCode()和equals(),然后用HashSet或者Stream的distinct()来去重
     */
    /**
     * 基本数据类型去重,3种方法.
     */
}
