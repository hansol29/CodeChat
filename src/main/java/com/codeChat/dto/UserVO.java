package com.codeChat.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {
	
	private String id;
	private String password;
	private String name;
	private String email;
	private String role;
	private int videoCode;

}
