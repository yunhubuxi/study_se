package spi.adaptive.impl;

import com.alibaba.dubbo.common.extension.Activate;
import spi.adaptive.ActivateExt1;

@Activate(value = {"value1"}, group = {"value"})
public class ValueActivateExtImpl implements ActivateExt1 {
    public String echo(String msg) {
        return msg;
    }
}