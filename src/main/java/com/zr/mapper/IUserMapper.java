package com.zr.mapper;

import com.zr.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//防止mapper报错
public interface IUserMapper {
    public User findUserByUserNameAndPass(@Param("userName") String userName,
                                          @Param("password") String password);

    public int insertUser(User user);

    public List<User>  findAllUsers();
}
