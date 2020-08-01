package activate;

import com.alibaba.dubbo.common.extension.SPI;

@SPI
public interface ActivateExt1 {
    String echo(String msg);
}
