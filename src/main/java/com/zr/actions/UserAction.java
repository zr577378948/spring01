package com.zr.actions;

import com.zr.entity.User;
import com.zr.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;


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
         /*   session.setAttribute("userName", userName);*/
            return "index.html";
        } else {
            return "login.html";
        }
    }

    @RequestMapping(value = "/regist.action")//获得请求路径
    public @ResponseBody
    String regist(User user) {
        if (iUserService.regist(user)) {
            System.out.println("注册成功");
            return "success";
        } else {
            return "数据存在";
        }
    }

    @RequestMapping(value = "/findAll.action")
    public @ResponseBody List<User> findAllUsers() {
       /* List<User> list = iUserService.findAllUsers();
        Iterator it = list.iterator();//创建迭代器对象
        while(it.hasNext()) {
            System.out.println(it.next());
        }*/
        return iUserService.findAllUsers();
    }

    @RequestMapping(value = "/ajax.action")
    public @ResponseBody
    User ajax() {  //@ResponseBody返回ajax对象，包装成json对象
        User user = new User();
        user.setUserName("我是ajax");
//        JSONObject JSONObject = new JSONObject();
//        JSONObject.put("user",user);
//JSON.toJSON(user).toString()
        return user;
    }

    @RequestMapping(value = "/ajax2.action")
    public @ResponseBody
    List<User> ajax2() {
        List<User> list = new ArrayList<User>(0);
        User user1 = new User();
        user1.setUserName("我是ajax1");

        User user2 = new User();
        user2.setUserName("我是ajax2");

        list.add(user1);
        list.add(user2);

        return list;
    }

    @RequestMapping(value = "/ajax3.action")
    public @ResponseBody
    Map<String, List<User>> ajax3() {
        List<User> list = new ArrayList<User>(0);
        User user1 = new User();
        user1.setUserName("我是ajax1");

        User user2 = new User();
        user2.setUserName("我是ajax2");

        list.add(user1);
        list.add(user2);

        Map<String, List<User>> map = new HashMap<String, List<User>>();
        map.put("abc", list);
        return map;
    }
}
