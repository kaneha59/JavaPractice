package java基础.集合And数组;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class M_HashMap {
    HashMap<String, String> hashMap = new HashMap<>();

    @Before
    public void init() {
        String[] strs = new String[] {"apple", "banana", "canada", "canada"};
        hashMap.put("1", "1");
        hashMap.put("2", "2");
    }

    /**
     * Map无法使用iterator迭代器
     */
    @Test
    public void test() {
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        ArrayList<Map.Entry<String, String>> entries1 = new ArrayList<>(entries);
        System.out.println(entries1);
        System.out.println(hashMap);
    }
}
