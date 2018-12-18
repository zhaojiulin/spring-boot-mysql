package com.example.demo.dao;

import com.example.demo.entity.User;
import com.example.demo.view.UserParam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    int insertByEntity(User user);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User user);

    @Select({"select * from u_user where mobile = #{mobile,jdbcType=VARCHAR} and is_terminate in(0,2)"})
    User selectByMobile(@Param("mobile") String mobile);

    @Select({"select * from u_user where  binary name = #{name,jdbcType=VARCHAR} and is_terminate in(0,2)"})
    User selectByName(@Param("name") String name);

    @Select({"select * from u_user where  binary unique_code = #{uniqueCode,jdbcType=VARCHAR}"})
    User selectUserByUniqueCode(@Param("uniqueCode") String uniqueCode);

    @Select({"select * from u_user where  password=#{password,jdbcType=VARCHAR} and (mobile=#{mobile,jdbcType=VARCHAR} or name=#{mobile,jdbcType=VARCHAR})"})
    @ResultMap({"BaseResultMap"})
    public User login(@Param("mobile") String mobile, @Param("password") String password);

    public List<User> selectUsers(@Param("param") UserParam param);

}
