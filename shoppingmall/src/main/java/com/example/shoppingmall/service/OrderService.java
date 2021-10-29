package com.example.shoppingmall.service;

public interface OrderService {

	public void make_order(String id)throws Exception;
	public int get_oseq(String id)throws Exception;
}
