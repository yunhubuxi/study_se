package spi.adaptive.impl;

import com.alibaba.dubbo.common.extension.Activate;
import spi.adaptive.ActivateExt1;

@Activate(group = {"group1", "group2"})
public class GroupActivateExtImpl implements ActivateExt1 {
    public String echo(String msg) {
        return msg;
    }
}
