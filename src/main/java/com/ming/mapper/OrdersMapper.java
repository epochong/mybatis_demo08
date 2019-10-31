package com.ming.mapper;

import com.ming.po.OrderCustom;
import com.ming.po.Orders;
import com.ming.po.User;

import java.util.List;

public interface OrdersMapper
{
    public List<OrderCustom> findOrderUser() throws Exception;

    public List<Orders> findOrderUser2() throws Exception;

    public List<Orders> findOrderAndOrderDetail() throws Exception;

    public List<User> findUserItems()throws Exception;

    //延迟加载
    public List<Orders> findorderuserlazyload() throws Exception;
}
