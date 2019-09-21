package spi.adaptive.impl;

import com.alibaba.dubbo.common.extension.Activate;
import spi.adaptive.ActivateExt1;

@Activate(order = 2, group = {"order"})
public class OrderActivateExtImpl1 implements ActivateExt1 {
    public String echo(String msg) {
        return msg;
    }
}