package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.Result;
import com.example.demo.view.UserParam;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Object save(@RequestBody  User user) throws Exception{
        Result result = new Result();
        userService.add(user);
        return result.Success();
    }

    @RequestMapping(value = "/updateUser")
    @ResponseBody
    public Object updateUser(@RequestBody User user) throws Exception{
        Result result = new Result();
        userService.updateUser(user);
        return result.Success();
    }

    /**
     * 用户登录
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody User user) throws Exception {
        User u = this.userService.login(user);
        return new Result().Add("user", u).Success();
    }

    /**
     * 获取
     * @param id
     * @return
     * @throws Exception
     */

    @RequestMapping(value = "/get/{id}")
    @ResponseBody
    public Object getUserById(@PathVariable Long id) throws Exception {
        Map map = new HashMap<>();
        User user = this.userService.getUserById(id);
        map.put("user", user);
        return map;
    }

    /**
     * 获取
     * @param mobile
     * @return
     * @throws Exception
     */

    @RequestMapping(value = "/getUserByMobile")
    @ResponseBody
    public Object getUserByMobile(String mobile) throws Exception {
        User user = this.userService.getUserByMobile(mobile);
        return user;
    }

    /**
     * 获取列表
     * @param userParam
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getList")
    @ResponseBody
    public Object getList(UserParam userParam) throws Exception {
        Result result = new Result();
        return result.Page(userService.getUserList(userParam)).Success();
    }
}
