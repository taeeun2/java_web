package com.example.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.shoppingmall.dao.AddressDAO;
import com.example.shoppingmall.domain.AddressVO;

@Primary
@Service
public class AddresssServiceImpl implements AddressService{

	@Autowired
	AddressDAO addressDAO;
	
	@Override
	public List<AddressVO> getAddress(String dong) throws Exception{
		return addressDAO.getAddress(dong);
	}
}
