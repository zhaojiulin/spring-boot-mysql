package com.example.demo.view;

import com.example.demo.entity.Topics;

/**
 * TopicsParam
 * @author zjl
 * @date 2018/08/30
 */
public class TopicsParam extends Topics {

    private static final long serialVersionUID = 1L;

    /*** 开始时间*/
    private String bTime;
    /*** 结束时间*/
    private String eTime;
    /*** 页码**/
    private Integer pageNo = 1;
    /**每页条数**/
    private Integer pageSize = 20;
    /** 模糊查询字段**/
    private String param;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getbTime() {
        return bTime;
    }

    public void setbTime(String bTime) {
        this.bTime = bTime;
    }

    public String geteTime() {
        return eTime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
