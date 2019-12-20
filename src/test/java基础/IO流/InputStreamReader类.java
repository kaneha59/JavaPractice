package java基础.IO流;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;

/**
 * InputStreamReader和OutputStreamWriter
 * ===> 可以自定义字符集编码!!!!! <===
 * FileReader自定义字符集编码需要传入Charset对象,不能简单地传入String类型
 *
 * PS: InputStreamReader没有readLine()方法;
 */
public class InputStreamReader类 {
    private InputStreamReader reader;
    private OutputStreamWriter writer;
    private InputStream is;
    private OutputStream os;

    private String filePath = "C:/testFile/";
    private String targetPath = "C:/testFile/file1/";
    private String fileName = "IO流基础知识点.txt";
    private String charset = "UTF-8";

    @Test
    public void test() {
        // 构造方法, 传入InputStream子类做入参,其他重载构造方法先不谈
        // InputStreamReader,看名字可知,基于InputStream.

        // InputStreamReader继承自Reader,实现了抽象方法
        // public abstract int read(char cbuf[], int off, int len) throws IOException;
        // 但内部实现都是调用的StreamDecoder的相关方法
        // OutputStreamWriter同理,内部实现依靠StreamEncoder

        try {
            is = new FileInputStream(filePath + fileName);
            os = new FileOutputStream(targetPath + fileName);
            reader = new InputStreamReader(is, charset);
            writer = new OutputStreamWriter(os, charset);
            char[] chars = new char[150];
            while(reader.ready()) {
                // 一个字符一个字符地输入输出
//                int read = reader.read();
//                writer.write(read);

                // 用char数组传输
                reader.read(chars);
                writer.write(chars);
            }
            reader.close();
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * FileReader类继承自InputStreamReader
     * 该类内部只有构造方法,没有其他方法
     * 构造方法实际上是调用了InputStreamReader的构造方法
     * 唯一的不同就是帮我们自动生成了FileInputStream作为入参
     * 所以本质上FileReader和InputStreamReader没有不同......
     */
    @Test
    public void FileReader类() {
        try {
            // Charset可用于创建字符集对象
            reader = new FileReader(filePath + fileName, Charset.forName("UTF-8"));
            writer = new FileWriter(targetPath + fileName, Charset.forName("UTF-8"));

            while(reader.ready()) {
                // 一个字符一个字符地传输
                int read = reader.read();
                writer.write(read);
            }

            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
