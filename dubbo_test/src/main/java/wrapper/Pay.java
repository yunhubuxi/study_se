package wrapper;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

@SPI("ali")
public interface Pay {
    @Adaptive({"paytype"})
    void pay(URL url);
}
