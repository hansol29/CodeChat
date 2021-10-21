package com.codeChat.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserBoardVO {

	private int seq;
	private String title;
	private String id;
	private String content;
	private Timestamp regdate;
	private int cnt;
	private int ref;
	private int restep;
	private int relevel;
	
}
