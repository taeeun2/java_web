package com.example.shoppingmall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shoppingmall.dao.LoginDAO;
import com.example.shoppingmall.domain.Ai_Test;
import com.example.shoppingmall.domain.CelebrityFace;
import com.example.shoppingmall.domain.CelebrityFace.Info.Faces;
import com.example.shoppingmall.domain.Member;
import com.google.gson.Gson;

import naverAPI.APIExamFace;

@Service
public class AIDataServiceImpl {
	@Autowired
	private LoginDAO mapper;
	public List<Ai_Test> faceData(String filename) throws Exception{
		String jsonData = new APIExamFace().resultJsonData(filename);
		return dataProc(jsonData);
	}
	
	public List<Ai_Test> dataProc(String jsonData) throws Exception{
		Gson gson = new Gson();
		Faces[] faces = gson.fromJson(jsonData.substring(jsonData.indexOf("["),
				jsonData.indexOf("]")+1), Faces[].class);
		CelebrityFace cf = gson.fromJson(jsonData, CelebrityFace.class);
		cf.getInfo().setFaces(faces);
		List<Ai_Test> memberList = new ArrayList<>();
		for(Faces facesObj : cf.getInfo().getFaces()) {
			System.out.println(facesObj.getCelebrity().getValue());
			memberList.add(mapper.getUserInfoByName(facesObj.getCelebrity().getValue()));
		}
		return memberList;
	}
}
