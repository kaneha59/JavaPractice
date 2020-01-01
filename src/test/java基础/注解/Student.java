package java基础.注解;

import org.junit.Test;
import java.lang.reflect.Method;

@Human(value = true, name = "Tom")
public class Student {

    public void showName(String name){
        System.out.println("my name is: " + name);
    }
    @Test
    public void test() {
        Class stuClass = Student.class;
        // 是否有注解
        boolean hasAnnotation = stuClass.isAnnotationPresent(Human.class);
        if(hasAnnotation) {
            // 使用getAnnotation()
            Human humanAnno = Student.class.getAnnotation(Human.class);
            try {
                Method[] methods = stuClass.getMethods();
                for (Method m : methods) {
                    if(m.getName().equals("showName")) {
                        m.invoke(new Student(), humanAnno.name());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
