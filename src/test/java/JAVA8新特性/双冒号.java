package JAVA8新特性;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 双冒号'::'是结合JAVA8新特性Lambda表达式来使用的,用于传入一个方法作为参数.
 * Lambda表达式实际上就是一个方法,函数式接口可以接收一个Lambda表达式.
 * 有时候有可重用的方法,无需重新写Lambda表达式时,可用::来传入现存方法到函数式接口.
 */
public class 双冒号 {

    private int compare(int a, int b){
        if(a > b) return 1;
        if(a < b) return -1;
        return 0;
    }
    @Test
    public void test(){
        Integer[] integers = {11, 5, 2, 91, 8};
        List<Integer> intList = Arrays.asList(integers);

        intList.sort(this::compare);
        System.out.println(intList);
    }
}
