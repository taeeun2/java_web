package com.example.shoppingmall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.shoppingmall.domain.Product;

public interface ProductDAO {
	
	@Select("select * from shopingmall.best_pro_view")
	public List<Product> best_pro_view()throws Exception;
	
	@Select("select * from shopingmall.new_pro_view")
	public List<Product> new_pro_view()throws Exception;
	
	@Select("select * from shopingmall.product where kind = ${kind}")
	public List<Product> product_view(int kind)throws Exception;
	
	@Select("select * from shopingmall.product where pseq = ${pseq}")
	public Product product_detail_view(int pseq)throws Exception;
}
