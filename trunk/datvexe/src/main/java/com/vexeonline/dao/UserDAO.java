package com.vexeonline.dao;

import java.util.List;

import com.vexeonline.domain.User;

public interface UserDAO {
	public User getUserById(Integer id);
    public User getUserByUserName(String userName);
    public int save(User user);
    public void update(User user);
    public List<User> list();
}
