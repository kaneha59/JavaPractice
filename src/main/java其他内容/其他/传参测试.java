package java其他内容.其他;

public class 传参测试<V> {

    String aaa;
    V bbb;

    传参测试( String a, V b) {
        aaa = a;
        bbb = b;
    }

    public void shot(String a, String b) {
        System.out.println("嘣!!!" + aaa + bbb);
    }

    public static void main(String[] args) {
        传参测试 test = new 传参测试<>("haha", "ffffff");
        test.shot("呀!", "哟!");
    }
}
