package java基础.字符串;

import org.junit.Test;

/**
 * StringBuilder --> 线程不安全
 * StringBuffer --> 线程安全
 * 这两个类相对于String的优点是可以反复拼接字符串而不用担心巨量的资源消耗(不会反复创建新的字符串).
 * 这里只列出String没有的方法
 */
public class StringBuilder和StringBuffer {

    @Test
    public void test() {
        StringBuilder sb = new StringBuilder("  aabb  ");
        //1. 在任意下标插入内容

        //2. 获取字符串对应的下标?

        //3. replace()和String的区别?

        //4. 删除给定下标范围的字符串,或删除给定下标的字符

        //5. 字符串反转?

        //6. 获取当前StringBuilder的容量?

        //7. 设置StringBUilder的初始容量?(默认为24)

        //8. 设置StringBulder的最大长度?

        //9. 将容量空间缩减到和字符串一样的长度

        //10. 截取一段字符串并存入char数组

        //11. 截取字符串?(2种)

        //12. codePoint系列方法?
    }

    @Test
    public void test1111(){
        StringBuilder sbuilder = new StringBuilder(" abcd ");
        StringBuffer sbuffer = new StringBuffer();

        //1. trimToSize()
        //将StringBuffer对象中的存储空间缩小到和字符串长度一样的长度，减少空间的浪费
        //ArrayList同样有该方法,作用是去除动态增长的多余容量
        sbuilder.trimToSize();
        System.out.println(sbuilder);

        //2. capacity()
        //返回当前容量
        int capacity = sbuilder.capacity();
        System.out.println(capacity);

        //3. ensureCapacity(int minimumCapacity)
        //设置StringBuilder的容量,如果字符串拼接频繁,频繁扩容会极大降低效率
        //如果给StringBuilder先设置一个较大的容量,就可以避免频繁扩容
        sbuilder.ensureCapacity(10);

        //4. setCharAt(int index, char ch)
        //将指定index的char替换,String没有此功能,也没有delete()
        sbuilder.setCharAt(0, 'A');
        System.out.println(sbuilder);

        //5. insert(重载参数)
        // 在指定index插入内容
        StringBuilder xyz = sbuilder.insert(6,  "xyz");
        System.out.println(xyz);

        //6. setLength(int newLength)
        // 设置StringBuilder的长度,超出的会被剪掉
        sbuilder.setLength(3);
        System.out.println(sbuilder);
    }
}
