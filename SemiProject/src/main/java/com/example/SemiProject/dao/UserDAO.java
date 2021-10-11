package com.example.SemiProject.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.SemiProject.domain.User;


public interface UserDAO {
	
	@Select("select * from semi.user where id=#{id} and pwd =#{pwd}")
	public User login(Map<String, String> map) throws Exception;

	@Insert("insert into semi.user(id,email,pwd,zip_num,address,phone,name) values(#{id}, #{email}, #{pwd}, #{zip_num}, #{address}, #{phone}, #{name}) ")
	public void createUser(Map<String, String> map)throws Exception;

	@Update("update semi.user set pwd=#{pwd},name=#{name},zip_num=#{zip_num}, address=#{address}, email=#{email},phone=#{phone} where id=#{id}")
	public void editUser(Map<String, String> map) throws Exception;
	
	@Select("select * from semi.user where id=#{id}")
	public User idCheck(String id)throws Exception;

}