package com.example.SemiProject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.example.SemiProject.domain.Date_course;

public interface DateCourseDAO {

	@Insert("insert into semi.date_course(user_place_id,place_name,place_address,sequence) values(#{user_place_id},#{place_name},#{place_address},#{sequence})")
	public void insertDateCourse(String user_place_id, String place_name, String place_address, int sequence)throws Exception;

	@Select("select * from semi.date_course where user_place_id = #{place_id}")
	public List<Date_course> getDateCourse(String id);
	

}
