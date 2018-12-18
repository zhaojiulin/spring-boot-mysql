package com.example.demo.service;

import com.example.demo.constant.Constant;
import com.example.demo.dao.TopicMapper;
import com.example.demo.entity.Topics;
import com.example.demo.entity.User;
import com.example.demo.util.Enums;
import com.example.demo.util.MyException;
import com.example.demo.view.TopicsParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *  主题service
 *  @author zhaojiulin
 *  @date 2018-08-29
 */
@Service
public class TopicService {
    @Autowired
    TopicMapper topicMapper;
    @Autowired
    UserService userService;

    public void saveTopic(Topics topics)throws MyException {
        if(topics == null){
            throw new MyException("参数错误");
        }
        User dbUser=this.userService.getUserById(topics.getUserId());
        if(dbUser==null){
            throw new MyException("用户不存在");
        }
        try {
            if(Constant.EXAMPLE_AUDIT_CHECK){
                topics.setStatus(Enums.State.Wait.getIndex());
            }
            topics.setCreateTime(new Date());
            topicMapper.insertSelective(topics);
           if(!Constant.EXAMPLE_AUDIT_CHECK){
               User user =new User();
               user.setScore(1);
               userService.updateUser(user);
           }
        }catch (Exception e){
            throw new MyException("执行时出现异常，请重试");
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    public void updateTopic(Topics topics) throws MyException {

        if(topics == null){
            throw new MyException("参数错误");
        }
        Topics dbTopics=this.topicMapper.selectByPrimaryKey(topics.getId());
        if(dbTopics==null){
            throw new MyException("参数编号错误");
        }
        try {
            topicMapper.updateByPrimaryKeySelective(topics);
            if(dbTopics.getStatus() !=Enums.State.Complete.getIndex() && topics.getStatus() == Enums.State.Complete.getIndex()){
                User user =new User();
                user.setScore(1);
                userService.updateUser(user);
            }
        }catch (MyException e){
            throw e;
        }
    }

    public Topics getById(Long topicId){
        Topics topics= this.topicMapper.selectByPrimaryKey(topicId);
        return topics;

    }

    public PageInfo getListByParam(TopicsParam param){
        PageHelper.startPage(param.getPageNo(),param.getPageSize());
        List<HashMap> list =this.topicMapper.selectByParam(param);
        PageInfo page =new PageInfo(list);
        return  page;
    }


}
