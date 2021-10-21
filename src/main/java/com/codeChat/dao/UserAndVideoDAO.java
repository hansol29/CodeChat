package com.codeChat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.codeChat.dto.UserAndVideoVO;
import com.codeChat.dto.VideoVO;

import util.DBManager;

public class UserAndVideoDAO {

	private UserAndVideoDAO() {
		
	}
	
	private static UserAndVideoDAO instance = new UserAndVideoDAO();
	
	public static UserAndVideoDAO getInstance() {
		return instance;
	}
	
	public ArrayList<UserAndVideoVO> getCodeList(String id) {
		  
		  String sql = "select * from userandvideo where id=? order by code desc";
		  
		  ArrayList<UserAndVideoVO> list = new ArrayList<UserAndVideoVO>();
		  Connection conn = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  UserAndVideoVO userAndVideoVO = null;
		  
		  try {
			  conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1, id);
		      rs = pstmt.executeQuery(); 
		      
		      while(rs.next()) {
		    	  userAndVideoVO = new UserAndVideoVO();
		    	  userAndVideoVO.setId(rs.getString("id"));
		    	  userAndVideoVO.setDescription(rs.getString("description"));
		    	  userAndVideoVO.setName(rs.getString("name"));
		    	  userAndVideoVO.setPrice(rs.getInt("price"));
		    	  userAndVideoVO.setCode(rs.getInt("code"));
		    	  userAndVideoVO.setVideoUrl(rs.getString("videoUrl"));
		    	  userAndVideoVO.setVideoCode(rs.getInt("videoCode"));
		    	  
		    	  list.add(userAndVideoVO);
		      }
		  } catch (Exception e) {
		    e.printStackTrace();
		  }
		  
		  return list;
	   }
	
	public void insertUserAndVideo(int videoCode, String id, VideoVO videoVO) {
		String sql = "insert into userandvideo values(userandvideo_seq.NEXTVAL,?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt= null;
		try {
			conn = DBManager.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,videoVO.getName());
			pstmt.setInt(3,videoVO.getCode());
			pstmt.setInt(4,videoVO.getPrice());
			pstmt.setString(5,videoVO.getVideoUrl());
			pstmt.setString(6,videoVO.getDescription());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}

	
	
	
}
