package com.dao.admin;

import com.entity.Order;

public interface OrderDao {
	public int addOrder(Order order);
	public int deleteOrder(int id);
	public int updateOrder(Order order);
	public Order queryOrder(int id);
}
