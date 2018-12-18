package com.example.demo.dao;

import com.example.demo.entity.TopicReply;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * TopicReplyMapper
 *
 * @author zjl
 * @date 2018/8/30
 */
public interface TopicReplyMapper {

    /**
     * insertSelective
     * 添加
     * @param topics
     * @return
     */
    int insertSelective(TopicReply topics);

    /**
     * selectByPrimaryKey
     * 根据id查询实体
     * @param id
     * @return
     */
    TopicReply selectByPrimaryKey(Long id);

    /**
     * updateById
     * 根据id逻辑删除
     * @param topicsReplyId
     * @return
     */
    int updateById(@Param("topicsReplyId") Long topicsReplyId);

    /**
     * selectByParam
     * 根据参数查询
     * @param topicReply
     * @return
     */
    public List<HashMap> selectByParam(@Param("tp") TopicReply topicReply);
}
