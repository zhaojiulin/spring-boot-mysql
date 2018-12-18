package com.example.demo.util;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;

public class Result {
    private HashMap map;
    private String str;
    public Result(){
        this.map=new HashMap();
    }
    public HashMap Success(){
        this.map.put("code",1);
        this.map.put("message","");
        return this.map;
    }
    public HashMap Error(String err){
        this.map.put("code",-1);
        this.map.put("message",err);
        return this.map;
    }
    public Result Add(String key,String value){
        this.map.put(key,value);
        return this;
    }
    public Result Add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }
    public Result Page(PageInfo page) {
        this.map.put("pageno", Integer.valueOf(page.getPageNum()));
        this.map.put("pagesize", Integer.valueOf(page.getPageSize()));
        this.map.put("total", Long.valueOf(page.getTotal()));
        this.map.put("list", page.getList());
        return this;
    }
}
