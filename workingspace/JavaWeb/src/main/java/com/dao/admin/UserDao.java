package com.dao.admin;


import com.entity.User;

public interface UserDao {
	public int addUser(User user);
	public int deleteUser(int id);
	public int updateUser(User user);
	public User queryUser(int id);
}
