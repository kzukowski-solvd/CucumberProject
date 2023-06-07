package com.solvd.carina.demo.gui.services;

import com.solvd.carina.demo.gui.interfaces.UserMapper;
import com.solvd.carina.demo.gui.models.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import utils.SessionFactory;

public class UserService {
    private static final SqlSessionFactory s = SessionFactory.getSqlSessionFactory();

    public User getById(int id){
        User user;
        try(SqlSession sqlSession = s.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            user = userMapper.getUserById(id);
        }
        return user;
    }

}
