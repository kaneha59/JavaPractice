package java基础.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 *    ./    ===> 指当前目录
 *    ../   ===> 指上一层目录
 *    /     ===> 指当前盘符的根目录,例如D:\
 *    啥也不写  ===> 指当前项目所在目录
 */
public class File类 {
    File localFile = new File("testFile/localFile.txt");
    File file = new File("C:/testFile/", "file.txt");
    @Test
    public void test() {
        File file1 = new File("C:/fileTest1");
        File[] files = file1.listFiles((path) -> {
            System.out.println(path.getAbsolutePath());
            return true;
        });
        file1.listFiles(((dir, name) -> {
            System.out.println(dir.getAbsolutePath());
            return true;
        }));
    }

    /**
     * 3种创建方法
     * 创建File对象后并没有生成对应的文件夹和文件,生成的只是一个包含了虚拟路径的File对象
     */
    @Test
    public void File实例化() {
        //1. 传入(String path)
        File file1 = new File("/fileTest1/testFile1/./file1.txt");

        //2. 传入(String parent, String child)
        File file2 = new File("C:/fileTest2/", "file2.txt");

        //3. 传入(File parent, String child)
        File file3 = new File(new File("C:/fileTest3"), "file3.txt");

        //4. 传入(URI uri)
        File file4 = new File(file1.toURI());
    }

    /**
     * mkdir();
     * mkdirs();
     * createNewFile();
     */
    @Test
    public void 创建文件夹和文件() {
        File file1 = new File("/fileTest1/testFile1/./file1.txt");
        File file2 = new File("C:/fileTest2/", "file2.txt");
        File file3 = new File(new File("C:/fileTest3"), "file3.txt");

        //创建一层目录
        file1.mkdir(); // fileTest1目录被创建

        //创建所有目录
        file2.mkdirs(); // 注意! : 即使是file1.txt也会被创建成目录!!!!

        //正确创建目录方法
        file3.getParentFile().mkdirs(); // file1.txt之前的所有目录被创建

        //创建文件
        try {
            // 注意: 如果文件之前的目录没有先被创建的话,会报错!
            //       不要直接用mkdirs(),否则会把想创建的文件也创建成目录
            file3.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * delete() 删除虚拟路径最后一级的文件或文件夹!
     * deleteOnExit() 在程序退出时才删除文件,程序运行到该方法时并不会执行删除操作
     */
    @Test
    public void 删除文件() {
        File file1 = new File("./fileTest1/testFile1/./file1.txt");
        //创建文件夹和文件
        file1.getParentFile().mkdirs();
        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 删除文件和文件夹
        file1.delete();
        file1.getParentFile().delete();
        file1.getParentFile().getParentFile().delete();
    }

    /**
     * getParent()
     * getAbsolutePath()
     * getCanonicalPath()
     * getParentFile()
     * getAbsoluteFile()
     * getCanonicalFile()
     * getPath()
     * getName()
     * getFreeSpace()
     * getTotalSpace()
     * getUsableSpace()
     */
    @Test
    public void 各种get() {
        File file1 = new File("./fileTest1/testFile1/./../file1.txt");

        file1.getParent(); // 1.1 获取父级路径的String
        file1.getAbsolutePath();// 1.2 获取绝对路径(从盘符打头的绝对路径)
        try {
            // 1.3 获取标准的Absolute路径(去除/  ./ ../ 这种)
            file1.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        file1.getParentFile(); // 2.1 获取父级路径的File对象
        file1.getAbsoluteFile(); // 2.2 获取绝对路径的File对象
        try {
            // 2.3 获取标准Absolute路径的File对象(去除 /  ./  ../)
            file1.getCanonicalFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. 获取当前file对象的虚拟路径(包括最后一层)
        file1.getPath();

        // 4. 获取最后一级的文件或文件夹的名字
        file1.getName();

        // 5. 获取当前磁盘(剩余/总/可用)空间
        File file2 = new File("./");
        int gByte = 1024 * 1024 * 1024;
        System.out.println(file2.getFreeSpace() / gByte);
        System.out.println(file2.getTotalSpace() / gByte);
        System.out.println(file2.getUsableSpace() / gByte);
    }

    /**
     * setExecutable()
     * setLastModified()
     * setReadable()
     * setReadOnly()
     * setWritable()
     */
    @Test
    public void 各种set() {
        File file1 = new File("C:/金羽/总结/注解.txt");
        file1.setExecutable(true);
        file1.setLastModified(10000);
        file1.setReadable(true);
//        file1.setReadOnly();
        file1.setWritable(true);
    }

    /**
     * can系列和is系列以及exists()
     */
    @Test
    public void 判断的方法() {
        File file1 = new File("C:/jy/总结/注解.txt");

        file1.canExecute(); //1. 存在的文件(夹): 是否可执行
        file1.canRead(); //2. 存在的文件(夹): 是否可读
        file1.canWrite(); //3. 存在的文件(夹): 是否可写入

        file1.exists(); //4. 存在的文件(夹): 是否存在

        file1.isAbsolute(); //5. *file对象的虚拟路径*: 是否是绝对路径
        file1.isDirectory(); //6. 存在的文件(夹): 是否是文件夹
        file1.isFile(); // 7. 存在的文件(夹): 是否是文件
        file1.isHidden(); // 8. 存在的文件(夹): 是否是隐藏文件

    }

    /**
     * 1.list()和传入Lambda的重载方法
     *      public String[] list(FilenameFilter filter){...}
     * 2.listFiles()和传入Lambda的重载方法
     *      public File[] listFiles(FileFilter filter){...}
     *      public File[] listFiles(FilenameFilter filter){...}
     * 3.FilenameFilter内的方法
     *      boolean accept(File dir, String name);
     *          dir: 匹配到的文件(夹)的*目录*对应的File对象
     *          name: 匹配到的文件(夹)的名字
     * 4.FileFilter内的方法
     *      boolean accept(File pathname);
     *          pathname: 匹配到的文件(夹)对应的File对象
     */
    @Test
    public void list方法() {
        File file1 = new File("C:/金羽");

        //1. 返回文件夹下的所有文件名
        String[] list = file1.list();

        //2. 返回文件夹下所有符合条件的文件名(Lambda表达式自定义规则)
        String[] list1 = file1.list(((dir, name) -> {return true;}));

        //3. 返回文件夹下所有文件对应的File数组
        File[] files = file1.listFiles();

        //4. 返回文件夹下所有匹配的file数组, 自定义匹配规则
        File[] files1 = file1.listFiles(pathname -> {return true;});
        File[] files2 = file1.listFiles((dir, name) -> {return true;});
    }

    /**
     * renameTo() 作用比较诡异,相当于给文件剪切到新目录并重命名.
     */
    @Test
    public void 其他方法() {
        File file1 = new File("C:/金羽/aa.txt");

        //1. renameTo()传入一个File对象
        //   将原本的文件重命名并复制到入参File对象指向的路径(该路径必须存在,且路径内没有同名文件)
        //   *注意: 执行该操作会删除原本的文件*
        boolean b = file1.renameTo(new File("C:/fileTest1/aa.txt"));
        System.out.println(b);
        System.out.println(file1);

        //TODO
        file1.toURI();
        file1.toPath();
    }

}
