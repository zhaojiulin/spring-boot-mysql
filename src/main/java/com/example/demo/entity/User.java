package com.example.demo.entity;


import java.util.Date;

public class User {

  private long id;
  private String name;
  private String mobile;
  private String password;
  private Integer score;
  private Integer type;
  private Date createTime;
  private Date lastLoginTime;
  private Integer isTerminate;
  private String uniqueCode;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }

  public java.util.Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.util.Date createTime) {
    this.createTime = createTime;
  }


  public java.util.Date getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(java.util.Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }


  public Integer getIsTerminate() {
    return isTerminate;
  }

  public void setIsTerminate(Integer isTerminate) {
    this.isTerminate = isTerminate;
  }


  public String getUniqueCode() {
    return uniqueCode;
  }

  public void setUniqueCode(String uniqueCode) {
    this.uniqueCode = uniqueCode;
  }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
