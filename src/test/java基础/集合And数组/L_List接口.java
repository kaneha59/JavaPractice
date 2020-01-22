package java基础.集合And数组;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
/**
 * 方法总览:
 * 1.增删改查: add(), remove(), set(), get(), addAll(), removeAll()
 * 2.判断: contains(), containsAll(), isEmpty()
 * 3.排序: sort()
 * 4.遍历: forEach()
 * 5.转数组: toArray()
 * 6.寻下标: indexOf(), lastIndexOf()
 * 7.清空List: clear()
 * 8.子list: subList()
 * 9.还不懂的:TODO
 *          boolean retainAll(Collection<?> c);
 *          default void replaceAll(UnaryOperator<E> operator)
 */
public class L_List接口 {
    private List<String> list;

    /**
     * 可以把subList理解为父list的视图:
     *      1.在subList中新增(删除)元素,会影响到父list
     *      2.建立subList后再在父list新增(删除)元素后,再调用subList会报异常
     */
    @Test
    public void subList_() {
        List<String> subList = list.subList(2, 4);
        subList.add("这是subList新增的");

        // 明明给subList单独add了新的元素,为什么list仍然包含subList呢?
        System.out.println(list.containsAll(subList));

        // 打印subList和list
        System.out.println(subList);
        System.out.println(list);

        // 修改list后再使用subList会报异常ConcurrentModificationException
        list.add("list's new Element");
        System.out.println(subList);
    }
    /**
     * void add(int index, E element);
     * 在指定index插入元素,后边的元素相应后移
     */
    @Test
    public void add的重载方法() {
        System.out.println(list);
        list.add(4, "在index:4 插入新元素");
        System.out.println(list);
    }

    /**
     * E remove(int index)的重载方法:
     *      boolean remove(Object o);
     *      效果: 删除第一个找到的元素(按照index顺序)
     */
    @Test
    public void remove重载方法() {
        String first = "第一个";
        // 1.追加5个元素: "第一个"
        for (int i = 0; i < 5; i++) {list.add(first);}
        System.out.println(list);
        // 2.调用remove(Object o)一次
        list.remove(first);
        System.out.println(list);
        // 3. 继续删除list内所有"第一个"
        while (list.contains(first)) {
            list.remove(first);
        }
        System.out.println(list);

    }

    /**
     * default void forEach(Consumer<? super T> action) {...}
     * 消费者模式遍历list
     */
    @Test
    public void forEach_() {
        list.forEach(System.out::println);
        Spliterator<String> spliterator = list.spliterator();
        spliterator.forEachRemaining(System.out::print);
    }

    @Before
    public void initList() {
        list = new ArrayList<>();
        list.add("第一个");
        list.add("第二个");
        list.add("第三个");
        list.add("第四个");
        list.add("第五个");
        list.add("第六个");
    }
}
