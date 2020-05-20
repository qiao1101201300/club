package com.demo.club.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//http返回数据
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO {

	//返回码
	private int code;
	//返回信息
	private String message;
	//返回数据
	private Object data;

}
