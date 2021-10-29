package com.example.shoppingmall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.shoppingmall.domain.AddressVO;

public interface AddressDAO {

	@Select("select * from semi.address where dong like concat('%',#{dong},'%')")
	public List<AddressVO> getAddress(String dong) throws Exception;
}
