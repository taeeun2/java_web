package com.example.SemiProject.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.SemiProject.dao.DateCourseDAO;
@Service
@Primary
public class DateCourseServiceImpl implements DateCourseService{
	
	@Autowired
	private DateCourseDAO dateCourseDAO;
	
	@Override
	public void insertDateCourse(String user_place_id, String place_name, String place_address, int sequence)throws Exception{
		dateCourseDAO.insertDateCourse(user_place_id,place_name,place_address,sequence);
	}

}
