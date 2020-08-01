import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;
import wrapper.Pay;

public class DubboWrapperTest {
    @Test
    public void pay() {
        ExtensionLoader<Pay> loader = ExtensionLoader.getExtensionLoader(Pay.class);
        Pay pay = loader.getAdaptiveExtension();
        // 使用支付宝支付
        pay.pay(URL.valueOf("http://localhost:9999/xxx"));
        // 使用微信支付
        pay.pay(URL.valueOf("http://localhost:9999/xxx?paytype=wechat"));
    }
}
