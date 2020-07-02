package java基础.集合And数组;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class S_HashSet {
    HashSet<String> hashSet = new HashSet<>();

    @Before
    public void init() {
        String[] strs = new String[] {"apple", "banana", "canada", "canada"};
        hashSet.addAll(Arrays.asList(strs));
    }

    @Test
    public void test() {
        System.out.println(hashSet);
    }
}
