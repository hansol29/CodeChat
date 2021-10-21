package com.codeChat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.codeChat.dto.BoardVO;

import util.DBManager;

public class BoardDAO {

private static BoardDAO instance = new BoardDAO();
	
	private BoardDAO() {
		
	}
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	
	//최신글
	public ArrayList<BoardVO> listNewBoard(){
		
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		String sql = "select * from new_board_view";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				
				board.setTitle(rs.getString("title"));
				board.setId(rs.getString("id"));
				board.setRegdate(rs.getTimestamp("regdate"));
				board.setCnt(rs.getInt("cnt"));
				board.setKind(rs.getInt("kind"));
				board.setSeq(rs.getInt("seq"));
				
				boardList.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return boardList;
	}
		
	//인기글
	public ArrayList<BoardVO> listBestBoard(){
		ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
		String sql = "select * from best_board_view";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				
				board.setId(rs.getString("id"));
				board.setTitle(rs.getString("title"));
				board.setRegdate(rs.getTimestamp("regdate"));
				board.setCnt(rs.getInt("cnt"));
				board.setKind(rs.getInt("kind"));
				board.setSeq(rs.getInt("seq"));
				
				boardList.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return boardList;
	}
	
	//메인페이지 자유게시판
		public ArrayList<BoardVO> listUserBoard(){
			ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
			String sql = "select * from user_board_view";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					BoardVO board = new BoardVO();
					
					board.setId(rs.getString("id"));
					board.setTitle(rs.getString("title"));
					board.setRegdate(rs.getTimestamp("regdate"));
					board.setCnt(rs.getInt("cnt"));
					board.setSeq(rs.getInt("seq"));
					
					boardList.add(board);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt, rs);
			}
			
			return boardList;
		}
		
		//메인페이지 구인/구직 게시판
		public ArrayList<BoardVO> listCompanyBoard(){
			ArrayList<BoardVO> boardList = new ArrayList<BoardVO>();
			String sql = "select * from company_board_view";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					BoardVO board = new BoardVO();
					
					board.setSeq(rs.getInt("seq"));
					board.setId(rs.getString("id"));
					board.setTitle(rs.getString("title"));
					board.setRegdate(rs.getTimestamp("regdate"));
					board.setCnt(rs.getInt("cnt"));
					
					boardList.add(board);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt, rs);
			}
			
			return boardList;
		}
}

