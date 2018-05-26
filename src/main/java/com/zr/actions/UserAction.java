package com.zr.actions;

import com.zr.entity.User;
import com.zr.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


/**
 * 登录、注册
 */
@Controller
public class UserAction {
    @Resource
    private IUserService iUserService;

    @RequestMapping(value = "/login.action")//获得请求路径
    public String login(String userName, String password, HttpSession session) {
        if (iUserService.loginCheck(userName, password)) {
            session.setAttribute("userName", userName);
            return "index.html";
        } else {
            return "login.html";
        }
    }

    @RequestMapping(value = "/regist.action")//获得请求路径
    public String regist(User user) {
        if (iUserService.regist(user)) {
            return "login.html";
        } else {
            return "error.html";
        }
    }

    @RequestMapping(value = "/ajax.action")
    public @ResponseBody User ajax() {  //@ResponseBody返回ajax对象
        User user = new User();
        user.setUserName("我是ajax");
//        JSONObject JSONObject = new JSONObject();
//        JSONObject.put("user",user);
//JSON.toJSON(user).toString()
        return user;
    }
}
