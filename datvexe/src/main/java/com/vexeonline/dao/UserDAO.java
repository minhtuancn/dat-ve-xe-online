package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.User;

public interface UserDAO {
	public User get(Integer userId);
    public User get(String userName);
    public List<User> getUsers(Integer nhaXeId);
    public int insert(User user);
    public void update(User user);
    public List<User> list();
}
