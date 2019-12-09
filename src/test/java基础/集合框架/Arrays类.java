package java基础.集合框架;

import java其他内容.多线程.Dog;
import java基础.随便写写.Person;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Arrays类 {
    int[] ints = new int[] {1, 2, 3, 4, 3, 2, 1};
    Student[] students = new Student[] {new Student("John"), new Student("Marry")};

    @Test
    public void test() {
        // 有几个jdk1.8及之后版本加入的方法没还没搞明白.

        //1.
    }

    /**
     * Arrays.toString();
     * 这下终于可以把数组内容打印出来了(引用类型要重写toString()方法)
     */
    @Test
    public void toString_() {
        String s = Arrays.toString(ints);
        System.out.println(s);
        String s1 = Arrays.toString(students);
        System.out.println(s1);
    }

    /**
     * Arrays.stream();
     */
    @Test
    public void stream_() {
        Stream<Student> stream = Arrays.stream(students);
        stream.forEach(x -> System.out.println(x));
        stream.close();
    }

    /**
     * Arrays重写的equals(),用于比较两个数组;
     * Arrays.equals(Object[] a, Object[] a2)底层是调用数组object元素的equals()方法
     * 因此建议重写该元素实际的类的equals()方法.
     * ---因为java多态的缘故,该元素实际上调用的是自身重写的equals()方法---
     */
    @Test
    public void equals_() {
        boolean equals = Arrays.equals(ints, new int[]{1, 2, 3, 4});
        System.out.println(equals);
        boolean equals1 = Arrays.equals(students, new Student[]{new Student("John"), new Student("Marry")});
        //因为重写了Student类的equals()方法,所以此处返回true
        //  如果没有重写equals()方法,则默认用Object的equals(),比较元素的内存地址
        System.out.println(equals1);
    }

    /**
     * Arrays.sort();
     * 为符合数据类型排序需要重写compareTo()方法
     * 或者用重载方法Arrays.sort(T[] a, Comparator<? super T> c)
     */
    @Test
    public void sort_() {
        Arrays.sort(ints, 4, 7);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * Arrays.parallelSort()
     * JDK 1.8
     * parallel意思是并行.
     * parallelSort()用并发排序,基于fork/join
     * sort()用快速排序
     */
    @Test
    public void parallelSort_() {
        Arrays.parallelSort(ints, 1, 7);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * Arrays.asList()有几点要重点关注:
     * public static <T> List<T> asList(T... a){...}
     * 1. 不能用于基本数据类型. 原因看上边的asList()方法定义
     * 2. 该方法返回的ArrayList不是List接口的实现类ArrayList,而是Arrays的一个内部类ArrayList
     * 3. 该ArrayList的长度固定,因为其内部维护元素的数组E[] a是final的!
     * 4. 长度固定,所以改变长度,增删元素都会报错.
     * 5. 解决方法:把该ArrayList导入另外一个集合.
     */
    @Test
    public void asList_() {
        List<Student> students = Arrays.asList(this.students);

        List<Student> arrayList = new ArrayList(students);
        System.out.println(arrayList);
    }

    /**
     * binarySearch()用二分法查找key对应的index,要求数组必须有序!
     */
    @Test
    public void binarySearch_() {
        // 数组必须有序才能使用binarySearch()
        Arrays.sort(ints);
        int resultIndex = Arrays.binarySearch(ints, 4, 6, 3);
        System.out.println(resultIndex);
        // 引用数据类型的用法同基本数据类型
    }

    /**
     * copyOf()
     * 用于给数组扩容
     * 将数组复制进一个新的自定义长度数组,并返回此新数组.
     */
    @Test
    public void copyOf_() {
        int[] ints = Arrays.copyOf(this.ints, 10);
        System.out.println(ints.length);
        System.out.println(Arrays.toString(ints));

        Student[] students = Arrays.copyOf(this.students, 5);
        System.out.println(Arrays.toString(students));
    }

    /**
     * copyOfRange()
     * 截取数组,返回截取的新数组.
     */
    @Test
    public void copyOfRange_() {
        int[] ints = Arrays.copyOfRange(this.ints, 2, 4);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * fill()
     * 将数组中所有的元素变成指定元素.
     */
    @Test
    public void fill_() {
        Arrays.fill(ints, 99);
        System.out.println(Arrays.toString(ints));
        Arrays.fill(students, new Student("jinyu"));
        System.out.println(Arrays.toString(students));
    }

    /**
     * mismatch()
     * 判断两个数组第一个不相等的元素的下标是多少
     * 默认从0开始比较,重载方法可以指定比较的区间
     * 引用数据类型使用equals()来判断
     * JDK 9
     */
    @Test
    public void mismatch_() {
        System.out.println(Arrays.mismatch(ints, new int[]{1, 2, 7, 9}));
        System.out.println(Arrays.mismatch(new int[]{1, 2, 3, 4}, ints));
        System.out.println(Arrays.mismatch(ints, new int[]{1, 2, 3, 4, 3, 2, 1}));
        int mismatch = Arrays.mismatch(ints, 3, 7,
                new int[]{4, 3, 99, 1}, 0, 4);
        System.out.println(mismatch);

        int result = Arrays.mismatch(students, new Student[]{new Student("John")});
        System.out.println(result);
    }

    /**
     * TODO
     */
    @Test
    public void parallelPrefix_() {
//        Arrays.parallelPrefix(ints, 1, 4, );
    }

    /**
     * TODO
     * JDK 1.8
     */
    @Test
    public void parallelSetAll_() {
//        Arrays.parallelSetAll();
    }

    /**
     * TODO
     * JDK 1.8
     */
    @Test
    public void setAll_() {
//        Arrays.setAll();
    }

    /**
     * TODO
     * JDK 1.8
     */
    @Test
    public void spliterator() {
//        Arrays.spliterator(ints);
    }

    /**
     * compare()
     * 将两个数组首个mismatch的元素的大小进行compare()比较,返回比较结果
     * JDK 9
     */
    @Test
    public void compare_() {
        //....
        System.out.println(Arrays.compare(ints, new int[]{6, 7, 8}));

    }

    /**
     * TODO
     * JDK 9
     */
    @Test
    public void compareUnsigned_() {
        System.out.println(Arrays.compareUnsigned(ints, new int[]{6, 7, 8}));
    }

    /**
     * 一个学生
     */
    private class Student {
        String name;
        public Student(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            Student stu1 = null;
            if(o instanceof Student) {
                stu1 = (Student)o;
            }else{
                return false;
            }

            if(this.name.equals(stu1.name)){
                return true;
            }

            return false;
        }
    }
}
