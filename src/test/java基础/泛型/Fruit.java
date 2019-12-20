package java基础.泛型;

// 水果
public class Fruit {
    String name;
    void showName(){
        System.out.println("我是" + name);
    }
    Fruit(String name) {
        this.name = name;
    }
}
// 苹果
class Apple extends Fruit {
    Apple(String name) {
        super(name);
    }
}

// 香蕉
class Banana extends Fruit {
    Banana(String name) {
        super(name);
    }
}

