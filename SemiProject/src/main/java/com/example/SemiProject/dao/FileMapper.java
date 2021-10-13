package com.example.SemiProject.dao;

import org.apache.ibatis.annotations.Insert;

import com.example.SemiProject.domain.FileVO;

public interface FileMapper {

	
	@Insert("insert into semi.file(b_no, filename,fileOriginName) values(#{b_no},#{filename},#{fileOriginName})")
	public void fileInsert(FileVO file);
}
