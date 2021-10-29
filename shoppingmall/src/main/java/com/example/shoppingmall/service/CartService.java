package com.example.shoppingmall.service;


import com.example.shoppingmall.domain.Cart;
import com.example.shoppingmall.domain.Product;

public interface CartService {
	
	public Product cart_pseq(String id, int pseq)throws Exception;
	public void update_cart(int quantity,int pseq)throws Exception;
	public void insert_cart(String id, int pseq, int quantity)throws Exception;
	public int[] select_cart_pseq(String id)throws Exception;
	public int select_cart_quantity(int pseq)throws Exception;

}
