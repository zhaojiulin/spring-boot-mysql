package com.example.demo.dao;

import com.example.demo.entity.Topics;
import com.example.demo.view.TopicsParam;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * TopicMapper
 *
 * @author zjl
 * @date 2018/8/30
 */
public interface TopicMapper {

    int insertSelective(Topics topics);

    Topics selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Topics topics);

    public List<HashMap> selectByParam(@Param("tParam") TopicsParam topicsParam);
}
