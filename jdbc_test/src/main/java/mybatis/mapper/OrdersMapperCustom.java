package mybatis.mapper;

import mybatis.onttomany.Orders;

import java.util.List;

public interface OrdersMapperCustom {

    //查询订单（关联用户）及订单明细
    List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;
}
