package com.yedam.vo;

import java.util.Date;

import lombok.Data;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Data
public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int readCnt;
}
