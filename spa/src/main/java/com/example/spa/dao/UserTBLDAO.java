//package com.example.spa.dao;
//
//import java.util.Map;
//
//import org.apache.ibatis.annotations.Select;
//
//import com.example.spa.domain.UserTBL;
//
//public interface UserTBLDAO {
//	@Select("select * from semi.user where id=#{id} and pwd =#{pwd}")
//	public UserTBL getLoginInfo(Map<String, String> map)throws Exception;
//}
