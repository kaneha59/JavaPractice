package java基础.泛型;

import org.junit.Test;

public class 泛型类 {
    private class FruitContainer<T extends Fruit> {
        void add(T t) {
            t.showName();
        }
    }

    @Test
    public void test() {
        FruitContainer container = new FruitContainer();
        container.add(new Apple("苹果"));
    }
}
