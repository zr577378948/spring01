package com.zr.service.impl;

import com.zr.entity.User;
import com.zr.mapper.IUserMapper;
import com.zr.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("iUserService")
@Transactional(propagation = Propagation.REQUIRED)//propagation：事务传播机制
// REQUIRES_NEW代表原来有个事务，当新的事务来的时候，原来的事务挂起，当新的事务执行完毕后，再执行原来的事务
//REQUIRED代表不管原来的事务，当有新事务出现时，原事务被替换
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserMapper iUserMapper;

    @Transactional(propagation = Propagation.NEVER)//查询的时候不需要事务
    public boolean loginCheck(String userName, String password) {
        User finduser = iUserMapper.findUserByUserNameAndPass(userName, password);
       /* if (finduser == null) {
            return false;
        } else {
            return true;
        }*/
        return (finduser==null)?false:true;
    }

    public boolean regist(User user) {
        //先判断用户是否存在
        User finduser = iUserMapper.findUserByUserNameAndPass(user.getUserName(), user.getPassword());
        //不存在时插入
        if (finduser== null) {
            int usernum = iUserMapper.insertUser(user);
            if (usernum != 0) {
                return true;
            } else {

                return false;
            }
        } else {
            System.out.println("数据存在");
            return false;
        }

    }

    public List<User> findAllUsers() {
        List<User> list = iUserMapper.findAllUsers();
        for (User User:
             list) {
            System.out.println(User.toString() + "============");
        }
        return list;
    }


}
