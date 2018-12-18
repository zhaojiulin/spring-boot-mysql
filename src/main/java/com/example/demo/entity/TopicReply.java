package com.example.demo.entity;


import java.util.Date;
public class TopicReply {

  private Long id;
  private Long userId;
  private Long topicId;
  private Long topicReplyId;
  private String content;
  private Integer isDelete;
  private Date createTime;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }


  public Long getTopicId() {
    return topicId;
  }

  public void setTopicId(Long topicId) {
    this.topicId = topicId;
  }


  public Long getTopicReplyId() {
    return topicReplyId;
  }

  public void setTopicReplyId(Long topicReplyId) {
    this.topicReplyId = topicReplyId;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public Integer getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(Integer isDelete) {
    this.isDelete = isDelete;
  }


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

}
