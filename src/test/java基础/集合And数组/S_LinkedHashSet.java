package java基础.集合And数组;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class S_LinkedHashSet {
    LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

    @Before
    public void init() {
        String[] strs = new String[] {"apple", "banana", "canada", "canada"};
        linkedHashSet.addAll(Arrays.asList(strs));
    }

    @Test
    public void test() {
        System.out.println(linkedHashSet);
    }
}
