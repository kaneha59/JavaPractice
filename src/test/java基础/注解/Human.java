package java基础.注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解的成员变量声明方式和类不一样,需要加上小括号.
 * 注解可以配合java反射从而发挥更强大的作用
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Human {
    // value() 成员变量很特殊
    // 如果注解中只有value一个变量,或者其他变量都有默认值时,
    // 使用注解可以直接填值,像这样@Human(true)
    boolean value() default true;

    // 没有默认值时,使用注解时必须给属性赋值
    String name();

    // 有默认值时,使用时无需手动赋值
    String[] characters() default {"straightforward", "optimistic", "independent"};
}
