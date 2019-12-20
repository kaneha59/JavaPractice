package java基础.IO流;

import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;

/**
 * BufferedReader实际上也是依靠StreamDecoder来实现功能...
 * 因为new BufferedReader()是需要传入一个Reader子类对象
 * 而InputStreamReader内部实现完全依靠StreamDecoder
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
            reader = new BufferedReader(
                    new FileReader(filePath + fileName, Charset.forName("UTF-8")));
            writer = new BufferedWriter(
                    new FileWriter(targetPath + fileName, Charset.forName("UTF-8")));
            String line;
            while (reader.ready()) {
                line = reader.readLine();
                writer.write(line);
            }
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
