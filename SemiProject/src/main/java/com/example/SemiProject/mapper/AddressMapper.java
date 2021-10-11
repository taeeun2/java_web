package com.example.SemiProject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.SemiProject.domain.AddressVO;

public interface AddressMapper {

	@Select("select * from semi.address where dong like concat('%',#{dong},'%')")
	public List<AddressVO> getAddress(String dong) throws Exception;
}
