package java基础.IO流;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;

/**
 * BufferedReader实际上也是依靠StreamDecoder来实现功能...
 * 因为new BufferedReader()是需要传入一个Reader子类对象,比如InputStreamReader
 * 而InputStreamReader内部实现完全依靠StreamDecoder
 *
 * BufferReader使用简介:
 *      1.new输入流和输出流对象(需传入Reader和Writer的实例)
 *      2.while循环, ready()作为循环条件,判断输入流是否准备好读取
 *      3.在while循环中,readLine()读入一行,write()写出文件
 *      4.close()
 *      关于flush(): 缓冲区写满了才会一次性输出数据,而flush()会强制刷新(输出)缓冲区的数据,不必等到缓冲区满
 *      flush()和close()的区别:
 *          * close(): 先刷新缓冲区,再关闭流
 *          * flush(): 刷新缓冲区,不关闭流
 */
public class BufferedReader类 {
    BufferedReader reader;
    BufferedWriter writer;
    String filePath = "C:/testFile/";
    String targetPath = "C:/testFile/file1/";
    String fileName = "IO流基础知识点.txt";
    @Test
    public void test() {
        try {
            reader = new BufferedReader(new FileReader(filePath + fileName, Charset.forName("UTF-8")));
            writer = new BufferedWriter(new FileWriter(targetPath + fileName, Charset.forName("UTF-8")));
            String line;
            while (reader.ready()) {
                line = reader.readLine();
                writer.write(line);
            }
            writer.flush();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
