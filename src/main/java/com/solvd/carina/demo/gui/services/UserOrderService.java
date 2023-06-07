package com.solvd.carina.demo.gui.services;

import com.solvd.carina.demo.gui.interfaces.UserMapper;
import com.solvd.carina.demo.gui.interfaces.UserOrdersMapper;
import com.solvd.carina.demo.gui.models.User;
import com.solvd.carina.demo.gui.models.UserOrder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.SessionFactory;

import java.util.List;

public class UserOrderService {
    private static final SqlSessionFactory s = SessionFactory.getSqlSessionFactory();

    public List<UserOrder> getById(int id){
        List<UserOrder> userOrders;
        try(SqlSession sqlSession = s.openSession()) {
            UserOrdersMapper userOrdersMapper = sqlSession.getMapper(UserOrdersMapper.class);
            userOrders = userOrdersMapper.getUserOrdersByUserId(id);
        }
        return userOrders;
    }
}
