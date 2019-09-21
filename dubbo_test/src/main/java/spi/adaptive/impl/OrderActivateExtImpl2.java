package spi.adaptive.impl;

import com.alibaba.dubbo.common.extension.Activate;
import spi.adaptive.ActivateExt1;

@Activate(order = 1, group = {"order"})
public class OrderActivateExtImpl2 implements ActivateExt1 {
    public String echo(String msg) {
        return msg;
    }
}
