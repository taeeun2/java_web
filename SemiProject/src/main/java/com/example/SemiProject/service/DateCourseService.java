package com.example.SemiProject.service;

import java.util.List;

import com.example.SemiProject.domain.Date_course;

public interface DateCourseService {
	public void insertDateCourse(String user_place_id, String place_name, String place_address, int sequence)throws Exception;
	public List<Date_course> getDateCourse(String id)throws Exception;
	public Date_course getOneDateCourse(int num) throws Exception;
	public void updateDateCourse(String comment, String img, int num)throws Exception;
}
