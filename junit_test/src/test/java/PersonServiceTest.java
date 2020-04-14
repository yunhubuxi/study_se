import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.when;

public class PersonServiceTest {
    private PersonDao     mockDao;
    private PersonService personService;

    @Before
    public void setUp() throws Exception {
        //模拟PersonDao对象
        mockDao = mock(PersonDao.class);
        when(mockDao.getPerson(1)).thenReturn(new Person(1, "Person1"));
        when(mockDao.update(isA(Person.class))).thenReturn(true);

        personService = new PersonService(mockDao);
    }

    @Test
    public void testUpdate() throws Exception {
        boolean result = personService.update(1, "new name");
        assertTrue("must true", result);
        //验证是否执行过一次getPerson(1)
        verify(mockDao, times(1)).getPerson(eq(1));
        //验证是否执行过一次update
        verify(mockDao, times(1)).update(isA(Person.class));
    }

    @Test
    public void testUpdateNotFind() throws Exception {
        boolean result = personService.update(2, "new name");
        assertFalse("must true", result);
        //验证是否执行过一次getPerson(1)
        verify(mockDao, times(1)).getPerson(eq(1));
        //验证是否执行过一次update
        verify(mockDao, never()).update(isA(Person.class));
    }

    @Test
    public void testVerify() throws Exception {
        //mock creation
        List mockedList = mock(List.class);
        //using mock object
        mockedList.add("one");
        mockedList.add("two");
        mockedList.add("two");
        mockedList.clear();

        //verification
        verify(mockedList).add("one");//验证是否调用过一次 mockedList.add("one")方法，若不是（0次或者大于一次），测试将不通过
        verify(mockedList, times(2)).add("two");
        //验证调用过2次 mockedList.add("two")方法，若不是，测试将不通过
        verify(mockedList).clear();//验证是否调用过一次 mockedList.clear()方法，若没有（0次或者大于一次），测试将不通过
    }

    @Test
    public void testStubbing() throws Exception {
        //你可以mock具体的类，而不仅仅是接口
        LinkedList mockedList = mock(LinkedList.class);
        //设置桩
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //打印 "first"
        System.out.println(mockedList.get(0));

        //这里会抛runtime exception
        System.out.println(mockedList.get(1));

        //这里会打印 "null" 因为 get(999) 没有设置
        System.out.println(mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
        verify(mockedList).get(0);
    }

    @Test
    public void testArgumentMatcher() throws Exception {
        LinkedList mockedList = mock(LinkedList.class);
        //用内置的参数匹配器来stub
        when(mockedList.get(anyInt())).thenReturn("element");
        //打印 "element"
        System.out.println(mockedList.get(999));

        //你也可以用参数匹配器来验证，此处测试通过
        verify(mockedList).get(anyInt());
        //此处测试将不通过，因为没调用get(33)
        verify(mockedList).get(eq(33));
    }

    @Test
    public void testInvocationTimes() throws Exception {
        LinkedList mockedList = mock(LinkedList.class);

        //using mock
        mockedList.add("once");
        mockedList.add("twice");
        mockedList.add("twice");
        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        //下面两个是等价的， 默认使用times(1)
        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        //验证准确的调用次数
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        //从未调用过. never()是times(0)的别名
        verify(mockedList, never()).add("never happened");

        //用atLeast()/atMost()验证
        verify(mockedList, atLeastOnce()).add("three times");
        //下面这句将不能通过测试
        verify(mockedList, atLeast(2)).add("five times");
        verify(mockedList, atMost(5)).add("three times");
    }

    @Test
    public void testVoidMethodsWithExceptions() throws Exception {
        LinkedList mockedList = mock(LinkedList.class);
        doThrow(new RuntimeException()).when(mockedList).clear();
        //下面会抛RuntimeException
        mockedList.clear();
    }

    @Test
    public void testVerificationInOrder() throws Exception {
        // A. Single mock whose methods must be invoked in a particular order
        List singleMock = mock(List.class);
        //使用单个mock对象
        singleMock.add("was added first");
        singleMock.add("was added second");

        //创建inOrder
        InOrder inOrder = inOrder(singleMock);

        //验证调用次数，若是调换两句，将会出错，因为singleMock.add("was added first")是先调用的
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        // 多个mock对象
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        //using mocks
        firstMock.add("was called first");
        secondMock.add("was called second");

        //创建多个mock对象的inOrder
        inOrder = inOrder(firstMock, secondMock);

        //验证firstMock先于secondMock调用
        inOrder.verify(firstMock).add("was called first");
        inOrder.verify(secondMock).add("was called second");
    }
}
