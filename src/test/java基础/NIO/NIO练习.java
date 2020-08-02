package java基础.NIO;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * 参考学习站点:
 * https://blog.csdn.net/u011381576/article/details/79876754
 */
public class NIO练习 {
    @Test
    public void test() {
        String file = "C:\\coding\\测试目录\\NIO测试.txt";
        RandomAccessFile rAccess = null;

        try {
            rAccess = new RandomAccessFile(file, "rw");
            FileChannel channel = rAccess.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while(channel.read(buffer) != -1) {
                buffer.flip();

//                while (buffer.hasRemaining()) {
//                    System.out.print((char)buffer.get());
//                }
                buffer.compact();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert rAccess != null;
                rAccess.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 可以把buffer看作一个'列表',列表上有3个指针
     * [  1,         2,        3      ]
     * position            capacity
     *                      limit
     * capacity: 表示缓冲区的总长度,总是指向'列表'最后一个元素
     * position: 起始位置
     * limit: 结束位置+1或等于capacity
     * ---------------------------------------------------------------------
     * Buffer常用的类有
     *      1.ByteBuffer, CharBuffer等, 对应8种数据类型
     *      2.其他: MappedByteBuffer, HeapByteBuffer, DirectByteBuffer等
     */
    @Test
    public void Buffer类() {
        //还有其他好多Buffer类,比如CharBuffer等,对应8种基本数据类型
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.flip(); // limit=position  /  position=0  /  mark=-1  (相当于选中buffer中的未读数据)
        buffer.compact();// 1.将pos-limit之间的未读数据移动到buffer最前端 2.并把pos设置到未读数据新位置的正后方,limit设置到capacity处
        buffer.clear();// position=0  /  limit=capacity  /  mark=-1 (清空数据,实际上并未清空,只是把指针重置了)
        buffer.hasRemaining();// 返回pos-limit之间是否还有元素
        buffer.rewind();//position=0  /  mark=-1 (rewind意为倒带)

        buffer.get();// 读取position处的1byte数据,并把position后移一位
        buffer.getLong();// 读取position处的8byte数据,并把position后移8位,合并8byte为long数据并返回
        buffer.getChar();// 读取position处的2byte数据,并把position后移2位,合并2byte为char数据并返回

        buffer.position();// 返回position值
        buffer.limit();//返回limit值
        buffer.capacity();//返回capacity值

        //TODO 还有好多方法......
    }

    /**
     * 主要的Channel实现类:
     *      1.FileChannel
     *      2.DatagramChannel
     *      3.SocketChannel
     *      4.ServerSocketChannel
     */
    @Test
    public void Channel类() {

    }
}
