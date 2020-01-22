package java基础.集合And数组;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 相比于List接口,多了以下方法:
 *      1.ensureCapacity()
 *      2.trimToSize()
 *      3.clone()
 * 没啥好说的...基本跟List的用法一样
 */
public class L_ArrayList类 {
    ArrayList arrayList;

    @Test
    public void test() {
        System.out.println(arrayList);

        Object clone = arrayList.clone();

        arrayList.ensureCapacity(20);

        arrayList.trimToSize();
    }

    @Before
    public void init() {
        arrayList = new ArrayList();
        StringBuilder sb;
        for (int i = 0; i < 10; i++) {
            sb = new StringBuilder("No.").append(i);
            arrayList.add(sb.toString());
        }
    }
}
