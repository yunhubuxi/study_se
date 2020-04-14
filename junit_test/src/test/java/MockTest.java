import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MockTest {
    @Mock
    List<String> mockedList;

    @Before
    public void initMocks() {
        //必须,否则注解无效
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMock() throws Exception {
        mockedList.add("one");
        verify(mockedList).add("one");
    }

    @Test
    public void testDoXXX() throws Exception {
        List mockedList = mock(List.class);
        doThrow(new RuntimeException()).when(mockedList).clear();
        //以下会抛异常
        mockedList.clear();
    }

    @Test
    public void testSpy() throws Exception {
        List list = new LinkedList();
        List spy = spy(list);
        //可选的，你可以stub某些方法
        when(spy.size()).thenReturn(100);

        //调用"真正"的方法
        spy.add("one");
        spy.add("two");

        //打印one
        System.out.println(spy.get(0));

        //size()方法被stub了，打印100
        System.out.println(spy.size());

        //可选，验证spy对象的行为
        verify(spy).add("one");
        verify(spy).add("two");

        //下面写法有问题，spy.get(10)会抛IndexOutOfBoundsException异常
        when(spy.get(10)).thenReturn("foo");
        //可用以下方式
        doReturn("foo").when(spy).get(10);
    }
}
