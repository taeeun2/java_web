package com.example.spa.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.example.spa.domain.UserTBL;



public interface UserTBLMapper {

	@Select("select * from usertbl where id=#{id} and password =#{pw}")
	public UserTBL getLoginInfo(Map<String, String> map)throws Exception;
}
