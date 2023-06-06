package com.solvd.carina.demo.gui.interfaces;

import com.solvd.carina.demo.gui.models.UserOrder;

import java.util.List;

public interface UserOrdersMapper {
    List<UserOrder> getUserOrdersByUserId(int userId);
    void insertUserOrder(UserOrder userOrder);
}