package com.vexeonline.dao;

import com.vexeonline.domain.User;

public interface UserDAO {
    public User getUserByUserName(String userName);
}
