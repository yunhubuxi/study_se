package wrapper.wrapper;

import com.alibaba.dubbo.common.URL;
import wrapper.Pay;

public class PayWrapper2 implements Pay {
    Pay pay;

    public PayWrapper2(Pay pay) {
        this.pay = pay;
    }
    @Override
    public void pay(URL url) {
        System.out.println("-----pay before...");
        pay.pay(url);
        System.out.println("-----pay after...");
    }
}
