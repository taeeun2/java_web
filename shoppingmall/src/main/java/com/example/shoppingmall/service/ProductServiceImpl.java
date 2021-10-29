package com.example.shoppingmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.shoppingmall.dao.ProductDAO;
import com.example.shoppingmall.domain.Product;

@Service 
@Primary 
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO productDAO;
	
	@Override
	public List<Product> best_pro_view() throws Exception{
		
		return productDAO.best_pro_view();
	}
	@Override
	public List<Product> new_pro_view() throws Exception{
		
		return productDAO.new_pro_view();
	}
	@Override
	public List<Product> product_view(int kind)throws Exception{
		
		return productDAO.product_view(kind);
	}
	@Override
	public Product product_detail_view(int pseq)throws Exception{
		return productDAO.product_detail_view(pseq);
	}
	
}
