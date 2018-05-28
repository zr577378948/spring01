package com.zr.service;

import com.zr.entity.User;

import java.util.List;

public interface IUserService {
    public boolean loginCheck(String userName,String password);
    public boolean regist(User user);
    public List<User> findAllUsers();
}
