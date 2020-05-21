package java基础.集合And数组;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class Z_迭代器用法 {
    private List<String> list;

    /**
     * 用途: 迭代器可用于遍历List和Set,Map也可以通过转成Set的方式使用迭代器
     * 特点: 遍历时可以安全地删除元素
     * Iterator<E>的方法有:
     * hasNext(): 判断容器中是否还有元素
     * next(): 取出下一个元素(不要重复调用)
     * remove(): 移除当前元素(必须在next方法后使用)
     * forEachRemaining(Consumer<? super E> action)
     */
    @Test
    public void 迭代器用法() {
        Iterator<String> iterator = list.iterator();

        // 1.hasNext(), next(), remove()的用法示例
        while (iterator.hasNext()) {
            String nextStr = iterator.next();
            if("第三个".equals(nextStr)) {
                iterator.remove();
                System.out.println("此时集合中已经移除该元素");
            }
        }
        System.out.println(list);

        // 一个迭代器只能使用一次,所以下边两个方法不会生效.
//         2.forEachRemaining(Consumer<? super E> action)
        // 使用消费者模式遍历集合,不能删除元素
        // 2.1)Lambda表达式用法
//        iterator.forEachRemaining(str -> System.out.println(str));
        // 2.2)方法引用用法
//        iterator.forEachRemaining(System.out::print);
        // Set的迭代器用法省略,和List一样
    }

    /**
     * list迭代器相对于普通迭代器新增了方法如下:
     * nextIndex(): 返回下一个元素的index
     * add(): 在下一个元素前(当前元素后)添加新元素
     * set(): 改变当前元素
     * hasPrevious(): 是否存在上一个元素
     * previousIndex(): 上一个元素的index
     * previous(): 获取上一个元素(并使迭代器上移一位)
     * 总结: 获得了1.访问index的能力 2.新增和修改的能力 3.前移的能力(previous系列)
     */
    @Test
    public void list迭代器() {
        ListIterator<String> listIterator = list.listIterator();
        // 1.nextIndex()和add()方法的使用
        System.out.println(listIterator.nextIndex());
        listIterator.add("add...");
        System.out.println(listIterator.nextIndex());
        // 2.hasNext(),next()传统用法
        while(listIterator.hasNext()) {
            String nextStr = listIterator.next();
            System.out.print(nextStr + ", ");
        }
        // 3.hasPrevious(), previousIndex(), previous(), set()的用法
        if(listIterator.hasPrevious()) {
            System.out.println("\r");
            System.out.println("previousIndex: " + listIterator.previousIndex());
            System.out.println("previousElement: " + listIterator.previous());
            listIterator.set("set了第六个");
            System.out.println("nextIndex: " + listIterator.nextIndex());
            System.out.println("nextElement: " + listIterator.next());
        }
        listIterator.add("最后新增一个元素");

        System.out.println("\r总结: " + list);
    }

    /**
     * ListIterator<E> listIterator(int index);
     * 可以指定从第几个index开始遍历
     */
    @Test
    public void list迭代器重载方法() {
        ListIterator<String> listIterator = list.listIterator(3);
        listIterator.previous();
        listIterator.previous();
        listIterator.forEachRemaining(System.out::print);
    }

    /**
     * TODO
     */
    @Test
    public void spliterator_() {
        Spliterator<String> spliterator = list.spliterator();
        int characteristics = spliterator.characteristics();
        System.out.println(characteristics);
    }
    @Before
    public void initList() {
        list = new ArrayList<>();
        list.add("第一个");
        list.add("第二个");
        list.add("第三个");
        list.add("第四个");
        list.add("第五个");
        list.add(5, "第六个");
        System.out.println("初始化: " + list);
    }
}
