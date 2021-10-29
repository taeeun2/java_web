package com.example.shoppingmall.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.shoppingmall.dao.CartDAO;
import com.example.shoppingmall.domain.Cart;
import com.example.shoppingmall.domain.Product;


@Service
@Primary
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartDAO cartDAO;

	@Override
	public Product cart_pseq(String id, int pseq)throws Exception{
		return cartDAO.cart_pseq(id, pseq);
	}
	
	@Override
	public void update_cart(int quantity,int pseq)throws Exception{
		cartDAO.update_cart(quantity, pseq);
	}
	
	
	@Override
	public void insert_cart(String id, int pseq, int quantity)throws Exception{
		cartDAO.insert_cart(id, pseq, quantity);
	}
	
	@Override
	public int[] select_cart_pseq(String id)throws Exception{
		return cartDAO.select_cart_pseq(id);
	}
	
	@Override
	public int select_cart_quantity(int pseq)throws Exception{
		return cartDAO.select_cart_quantity(pseq);
	}
	
}
