package com.example.demo.entity;

/**
 * AddressInfo
 *
 * @author zjl
 * @date 2018/12/21
 */
public class AddressInfo {

    /** 地址的id用来区分地址 */
    private  Long id;

    /** 用户id */
    private  Long userId;

    /** 是否为默认地址,1为默认地址,0为非默认地址 */
    private  Integer status;

    /**接受者姓名 */
    private  String receiverName;

    /** 联系电话 */
    private  String telphone;

    /** 国家 */
    private  String country;

    /** 省份 */
    private  String province;

    /** 城市 */
    private  String city;

    /** 地区 */
    private  String area;

    /** 详细地址 */
    private  String address;


    public  Long  getId() {
        return this.id;
    }
    public  void  setId(Long id){
        this.id=id;
    }

    public  Long  getUserId(){
        return  this.userId;
    }
    public  void  setUserId(Long userId){
        this.userId=userId;
    }

    public  Integer  getStatus(){
        return  this.status;
    }
    public  void  setStatus(Integer status){
        this.status=status;
    }

    public  String  getReceiverName(){
        return  this.receiverName;
    }
    public  void  setReceiverName(String receiverName){
        this.receiverName=receiverName;
    }

    public  String  getTelphone(){
        return  this.telphone;
    }
    public  void  setTelphone(String telphone){
        this.telphone=telphone;
    }

    public  String  getCountry(){
        return  this.country;
    }
    public  void  setCountry(String country){
        this.country=country;
    }

    public  String  getProvince(){
        return  this.province;
    }
    public  void  setProvince(String province){
        this.province=province;
    }

    public  String  getCity(){
        return  this.city;
    }
    public  void  setCity(String city){
        this.city=city;
    }

    public  String  getArea(){
        return  this.area;
    }
    public  void  setArea(String area){
        this.area=area;
    }

    public  String  getAddress(){
        return  this.address;
    }
    public  void  setAddress(String address){
        this.address=address;
    }


}
