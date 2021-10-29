package com.example.shoppingmall.service;

import java.util.List;

import com.example.shoppingmall.domain.Product;

public interface ProductService {

	public List<Product> best_pro_view()throws Exception;
	public List<Product> new_pro_view() throws Exception;
	public List<Product> product_view(int kind)throws Exception;
	public Product product_detail_view(int pseq)throws Exception;
}
