import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;
import spi.adaptive.AdaptiveExt1;
import spi.adaptive.AdaptiveExt1;

/**
 * 从上面的几个测试用例，可以得到下面的结论：
 * 1. 在类上加上@Adaptive注解的类，是最为明确的创建对应类型Adaptive类。所以他优先级最高。
 * 2. @SPI注解中的value是默认值，如果通过URL获取不到关于取哪个类作为Adaptive类的话，就使用这个默认值，当然如果URL中可以获取到，就用URL中的。
 * 3. 可以再方法上增加@Adaptive注解，注解中的value与链接中的参数的key一致，链接中的key对应的value就是spi中的name,获取相应的实现类。
 */
public class DubboAdaptiveTest {
    /**
     * 测试一：SPI注解中有value值
     */
    @Test
    public void test1() {
        ExtensionLoader<AdaptiveExt1> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt1.class);
        AdaptiveExt1 adaptiveExtension = loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test");
        System.out.println(adaptiveExtension.echo("d", url));
    }

    /**
     * 测试二：SPI注解中有value值，URL中也有具体的值
     * adaptive.ext2.test是根据接口名，把首字母大写改成小写
     * 不同单词用“.”隔开
     */
    @Test
    public void test2() {
        ExtensionLoader<AdaptiveExt1> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt1.class);
        AdaptiveExt1 adaptiveExtension = loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test?adaptive.ext2.test=cloud");
        System.out.println(adaptiveExtension.echo("d", url));
    }

    /**
     * 测试三：SPI注解中有value值，URL中也有具体的值,实现类上有@Adaptive注解
     * test3的代码和test2的一样，不同的是在ThriftAdaptiveExt2类上添加了@Adaptive注解
     */
    @Test
    public void test3() {
        ExtensionLoader<AdaptiveExt1> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt1.class);
        AdaptiveExt1 adaptiveExtension = loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test?adaptive.ext2.test=cloud");
        System.out.println(adaptiveExtension.echo("d", url));
    }

    /**
     * 测试四：SPI注解中有value值,实现类上没有@Adaptive注解
     * 在方法上打上@Adaptive注解，注解中的value与链接中的参数的key一致
     * 链接中的key对应的value就是spi中的name,获取相应的实现类。
     * 测试结果就是，如果接口方法的@Adaptive注解没有默认值，那么url中取接口名小写，并用点号隔开
     * 如果@Adaptive中有默认值，那么URL中就要去默认值
     * 实现类上的@Adaptive优先级最高
     */
    @Test
    public void test4() {
        ExtensionLoader<AdaptiveExt1> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt1.class);
        AdaptiveExt1 adaptiveExtension = loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test?t=cloud");
        System.out.println(adaptiveExtension.echo("d", url));
    }

    /**
     * 多个实现类上有@Adaptive注解，@SPI注解中的默认值和URL中都无效
     * META-INF下的txt文件中类的定义顺序起作用，谁在前面谁优先
     */
    @Test
    public void test5() {
        ExtensionLoader<AdaptiveExt1> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt1.class);
        AdaptiveExt1 adaptiveExtension = loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test?t=abc");
        System.out.println(adaptiveExtension.echo("d", url));
    }

    /**
     * 多个实现类上有@Adaptive注解，@SPI注解中的默认值和URL中都无效
     * META-INF下的services,dubbo,dubbo.internal中都定义实现类
     * dubbo.internal优先级最高，其次是dubbo，优先级最小services
     * 加载指定文件夹下的配置文件，下面是源码，在 ExtensionLoader类中的loadExtensionClasses方法里
     * loadDirectory(extensionClasses, DUBBO_INTERNAL_DIRECTORY);
     * loadDirectory(extensionClasses, DUBBO_DIRECTORY);
     * loadDirectory(extensionClasses, SERVICES_DIRECTORY);
     */
    @Test
    public void test6() {
        ExtensionLoader<AdaptiveExt1> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt1.class);
        AdaptiveExt1 adaptiveExtension = loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test?t=abc");
        System.out.println(adaptiveExtension.echo("d", url));
    }
}
