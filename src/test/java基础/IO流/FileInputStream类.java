package java基础.IO流;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Date;

/**
 * 使用BufferedInputStream的read()和FileInputStream的read()有什么区别?
 */
public class FileInputStream类 {
    Date before;
    Date after;
    String filePath = "C:/迅雷下载/";
    String targetPath = "C:/testFile/金羽/";
    String fileName = "ABP-523 ひたすら生でハメまくる、終らない中出し**。 北野のぞみ.mp4";
    @Test
    public void 以byte为单位传输() {
        try {
            // 龟速运行
            FileInputStream inStream = new java.io.FileInputStream(filePath + fileName);
            FileOutputStream outStream = new FileOutputStream(targetPath + fileName);
            int i = 0;
            while(i != -1) {
                i = inStream.read();//返回值范围: -1到255, 1Byte=8bit=2的8次方
                outStream.write(i);
            }
            inStream.close();
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void 以byte数组为单位传输() {
        // 2.2G小电影耗时大约30s
        try {
            FileInputStream inStream = new FileInputStream(filePath + fileName);
            FileOutputStream outStream = new FileOutputStream(targetPath + fileName);

            byte[] bytes = new byte[1024];
            while(inStream.read(bytes) != -1) {
                outStream.write(bytes);
            }
            inStream.close();
            outStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void 用缓冲流传输() {
        // 2.2G小电影耗时约13秒
        try {
            FileInputStream inStream = new FileInputStream(filePath + fileName);
            FileOutputStream outStream = new FileOutputStream(targetPath + fileName);

            BufferedInputStream bis = new BufferedInputStream(inStream);
            BufferedOutputStream bos = new BufferedOutputStream(outStream);
            byte[] bytes = new byte[1024];
            while (bis.read(bytes) != -1) {
                bos.write(bytes);
            }
            bos.flush();

            bis.close();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Before
    public void before() {
        before = new Date();
    }

    @After
    public void after() {
        after = new Date();
        System.out.println(
                "耗时: "
                + (after.getTime() - before.getTime())/1000
                + "秒"
        );
    }
}
