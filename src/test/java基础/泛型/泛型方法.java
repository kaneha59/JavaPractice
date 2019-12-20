package java基础.泛型;

import org.junit.Test;

public class 泛型方法 {
    /**
     * 注意区分泛型方法和泛型类!!!!
     * 只有在返回值前声明泛型的方法才叫泛型方法,仅仅用到泛型并不是泛型方法!
     * @param t
     * @param <T>
     */
    public <T extends Fruit> void showName(T t) {
        t.showName();
    }

    @Test
    public void Test() {
        showName(new Banana("黄皮香蕉!"));
    }
}
