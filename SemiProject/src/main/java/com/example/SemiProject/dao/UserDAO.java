package com.example.SemiProject.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.SemiProject.domain.User;
import com.example.SemiProject.domain.User_place;


public interface UserDAO {
	
	@Select("select * from semi.user where id=#{id} and pwd =#{pwd}")
	public User login(Map<String, String> map) throws Exception;

	@Insert("insert into semi.user(id,email,pwd,zip_num,address,phone,name) values(#{id}, #{email}, #{pwd}, #{zip_num}, #{address}, #{phone}, #{name}) ")
	public void createUser(Map<String, String> map)throws Exception;

	@Update("update semi.user set pwd=#{pwd},name=#{name},zip_num=#{zip_num}, address=#{address}, email=#{email},phone=#{phone} where id=#{id}")
	public void editUser(Map<String, String> map) throws Exception;
	
	@Select("select * from semi.user where id=#{id}")
	public User idCheck(String id)throws Exception;
	
	@Select("select * from semi.user_place where place_id=#{id}")
	public User_place idCheck2(String id)throws Exception;

	@Insert("insert into semi.user_place(place_id,user_id,total_distance) values(#{place_id},#{user_id},#{total_distance})")
	public void insertUserPlace(Map<String, String> map) throws Exception;

	@Select("select * from semi.user_place where user_id=#{id}")
	public List<User_place> getPlace(String id)throws Exception;
	
	@Delete("delete from semi.user_place where place_id=#{id}")
	public void deleteUserPlace(String id)throws Exception;
	
	
	@Update("update semi.user_place set viewYn = 'y' where place_id = #{id}")
	public void viewPlace(String id)throws Exception;
	
	
}