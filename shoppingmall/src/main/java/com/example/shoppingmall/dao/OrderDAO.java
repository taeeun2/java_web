package com.example.shoppingmall.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface OrderDAO {
	
	@Insert("insert into shopingmall.orders(id) values(id=#{id})")
	public void make_order(String id)throws Exception;
	
	@Select("select oseq from shopingmall.orders where id = #{id}")
	public int get_oseq(String id)throws Exception;
}
