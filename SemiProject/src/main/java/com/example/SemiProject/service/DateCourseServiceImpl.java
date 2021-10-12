package com.example.SemiProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.SemiProject.dao.DateCourseDAO;
import com.example.SemiProject.domain.Date_course;
@Service
@Primary
public class DateCourseServiceImpl implements DateCourseService{
	
	@Autowired
	private DateCourseDAO dateCourseDAO;
	
	@Override
	public void insertDateCourse(String user_place_id, String place_name, String place_address, int sequence)throws Exception{
		dateCourseDAO.insertDateCourse(user_place_id,place_name,place_address,sequence);
	}
	
	@Override
	public List<Date_course> getDateCourse(String id)throws Exception{
		return dateCourseDAO.getDateCourse(id);
	}

}
