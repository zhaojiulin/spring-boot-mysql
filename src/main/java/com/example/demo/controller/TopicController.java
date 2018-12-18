package com.example.demo.controller;

import com.example.demo.entity.Topics;
import com.example.demo.service.TopicService;
import com.example.demo.service.UserService;
import com.example.demo.util.Result;
import com.example.demo.view.TopicsParam;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * TopicController
 *
 * @author zjl
 * @date 2018/8/30
 */
@Controller
@RequestMapping({"/topic"})
public class TopicController {
    Result result = new Result();
    @Autowired
    TopicService topicService;
    @Autowired
    UserService userService;
    @RequestMapping(value = "/save")
    public Object save(@RequestBody Topics topics) throws Exception{
        this.topicService.saveTopic(topics);
        return result.Success();
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(@RequestBody Topics topics) throws Exception{
        this.topicService.updateTopic(topics);
        return new Result().Success();
    }

    @RequestMapping(value = "/getTopicById/{id}")
    @ResponseBody
    public Object getTopicById(@PathVariable Long Id){
         Map map =new HashMap<>(16);
         Topics topics = this.topicService.getById(Id);
         map.put("topics",topics);
         if(topics.getUserId()!=null && topics.getUserId().intValue()>0) {
             map.put("author", this.userService.getUserById(topics.getUserId()));
         }
         return map;
    }

    @RequestMapping(value = "/getList")
    @ResponseBody
    public Object getList(@RequestBody TopicsParam topicsParam){
        PageInfo page =this.topicService.getListByParam(topicsParam);
        return result.Page(page).Success();
    }

}
