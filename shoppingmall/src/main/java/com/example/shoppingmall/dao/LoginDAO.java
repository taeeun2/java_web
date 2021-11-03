package com.example.shoppingmall.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.shoppingmall.domain.Ai_Test;
import com.example.shoppingmall.domain.Member;

public interface LoginDAO {

	@Select("select * from shopingmall.member where id = #{id} and pwd = #{pwd}")
	public Member login(String id, String pwd)throws Exception;
	
	@Select("select * from ai_test where name = #{mname}")
	public Ai_Test getUserInfoByName(@Param("mname")String mname)throws Exception;
}
