package wrapper.impl;

import com.alibaba.dubbo.common.URL;
import wrapper.Pay;

public class AliPay implements Pay {
    @Override
    public void pay(URL url) {
        System.out.println("使用支付宝支付");
    }
}
