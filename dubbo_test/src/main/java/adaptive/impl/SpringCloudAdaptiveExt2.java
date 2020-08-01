package adaptive.impl;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import adaptive.AdaptiveExt2;

@Adaptive
public class SpringCloudAdaptiveExt2 implements AdaptiveExt2 {
    @Override
    public String echo(String msg, URL url) {
        return "spring cloud";
    }
}
