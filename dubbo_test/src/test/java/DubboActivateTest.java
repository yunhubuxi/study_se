import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;
import activate.ActivateExt1;

import java.util.List;

/**
 * 从上面的几个测试用例，可以得到下面的结论：
 * 1. 根据loader.getActivateExtension中的group和搜索到此类型的实例进行比较，
 * 如果group能匹配到，就是我们选择的，也就是在此条件下需要激活的。
 * 2. @Activate中的value是参数是第二层过滤参数（第一层是通过group），
 * 在group校验通过的前提下，如果URL中的参数（k）与值（v）中的参数名同@Activate中的value值一致或者包含，
 * 那么才会被选中。相当于加入了value后，条件更为苛刻点，需要URL中有此参数并且，
 * 参数必须有值。
 * 3.@Activate的order参数对于同一个类型的多个扩展来说，order值越小，优先级越高。
 */
public class DubboActivateTest {
    /**
     * 测试一：@Activate注解中声明group
     */
    @Test
    public void testDefault() {
        ExtensionLoader<ActivateExt1> loader = ExtensionLoader.getExtensionLoader(ActivateExt1.class);
        URL url = URL.valueOf("test://localhost/test");
        //查询组为default_group的ActivateExt1的实现
        List<ActivateExt1> list = loader.getActivateExtension(url, new String[]{}, "default_group");
        System.out.println(list.size());
        System.out.println(list.get(0).getClass());
    }

    /**
     * 测试二：@Activate注解中声明多个group
     */
    @Test
    public void test2() {
        URL url = URL.valueOf("test://localhost/test");
        //查询组为group2的ActivateExt1的实现
        List<ActivateExt1> list = ExtensionLoader.getExtensionLoader(ActivateExt1.class).getActivateExtension(url, new String[]{}, "group2");
        System.out.println(list.size());
        System.out.println(list.get(0).getClass());
    }

    @Test
    public void testValue() {
        URL url = URL.valueOf("test://localhost/test");
        //根据   key = value1,group =  value
        //@Activate(value = {"value1"}, group = {"value"})来激活扩展
        url = url.addParameter("value1", "value");
        List<ActivateExt1> list = ExtensionLoader.getExtensionLoader(ActivateExt1.class).getActivateExtension(url, new String[]{}, "value");
        System.out.println(list.size());
        System.out.println(list.get(0).getClass());
    }

    @Test
    public void testOrder() {
        URL url = URL.valueOf("test://localhost/test");
        List<ActivateExt1> list = ExtensionLoader.getExtensionLoader(ActivateExt1.class).getActivateExtension(url, new String[]{}, "order");
        System.out.println(list.size());
        System.out.println(list.get(0).getClass());
        System.out.println(list.get(1).getClass());
    }
}
