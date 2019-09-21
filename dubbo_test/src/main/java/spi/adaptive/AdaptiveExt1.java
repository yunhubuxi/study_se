package spi.adaptive;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

@SPI("thrift")
public interface AdaptiveExt1 {
    @Adaptive({"t"})
    String echo(String msg, URL url);
}
