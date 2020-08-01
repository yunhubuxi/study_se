package activate.impl;

import activate.ActivateExt1;
import com.alibaba.dubbo.common.extension.Activate;

@Activate(value = {"value1"}, group = {"value"})
public class ValueActivateExtImpl implements ActivateExt1 {
    @Override
    public String echo(String msg) {
        return msg;
    }
}
