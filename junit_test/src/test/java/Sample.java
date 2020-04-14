import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Sample {
    @Before
    public void beforeTest() {
        System.out.println("before test");
    }

    @Test
    public void test()  {
        System.out.println("test");
    }
}

