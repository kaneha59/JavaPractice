package java基础.注解;

import org.junit.Test;

import java.lang.annotation.*;

public class 元注解 {
    /**
     * @Retention: 可以标明一个注解的存活期
     * RetentionPolicy.SOURCE   存活期: 源码         抛弃时机: 代码编译前
     * RetentionPolicy.CLASS    存活期: 编译阶段     抛弃时机: 加载至JVM前
     * RetentionPolicy.RUNTIME  存活期: 一直存在     抛弃时机: 无,将被加载进JVM,即使运行时也存在
     * RetentionPolicy是一个枚举类,@Retention注解内定义了一个RetentionPolicy类型的成员变量value
     * 可以戳进@Retention注解的源码查看
     */
    @Retention(RetentionPolicy.RUNTIME)
    private @interface Water {

    }

    /**
     * @Documented: 能够将注解中的元素包含到javadoc中去
     * TODO 有待进一步了解
     */
    @Documented
    private @interface secretDocument {

    }

    /**
     * @Target: 指定注解作用的位置,比如类上,方法上,形参上,等等
     * 内置一个ElementType[]类型的成员变量value,
     */
    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    private @interface isAnnotation {

    }

    /**
     * @Inherited 表示该注解可以被继承,父类使用@Inherited的注解的话,子类会自动继承该注解.仅限于extends
     * TODO 特性还有很多不清楚,抽空专门写一个类来测试@Inherited
     */
    @Inherited
    private @interface isObject {

    }

    /**
     * @Repeatable 表示该注解可以重复注解
     * 使用@Repeatable时,必须要有一个*容器注解*的Class对象,作为@Repeatable的value
     * 具体可以戳进@Repeatable查看
     * 下面是使用范例
     */
    // 容器注解,必须要有一个value属性,类型是打算装载的注解的数组,下面例子中value的类型是Flower数组
    private @interface Flowers {Flower[] value();}
    // 可重复注解
    @Repeatable(Flowers.class)
    private @interface Flower {String name();}
    // 使用范例
    @Flower(name = "yellow Flower")
    @Flower(name = "red Flower")
    @Flower(name = "white Flower")
    private class manyFlower {}
}
