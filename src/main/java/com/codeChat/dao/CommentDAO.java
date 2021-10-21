package com.codeChat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.codeChat.dto.CommentVO;

import util.DBManager;

public class CommentDAO {
	private CommentDAO() {
		
	}
	private static CommentDAO instance = new CommentDAO();
	
	public static CommentDAO getInstance() {
		return instance;
	}
	
}
