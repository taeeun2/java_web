package com.example.shoppingmall.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.shoppingmall.domain.Cart;
import com.example.shoppingmall.domain.Product;



public interface CartDAO {

	//장바구니에 동일한 물건이 있는지 확인
	@Select("select * from shopingmall.cart where id = #{id} and pseq = #{pseq}")
	public Product cart_pseq(String id, int pseq)throws Exception;
	
	//동일한 물건이 있을 때, 그 물건의 수량에 quantity값을 더해줌, id 추가!!!
	@Update("update shopingmall.cart set quantity = quantity+#{quantity} where pseq = #{pseq}")
	public void update_cart(int quantity,int pseq)throws Exception;
	
	//장바구니에 물건을 넣음
	@Insert("insert into shopingmall.cart(id,pseq,quantity) values(#{id},#{pseq},#{quantity})")
	public void insert_cart(String id, int pseq, int quantity)throws Exception;
	
	//장바구니에 어떤 물건이 있는지 확인
	@Select("select pseq from shopingmall.cart where id = #{id}")
	public int[] select_cart_pseq(String id)throws Exception;
	
	//물건의 수량은 무엇인지 확인, id 추가!!
	@Select("select quantity from shopingmall.cart where pseq = #{pseq}")
	public int select_cart_quantity(int pseq)throws Exception;
	
}
