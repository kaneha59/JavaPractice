package JAVA8新特性;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream类 {

    /**
     * Stream类为集合操作做出了极大简化!Stream类主要用于集合操作
     * Java中的Stream的所有操作都是针对流的，所以，使用Stream必须要得到Stream对象
     * 有3种初始化方法
     */
    @Test
    public void 初始化流(){
        Integer[] integers = {3, 4, 5, 1, 11, 41, 12};
        List<Integer> intList = Arrays.asList(integers);

        //Stream的of方法可以接收单个或复数个Object对象转化为Stream;
        Stream<Integer> stream1 = Stream.of(3, 4, 5, 1, 11, 41, 12);
        Stream<Integer> stream2 = Stream.of(integers);
        Stream<List<Integer>> stream3 = Stream.of(intList);

        //数组转换为流,也可以使用Arrays的静态方法stream(T[] array)
        Stream<Integer> stream4 = Arrays.stream(integers);

        //集合对象转换为流
        // Collection接口内有默认方法default Stream<E> stream() {...},所有Collection的实现类都有stream()方法
        Stream<Integer> stream5 = intList.stream();
    }

    /**
     * 遍历操作:  <R> Stream<R> map(Function<? super T, ? extends R> mapper)
     * map()方法中传入的函数,必须有返回值! 
     */
    @Test
    public void map_(){
        Stream<Integer> stream = Stream.of(-3, 4, -5, 1, 11, -41, 12);
        //map中传入的函数,必须要有返回值
        Stream<Integer> stream_1 = stream.map(n -> n + 1);//此处其实返回了n的值,但是lambda表达式中省略了
        Stream<Integer> stream_2 = stream_1.map(Math::abs);
        List<Integer> collect = stream_2.collect(Collectors.toList());
        System.out.println(collect);

    }

    /**
     * 过滤操作: Stream<T> filter(Predicate<? super T> predicate)
     * 传入过滤规则(一个函数),来过滤集合
     */
    @Test
    public void filter_(){
        Stream<Integer> stream = Stream.of(-3, 4, -5, 1, 11, -41, 12);
        List<Integer> collect = stream.filter(x -> x < 0)
                .collect(Collectors.toList());
        System.out.println(collect);
    }
    @Test
    public void test(){
        Integer[] integers = {11, 5, 5, 2, 91, 8,21};
        List<Integer> intList = Arrays.asList(integers);


        Stream<Integer> stream = intList.stream();

        Stream<Integer> integerStream = stream.filter(x -> x < 20);

        List<Integer> collect = integerStream.collect(Collectors.toList());
        System.out.println(collect);

    }
}
