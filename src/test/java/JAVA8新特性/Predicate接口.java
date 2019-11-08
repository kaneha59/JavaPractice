package JAVA8新特性;

import org.junit.Test;

import java.util.function.Predicate;

/**
 * 断言型接口Predicate,用于做判断
 * Predicate是函数式接口,Lambda表达式实际上是传入了一个函数
 */
public class Predicate接口 {

    @Test
    public void and_(){
        Predicate<Integer> predicate = x -> x < 10;//传入了一个函数(参数: x, 函数体: x < 10)
        predicate = predicate.and(x -> x % 2 != 0);//and()就是在原有的条件上,追加新的条件(x%2 != 0)

        System.out.println(predicate.test(7));//test()方法实际上就是自己刚刚传入的函数
        System.out.println(predicate.test(6));
    }

    @Test
    public void or_(){
        Predicate<String> predicate = s -> s.contains("a");
        predicate = predicate.or(s -> s.contains("b"));

        System.out.println(predicate.test("pig"));
        System.out.println(predicate.test("apple"));
        System.out.println(predicate.test("bubble"));
    }

    @Test
    public void negate_(){
        Predicate<Integer> predicate = x -> x <10;
        predicate = predicate.and(a -> a > 5);//这里a和x其实是同一个东西...
        predicate = predicate.negate();//对原判断条件取反

        System.out.println(predicate.test(6));
        System.out.println(predicate.test(99));
    }

    @Test
    public void not_(){
        Predicate<Integer> predicate = x -> x <10;
        predicate = predicate.and(a -> a > 5);//这里a和x其实是同一个东西...
        predicate = predicate.negate();//对原判断条件取反
        Predicate<Integer> not = Predicate.not(predicate);//静态方法not()也是取反,实际上底层还是调用了negate()方法

        System.out.println(not.test(6));
        System.out.println(not.test(99));
    }

    @Test
    public void isEqual_(){
        //TODO
    }
}
