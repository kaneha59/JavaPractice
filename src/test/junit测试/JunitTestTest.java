package junit测试;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class JunitTestTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1() {
        try {
            this.getsome();
        } catch (Exception e) {
            System.out.println("我抓到了异常!");
            e.printStackTrace();
        }
    }

    public void getsome() {
        this.getsome1();
    }

    public Object getsome1 () {
        ArrayList list = new ArrayList<>();
        return list.get(5);
    }

}