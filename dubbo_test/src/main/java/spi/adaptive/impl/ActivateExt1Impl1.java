package spi.adaptive.impl;

import com.alibaba.dubbo.common.extension.Activate;
import spi.adaptive.ActivateExt1;

@Activate(group = {"default_group"})
public class ActivateExt1Impl1 implements ActivateExt1 {

    public String echo(String msg) {
        return msg;
    }
}