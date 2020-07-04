package activate.impl;

import activate.ActivateExt1;
import com.alibaba.dubbo.common.extension.Activate;

@Activate(group = {"default_group"})
public class ActivateExt1Impl1 implements ActivateExt1 {

    @Override
    public String echo(String msg) {
        return msg;
    }
}
