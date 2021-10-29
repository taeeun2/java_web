package com.example.shoppingmall.service;

import java.util.List;

import com.example.shoppingmall.domain.AddressVO;

public interface AddressService {
	public List<AddressVO> getAddress(String dong) throws Exception;
}
