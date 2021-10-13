package com.example.SemiProject.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.SemiProject.domain.Date_course;
import com.example.SemiProject.domain.FileVO;
import com.example.SemiProject.domain.User;
import com.example.SemiProject.domain.User_place;
import com.example.SemiProject.service.DateCourseService;
import com.example.SemiProject.service.FileService;
import com.example.SemiProject.service.UserService;


@MapperScan(basePackages = "com.example.SemiProject")
@Controller
public class FileUploadController {
	
//	private static final String CURR_IMAGE_REPO_PATH = "C:\\Users\\김태은\\Desktop\\spring_image";
//	private static final String CURR_IMAGE_REPO_PATH = "C:\\Users\\김태은\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\SemiProject\\WEB-INF\\classes\\static\\images";
	private static final String CURR_IMAGE_REPO_PATH = "C:\\Users\\김태은\\eclipse-workspace\\SemiProject\\src\\main\\resources\\static\\images";

	
	@Autowired
	UserService userservice;
	
	@Autowired
	FileService fileService;
	
	@Autowired
	DateCourseService dateCourseService;
	
	@PostMapping("/update_date_course_act")
	public String update_date_course_act(MultipartHttpServletRequest multipartRequest, HttpServletRequest request,
			HttpServletResponse response, Date_course date_course) throws Exception{
		
		
		multipartRequest.setCharacterEncoding("utf-8");
		//Enumeration eun = multipartRequest.getParameterNames();
		int num = date_course.getNum();
		System.out.println(num);
		String comment = date_course.getComment();
		
		
		List<FileVO> fileList = fileProcess(multipartRequest);
		//첨부한 이미지 정보 불러오기
		if(fileList!=null&&fileList.size()!=0) {
			for(FileVO fileVO : fileList) {
				fileVO.setB_no(num);
				fileService.fileInsert(fileVO);
				
			}
		}
		
		String img =  fileList.get(0).getFileOriginName();
		
		dateCourseService.updateDateCourse(comment,img, num);
		
		return "redirect:/";
		
//		ModelAndView mav = new ModelAndView();
//		HttpSession session = request.getSession(false); 
//		User loginMember=(User)session.getAttribute(SessionConstants.LOGIN_MEMBER);
//		List<User_place> user_places = userservice.getPlace(loginMember.getId());
//		mav.addObject(user_places);
//		mav.setViewName("my_place");
//		return mav;
		
		
//		String place_id = multipartRequest.getParameter("place_id");
//		
//		ModelAndView mav = new ModelAndView();
//		List<Date_course> date_course_list = dateCourseService.getDateCourse(place_id);
//		mav.addObject(date_course_list);
//		mav.setViewName("detail_place");
//		return mav;
//		
		
		
	
		
		
		
		
//		
//		map2.put("fileList", fileList);
//		
//		
//		
//		
//		System.out.println(date_course.getImg());
//		System.out.println(date_course.getNum());
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("detail_place");
//		return mav;
		
	}
	
	
	private List<FileVO> fileProcess(MultipartHttpServletRequest multipartRequest)throws Exception{
		
		List<FileVO> fileList = new ArrayList<FileVO>();
		Iterator<String> fileNames = multipartRequest.getFileNames();
		
		
		//파일을 읽고, CURR_IMAGE~ 경로에 이미지 저장, 파일 객체 생성하여 이름 저장 후 리턴
		while(fileNames.hasNext()) {
			FileVO fileVO = new FileVO();
			String fileName = fileNames.next();
			fileVO.setFilename(fileName);
			
			MultipartFile mFile = multipartRequest.getFile(fileName);
			String originalFileName = mFile.getOriginalFilename();
			
			fileVO.setFileOriginName(originalFileName);
			fileList.add(fileVO);
			File file = new File(CURR_IMAGE_REPO_PATH + "\\"+fileName);
			
			if(mFile.getSize()!=0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdir()) {
						file.createNewFile();
					}
				}
				mFile.transferTo(new File(CURR_IMAGE_REPO_PATH+"\\"+originalFileName));
			}
		}
		return fileList;
		
		
	}
	
	
	
	
}
