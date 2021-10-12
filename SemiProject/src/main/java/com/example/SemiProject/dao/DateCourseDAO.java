package com.example.SemiProject.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;

public interface DateCourseDAO {

	@Insert("insert into semi.date_course(user_place_id,place_name,place_address,sequence) values(#{user_place_id},#{place_name},#{place_address},#{sequence})")
	public void insertDateCourse(String user_place_id, String place_name, String place_address, int sequence)throws Exception;
}
