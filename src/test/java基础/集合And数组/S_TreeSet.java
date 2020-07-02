package java基础.集合And数组;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.TreeSet;

public class S_TreeSet {
    TreeSet<String> treeSet = new TreeSet<>();

    @Before
    public void init() {
        String[] strs = new String[] {"apple", "banana", "canada", "canada"};
        treeSet.addAll(Arrays.asList(strs));
    }

    @Test
    public void test() {
        System.out.println(treeSet);
    }

}
