package com.example.shoppingmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.shoppingmall.dao.OrderDAO;

@Primary
@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderDAO orderDAO;
	
	@Override
	public void make_order(String id) throws Exception {
		orderDAO.make_order(id);
	}
	
	@Override
	public int get_oseq(String id)throws Exception{
		return orderDAO.get_oseq(id);
	}
}
