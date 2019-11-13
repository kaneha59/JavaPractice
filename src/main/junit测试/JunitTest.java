package junit测试;

public class JunitTest {
    public StringBuilder test(){
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
        return sbuilder;
    }
}
