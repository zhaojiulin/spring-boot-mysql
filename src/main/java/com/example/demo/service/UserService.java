package com.example.demo.service;

import com.example.demo.constant.Constant;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.util.*;
import com.example.demo.view.UserParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 *  用户service
 *  @author zhaojiulin
 *  @date 2018-08-29
 */
@Service
public class UserService  {
    @Autowired
    UserMapper userMapper;


    public void add(User user) throws MyException {
        if(user == null){
            throw new MyException("参数错误");
        }
        if (user.getMobile() == null) {
            throw new MyException("手机号码不能为空");
        }
        if (user.getName() == null) {
            throw new MyException("用户名不能为空");
        }
        if (user.getMobile() != null && !StringUtil.isPhone(user.getMobile())) {
            throw new MyException("手机号码格式不对，请修改");
        }
        if (user.getName() != null && !StringUtil.isChinese(user.getName())) {
            throw new MyException("昵称格式不对，请修改");
        }
        User userByMobile = this.userMapper.selectByMobile(user.getMobile());
        User userByName= this.userMapper.selectByName(user.getName());
        if (userByMobile != null) {
            throw new MyException("系统已有该注册手机号，无法再注册");
        }
        if (userByName != null) {
            throw new MyException("该用户名已被使用");
        }
        if (user.getPassword().length() < 6) {
            throw new MyException("密码长度不够，至少需要6位");
        }
        user.setPassword(CommonUtil.createPwd(user.getPassword(), Constant.EXAMPLE_ENCRYPT_KEY));
        user.setCreateTime(new Date());
        user.setUniqueCode(createUniqueCode(user.getMobile()));
        try {
            userMapper.insertByEntity(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException("注册时发现异常情况，请稍后尝试");
        }
    }

    public void updateUser(User userParam) throws MyException {
        User user =this.userMapper.selectByPrimaryKey(userParam.getId());
        if(user == null){
            throw new MyException("不存在该用户");
        }
        if (userParam.getPassword() != null) {
            userParam.setPassword(CommonUtil.createPwd(userParam.getPassword(), Constant.EXAMPLE_ENCRYPT_KEY));
        }
        try {
            this.userMapper.updateByPrimaryKeySelective(userParam);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException("修改时发现异常情况，请稍后尝试");
        }
    }


    public User login(User user) throws MyException {
        if (user.getMobile() == null || user.getMobile().isEmpty()) {
            throw new MyException("请输入账户名");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new MyException("请输入密码");
        }
        User dbUser = userMapper.login(user.getMobile(), CommonUtil.createPwd(user.getPassword(), Constant.EXAMPLE_ENCRYPT_KEY));
        if (dbUser == null) {
            throw new MyException("帐号或者密码错误.");
        }
        if (dbUser.getType() != (byte) Enums.AccountType.Normal.getIndex()) {
            throw new MyException("此账户不允许登录");
        }
        if (dbUser.getIsTerminate() == Enums.UserStatus.Terminate.getIndex()) {
            throw new MyException("此账户不存在");
        }
        if (dbUser.getIsTerminate() == Enums.UserStatus.Locked.getIndex()) {
            throw new MyException("此账户已被锁定，请联系管理员");
        }
        User dbU = new User();
        dbU.setLastLoginTime(new Date());
        dbU.setId(dbUser.getId());
        this.userMapper.updateByPrimaryKeySelective(dbU);
        dbUser.setLastLoginTime(new Date());
        return dbUser;
    }


    public User getUserById(Long id){
        return this.userMapper.selectByPrimaryKey(id);

    }

    public User getUserByMobile(String mobile){
        return this.userMapper.selectByMobile(mobile);

    }


    public PageInfo getUserList(UserParam param){
        PageHelper.startPage(param.getPageNo(),param.getPageSize());
        List<User> list =this.userMapper.selectUsers(param);
        PageInfo page =new PageInfo(list);
        return  page;
    }

    public void saveLoginPassword(Long userId, String password) throws MyException {
        User cacheUser = this.userMapper.selectByPrimaryKey(userId);
        if (cacheUser.getPassword().equals(CommonUtil.createPwd(password, Constant.EXAMPLE_ENCRYPT_KEY))) {
            throw new MyException("登录密码和交易密码不能相同");
        }
        User user = new User();
        user.setId(userId);
        user.setPassword(CommonUtil.createPwd(password, Constant.EXAMPLE_ENCRYPT_KEY));
        this.userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 生成专属码
     * @throws MyException
     */
    private String createUniqueCode(String mobile) throws MyException {
        String a = Constant.EXAMPLE_CHARACTER;
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            int rand = (int) (Math.random() * a.length());
            result = result.append(a.charAt(rand));
        }
        if (this.userMapper.selectUserByUniqueCode(result.toString()) == null) {
            return result.toString();
        }
        return createUniqueCode(null);
    }

}