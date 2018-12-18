package com.example.demo.service;

import com.example.demo.dao.TopicReplyMapper;
import com.example.demo.entity.TopicReply;
import com.example.demo.entity.User;
import com.example.demo.util.MyException;
import com.example.demo.view.TopicsReplyParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *  主题service
 *  @author zhaojiulin
 *  @date 2018-08-29
 */
public class TopicReplyService {

    @Autowired
    TopicReplyMapper topicReplyMapper;
    @Autowired
    UserService userService;

    public void saveTopicReply(TopicReply topics)throws MyException {
        if(topics == null){
            throw new MyException("参数错误");
        }
        User dbUser=this.userService.getUserById(topics.getUserId());
        if(dbUser==null){
            throw new MyException("用户不存在");
        }
        try {
            topics.setCreateTime(new Date());
            topicReplyMapper.insertSelective(topics);
        }catch (Exception e){
            throw new MyException("执行时出现异常，请重试");
        }
    }

    public void updateTopic(Long topicReplyId)throws MyException {
        if(topicReplyId == null || topicReplyId.intValue()<=0){
            throw new MyException("参数错误");
        }
        TopicReply dbTopics=this.topicReplyMapper.selectByPrimaryKey(topicReplyId);
        if(dbTopics==null){
            throw new MyException("参数编号错误");
        }
        try {
            topicReplyMapper.updateById(topicReplyId);
        }catch (Exception e){
            throw new MyException("执行时出现异常，请重试");
        }
    }

    public PageInfo getListByParam(TopicsReplyParam topicsReplyParam){
        PageHelper.startPage(topicsReplyParam.getPageNo(),topicsReplyParam.getPageSize());
        TopicReply topicReply = topicsReplyParam.prototype();
        List<HashMap> list =this.topicReplyMapper.selectByParam(topicReply);
        PageInfo page =new PageInfo(list);
        return  page;
    }
}
