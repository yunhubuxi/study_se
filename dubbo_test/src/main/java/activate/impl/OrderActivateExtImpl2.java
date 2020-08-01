package activate.impl;

import activate.ActivateExt1;
import com.alibaba.dubbo.common.extension.Activate;

@Activate(order = 1, group = {"order"})
public class OrderActivateExtImpl2 implements ActivateExt1 {
    @Override
    public String echo(String msg) {
        return msg;
    }
}
