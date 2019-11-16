package java.JAVA8新特性;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream类为集合操作做出了极大简化!Stream类主要用于集合操作的遍历,过滤,排序,匹配等操作
 * PS: 同一个stream只能操作一次,重复操作会引发错误: stream has already been operated upon or closed
 */
public class Stream类 {

    /**
     * Stream类使用的基本流程,需要记住
     */
    @Test
    public void 基本流程(){
        //1. 首先初始化流
        Stream<Integer> stream = Stream.of(5, 3, 2, 7, 1);

        //2. 对流进行操作,以排序示例
        Stream<Integer> sorted = stream.sorted();

        //3. 获取操作后的数据,用stream对象的collect()方法获取操作后的数据
        List<Integer> collect = sorted.collect(Collectors.toList());

        System.out.println(collect);
    }

    /**
     * Java中的Stream的所有操作都是针对流的，所以，使用Stream必须要得到Stream对象
     * 有3种获取stream对象的方法
     */
    @Test
    public void 初始化流(){
        Integer[] integers = {3, 4, 5, 1, 11, 41, 12};
        List<Integer> intList = Arrays.asList(integers);

        //1. Stream的of方法可以接收单个或复数个Object对象转化为Stream;
        Stream<Integer> stream1 = Stream.of(3, 4, 5, 1, 11, 41, 12);
        Stream<Integer> stream2 = Stream.of(integers);
        Stream<List<Integer>> stream3 = Stream.of(intList);

        //2. 数组转换为流,也可以使用Arrays的静态方法stream(T[] array)
        Stream<Integer> stream4 = Arrays.stream(integers);

        //3. 集合对象转换为流
        // Collection接口内有默认方法default Stream<E> stream() {...},所有Collection的实现类都有stream()方法
        Stream<Integer> stream5 = intList.stream();
    }

    @Test
    public void 流转化为其他数据结构(){
        Stream<Integer> stream = Stream.of(5, 3, 2, 7, 1);
        Stream<Integer> sorted = stream.sorted();

        //TODO
        //sorted.collect()
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
        List<Integer> collect = stream_1.collect(Collectors.toList());
        System.out.println(collect);

    }

    /**
     * 过滤操作: Stream<T> filter(Predicate<? super T> predicate)
     * 传入过滤规则(一个函数),来过滤集合
     */
    @Test
    public void filter_(){
        Stream<Integer> stream = Stream.of(-3, 4, -5, 1, 11, -41, 12);
        List<Integer> collect = stream.filter(x -> x < 0 && x > -4)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 自定义循环操作: void forEach(Consumer<? super T> action)
     */
    @Test
    public void forEach_(){
        Stream<Integer> stream = Stream.of(-3, 4, -5, 1, 11, -41, 12);
        //forEach()方法没有返回值
        stream.forEach(x -> {x=-x; System.out.print(x + ", ");});
    }

    /**
     * Stream<T> skip(long n) 去除集合中前n个元素
     * Stream<T> limit(long maxSize) 获取集合中前maxSize个元素
     */
    @Test
    public void limit_skip_(){
        Stream<Integer> stream = Stream.of(-3, 4, -5, 1, 11, -41, 12);
        List<Integer> collect = stream.skip(3).limit(2).collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * Optional<T> min(Comparator<? super T> comparator)
     * Optional<T> max(Comparator<? super T> comparator)
     * 返回集合中最小/大的值
     * Optional是一个容器类,用于规避空指针异常.
     */
    @Test
    public void min_max_(){
        Stream<Integer> stream = Stream.of(-3, 4, -5, 1, 11, -41, 12);
        Optional<Integer> min = stream.min((x, y) -> {
            if (x > y) return 1;
            if (x < y) return -1;
            return 0;
        });
        System.out.println(min);
        //max()使用方法同min()
    }

    /**
     * Stream<T> sorted() 对集合排序,不传参则默认升序,可传入lambda表达式自定义排序
     * Stream<T> distinct() 去除重复元素
     */
    @Test
    public void sort_distinct_(){
        Stream<Integer> stream = Stream.of(-3, 4, -5, 1, 11, -41, 12, 12);
        Stream<Integer> sorted = stream.sorted();
        Stream<Integer> distinct = sorted.distinct();
        System.out.println(distinct.collect(Collectors.toList()));

    }

    /**
     * boolean allMatch(Predicate<? super T> predicate)
     * boolean anyMatch(Predicate<? super T> predicate)
     * boolean noneMatch(Predicate<? super T> predicate)
     */
    @Test
    public void 各种match_(){
        Object[] objs = {1, 2, 3, "apple", "banana", ""};
        List<Object> objects = Arrays.asList(objs);

        //全部元素都匹配才返回true
        Stream<Object> stream = objects.stream();
        boolean allMatch = stream.allMatch(obj -> obj.toString().matches("."));
        System.out.println(allMatch);

        //任一元素匹配就返回true
        Stream<Object> stream1 = objects.stream();
        boolean anyMatch = stream1.anyMatch(obj -> obj.toString().matches("."));
        System.out.println(anyMatch);

        //全部元素不匹配才返回true
        Stream<Object> stream2 = objects.stream();
        boolean noneMatch = stream2.noneMatch(obj -> obj.toString().isEmpty());
        System.out.println(noneMatch);

    }

    /**
     * reduce()方法是用来对stream中的元素进行聚合操作的,有3个重载方法
     * Optional<T> reduce(BinaryOperator<T> accumulator)
     * T reduce(T identity, BinaryOperator<T> accumulator)
     * <U> U reduce(U identity,
     *                  BiFunction<U, ? super T, U> accumulator,
     *                  BinaryOperator<U> combiner);
     */
    @Test
    public void reduce_(){
        //1. 传入有2个参数的函数,进行聚合操作
        Stream<Integer> stream1 = Stream.of(2, 2, 2);
        Optional<Integer> reduce1 = stream1.reduce((x, y) -> x * y);
        System.out.println(reduce1.get());

        //2. 第一个参数是stream流外的一个元素,以此元素为基础聚合
        Stream<Integer> stream2 = Stream.of(2, 2, 2);
        Integer reduce2 = stream2.reduce(2, (x, y) -> x * y);
        System.out.println(reduce2);

        //3.可以把聚合的结果变成其他类型.
        //第三个参数是并行的时候用的到,串行的时候没用.
        //暂时不太了解,先TODO
        //TODO
        Stream<Integer> stream3 = Stream.of(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        Long reduce3 = stream3.reduce(0L, (x, y) -> x + y, (a, b) -> null);
        System.out.println(reduce3);

    }

}
