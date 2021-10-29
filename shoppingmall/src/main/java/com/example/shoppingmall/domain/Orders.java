package com.example.shoppingmall.domain;

import java.sql.Timestamp;

public class Orders {
	private int oseq; //주문번호
	private String id; //주문자 아이디
	private Timestamp indate;//주문일
	public int getOseq() {
		return oseq;
	}
	public void setOseq(int oseq) {
		this.oseq = oseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	
	
}
