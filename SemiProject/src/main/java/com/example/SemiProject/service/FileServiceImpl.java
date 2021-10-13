package com.example.SemiProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.SemiProject.dao.FileMapper;
import com.example.SemiProject.domain.FileVO;

@Service
@Primary
public class FileServiceImpl implements FileService{

	@Autowired
	FileMapper filemapper;
	
	@Override
	public void fileInsert(FileVO file) {
	  filemapper.fileInsert(file);
	}
}
