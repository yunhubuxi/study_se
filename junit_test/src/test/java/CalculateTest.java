import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculateTest {
    @Test
    public void testAdd(){
        assertEquals(6,new Calculate().add(3, 3));
    }
}
class Calculate {
    public int add(int a,int b){
        return a+b;
    }
}
