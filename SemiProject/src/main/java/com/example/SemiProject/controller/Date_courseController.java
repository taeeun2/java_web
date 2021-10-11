package com.example.SemiProject.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@MapperScan(basePackages = "com.example.SemiProject")
@Controller
public class Date_courseController {

	@GetMapping("/map")
	public String map() {
		return "map";
	}
	
	
}
