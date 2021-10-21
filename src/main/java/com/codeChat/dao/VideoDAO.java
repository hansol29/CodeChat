package com.codeChat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.codeChat.dto.VideoVO;

import util.DBManager;

public class VideoDAO {

	private VideoDAO() {
		
	}
	
	private static VideoDAO instance = new VideoDAO();
	
	public static VideoDAO getInstance() {
		return instance;
	}
	
	public List<VideoVO> selectAllVideos(){
		
		String sql = "select * from video order by code desc";
		List<VideoVO> list = new ArrayList<VideoVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				VideoVO vVo = new VideoVO();
				vVo.setCode(rs.getInt("code"));
				vVo.setName(rs.getString("name"));
				vVo.setPrice(rs.getInt("price"));
				vVo.setVideoUrl(rs.getString("videoUrl"));
				vVo.setDescription(rs.getString("description"));
				list.add(vVo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.close(conn,pstmt,rs);
		}
		
		return list;
	}
	
	public void insertVideo(VideoVO vVo) {
		String sql = "insert into video values (video_seq.nextval, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt= null;
		try {
			conn = DBManager.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, vVo.getName());
			pstmt.setInt(2, vVo.getPrice());
			pstmt.setString(3, vVo.getVideoUrl());
			pstmt.setString(4, vVo.getDescription());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public VideoVO selectVideoByCode(String code) {
		String sql = "select * from video where code=?";
		VideoVO vVo = null;
		
		try{
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, code);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					vVo = new VideoVO();
					vVo.setCode(rs.getInt("code"));
					vVo.setName(rs.getString("name"));
					vVo.setPrice(rs.getInt("price"));
					vVo.setVideoUrl(rs.getString("videoUrl"));
					vVo.setDescription(rs.getString("description"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt, rs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vVo;
	}
	
	public void updateVideo(VideoVO vVo) {
		String sql = "update video set name=?, price=?, videourl=?, description=? where code=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vVo.getName());
			pstmt.setInt(2, vVo.getPrice());
			pstmt.setString(3, vVo.getVideoUrl());
			pstmt.setString(4, vVo.getDescription());
			pstmt.setInt(5, vVo.getCode());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void deleteVideo(String code) {
		String sql = "delete video where code=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		
		
	}
	
	
public VideoVO selectVideoByCode(int code){
		
		String sql = "select * from video where code=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		VideoVO vVo = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vVo = new VideoVO();
				vVo.setCode(rs.getInt("code"));
				vVo.setName(rs.getString("name"));
				vVo.setPrice(rs.getInt("price"));
				vVo.setDescription(rs.getString("description"));
				vVo.setVideoUrl(rs.getString("videoUrl"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.close(conn,pstmt,rs);
		}
		
		return vVo;
	}
}
