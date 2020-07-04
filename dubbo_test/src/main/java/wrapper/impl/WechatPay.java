package wrapper.impl;


import com.alibaba.dubbo.common.URL;
import wrapper.Pay;

public class WechatPay implements Pay {
    @Override
    public void pay(URL url) {
        System.out.println("使用微信支付");
    }
}
