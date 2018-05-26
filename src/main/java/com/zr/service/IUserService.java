package com.zr.service;

import com.zr.entity.User;

public interface IUserService {
    public boolean loginCheck(String userName,String password);
    public boolean regist(User user);
}
