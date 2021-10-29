package com.example.SemiProject.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.SemiProject.domain.Date_course;

public interface DateCourseDAO {

	@Insert("insert into semi.date_course(user_place_id,place_name,place_address,sequence) values(#{user_place_id},#{place_name},#{place_address},#{sequence})")
	public void insertDateCourse(String user_place_id, String place_name, String place_address, int sequence)throws Exception;

	@Select("select * from semi.date_course where user_place_id = #{place_id}")
	public List<Date_course> getDateCourse(String id);
	
	@Select("select * from semi.date_course where num = #{num}")
	public Date_course getOneDateCourse(int num);
	
	@Update("update semi.date_course set comment = #{comment}, img = #{img} where num = #{num}")
	public void updateDateCourse(String comment, String img, int num);

	@Insert("insert into semi.date_course(user_place_id,place_name,place_address,sequence,img,comment) values(#{user_place_id},#{place_name},#{place_address},#{sequence},#{img},#{comment})")
	public void insertMainDateCourse(String user_place_id,String place_name,String place_address,String img,String comment,int sequence);
	
}
