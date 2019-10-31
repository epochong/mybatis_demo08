package com.ming;


import com.ming.mapper.OrdersMapper;
import com.ming.mapper.UserMapper;
import com.ming.po.OrderCustom;
import com.ming.po.Orders;
import com.ming.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;

import java.util.List;

public class MyBatisTest
{

    private SqlSessionFactory  sqlSessionFactory ;

    @BeforeEach
    public void InitFunction(){
        try
        {
            String file = "SqlMapConfig.xml";
            InputStream is = null;
            is = Resources.getResourceAsStream(file);
            //创建会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //1:1
    @Test
    public void testFindOrderUser() throws Exception
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<OrderCustom> orderCustomList =  ordersMapper.findOrderUser();
        System.out.println(orderCustomList);
        sqlSession.close();
    }
    //1:1
    @Test
    public void testFindOrderUser2() throws Exception
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper =  sqlSession.getMapper(OrdersMapper.class);
        List<Orders> ordersList =  ordersMapper.findOrderUser2();
        System.out.println(ordersList);
    }

    //1:m
    @Test
    public void testFindOrderAndOrderDetail()throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<Orders> ordersList = ordersMapper.findOrderAndOrderDetail();
        System.out.println(ordersList);
    }

    //m:n
    @Test
    public void testFindUserItems()throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        List<User> userList = ordersMapper.findUserItems();
        System.out.println(userList);
    }

    //测试延迟加载
    @Test
    public void testFindOrderUserLazyLoad()throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);
        //仅仅查询orders一张表
        List<Orders> ordersList =  ordersMapper.findorderuserlazyload();

        for(Orders orders : ordersList){
            User user = orders.getUser(); //延迟加载
            System.out.println(user);
        }
        sqlSession.close();
    }

    //测试一级缓存
    @Test
    public void testCache()throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //第一次请求
        User user1 = userMapper.findUserById(1);
        System.out.println(user1);
        //第二次请求
        User user2 = userMapper.findUserById(1);
        System.out.println(user2);
        sqlSession.close();
    }

    //测试二级缓存(跨sqlSession)
    @Test
    public void testCacheII()throws Exception{
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();


        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        //第一次请求
        User user1 = userMapper1.findUserById(1);
        System.out.println(user1);
        sqlSession1.close();//只有关闭，才能写入二级缓存区域中去


        //测试清空
        UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
        User user = userMapper3.findUserById(1);
        user.setUsername("YYYYY");
        userMapper3.updateUser(user);
        sqlSession3.commit();//执行提交操作,清空UserMapper中的二级缓存
        sqlSession3.close();//执行关闭操作，写入二级缓存中去


        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        //第二次请求
        User user2 = userMapper2.findUserById(1);
        System.out.println(user2);
        sqlSession2.close();

    }

}
