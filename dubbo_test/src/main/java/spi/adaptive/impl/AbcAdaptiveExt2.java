package spi.adaptive.impl;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import spi.adaptive.AdaptiveExt1;

@Adaptive
public class AbcAdaptiveExt2 implements AdaptiveExt1 {
    @Override
    public String echo(String msg, URL url) {
        return "abc";
    }
}
