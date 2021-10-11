package com.example.assignment.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import com.example.assignment.domain.UserTBL;


public interface UserTBLDAO {
	@Select("select * from usertbl where id=#{id} and password =#{pw}")
	public UserTBL getLoginInfo(Map<String, String> map)throws Exception;
}
