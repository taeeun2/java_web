package com.example.shoppingmall.domain;

import java.sql.Timestamp;

public class QNA {
	private int qseq;//글번호
	private String subject;//제목
	private String content;//문의 내용
	private String reply;//답변 내용
	private String id;//작성자 아이디
	private char rep;//답변 유무
	private Timestamp indate;//작성일
}
