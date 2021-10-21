package com.codeChat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.codeChat.dto.QnaVO;
import com.codeChat.dto.UserBoardVO;

import util.DBManager;

public class QnaDAO {
	private QnaDAO() {
	}

	private static QnaDAO instance = new QnaDAO();

	public static QnaDAO getInstance() {
		return instance;
	}
	
	//전체 글 갯수
	public int getListCount(){
	    int count = 0;
	    String QNA_COUNT = "select count(*) from qna";
	    
	    Connection conn = null;
	    PreparedStatement psmt = null;
	    ResultSet rs = null;
	    
	    try{
	        conn = DBManager.getConnection();
	        psmt = conn.prepareStatement(QNA_COUNT);
	        rs = psmt.executeQuery();
	        
	       
	        if(rs.next()){
	            count = rs.getInt(1);
	        }
	    }catch(Exception ex){
	        System.out.println("getListCount 에러 : " + ex);
	    }finally{
	       DBManager.close(conn, psmt, rs);
	    }
	    
	    return count;
	}
	
	//Qna게시판 전체보기
	public List<QnaVO> selectAllBoard(int nowpage, int limit){
			
			String SELECT_ALL_SEQ = "select * from (select rownum rnum, seq, id, title, content, ref, relevel, restep, cnt, regdate, secret from (select * from qna order by ref desc, restep asc)) where rnum>=? and rnum<=?";
			
			List<QnaVO> list = new ArrayList<QnaVO>();
			
			int startrow = (nowpage-1)*10+1;
			int endrow = startrow + limit-1;
			
			Connection conn = null;
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBManager.getConnection();
				
				
				psmt = conn.prepareStatement(SELECT_ALL_SEQ);
				psmt.setInt(1, startrow);
				psmt.setInt(2, endrow);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					QnaVO vo = new QnaVO();
					
					vo.setSeq(rs.getInt("seq"));
					vo.setTitle(rs.getString("title"));
					vo.setId(rs.getString("id"));
					vo.setRegdate(rs.getTimestamp("regdate"));
					vo.setCnt(rs.getInt("cnt"));
					
					vo.setRef(rs.getInt("ref"));
					vo.setRestep(rs.getInt("restep"));
					vo.setRelevel(rs.getInt("relevel"));
					vo.setSecret(rs.getString("secret"));
					
					list.add(vo);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, psmt, rs);
			}
			return list;
		}
	
	//qna 글 작성
	public void insertQNA(QnaVO vo) {
		String QNA_INSERT = "insert into qna(seq, title, id, password, content, secret, ref) values (qna_seq.nextval,?,?,?,?,?,qna_seq.currval)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
		psmt = conn.prepareStatement(QNA_INSERT);
			
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getId());
			psmt.setString(3, vo.getPassword());
			psmt.setString(4, vo.getContent());
			psmt.setString(5, vo.getSecret());
			
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}
	
	//qna 상세보기
	
	public QnaVO selectOneBySeq(String seq) {
		String QNA_ONE = "select * from qna where seq = ?";
		
		QnaVO vo = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(QNA_ONE);
			psmt.setString(1,seq);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo = new QnaVO();
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setCnt(rs.getInt("cnt"));
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				vo.setSeq(rs.getInt("seq"));
				
				vo.setRef(rs.getInt("ref"));
				vo.setRestep(rs.getInt("restep"));
				vo.setRelevel(rs.getInt("relevel"));
				vo.setSecret(rs.getString("secret"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		return vo;
	}
	public void updateCnt(String seq) {
		String UPDATE_CNT = "update qna set cnt = cnt + 1 where seq=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(UPDATE_CNT);
			psmt.setString(1, seq);
			
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}
	
	//답글보기 뷰(상세보기랑 동일)
	public QnaVO replyQnaView(String seq) {
		String sql = "select * from qna where seq = ?";
		
		QnaVO vo = new QnaVO();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, seq);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				// vo = new QnaVO();
				
				vo.setSeq(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setId(rs.getString(3));
				vo.setPassword(rs.getString(4));
				vo.setContent(rs.getString(5));
				vo.setRegdate(rs.getTimestamp(6));
				vo.setCnt(rs.getInt(7));
				vo.setRef(rs.getInt(8));
				vo.setRestep(rs.getInt(9));
				vo.setRelevel(rs.getInt(10));
				vo.setSecret(rs.getString("secret"));

				//				vo.setSeq(rs.getInt("seq"));
//				vo.setTitle(rs.getString("title"));
//				vo.setId(rs.getString("id"));
//				vo.setPassword(rs.getString("password"));
//				vo.setContent(rs.getString("content"));
//				vo.setRegdate(rs.getTimestamp("regdate"));
//				vo.setCnt(rs.getInt("cnt"));
//				vo.setRef(rs.getInt("ref"));
//				vo.setRestep(rs.getInt("restep"));
//				vo.setRelevel(rs.getInt("relevel"));
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
				
		return vo;
	}
	
	//게시글 가져오기
	private void replyList(String seq) {
		String sql = "select ref, relevel, restep from qna where seq=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			int ref = 0;
			int restep = 0;
			int relevel = 0;
			
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, seq);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ref =  rs.getInt(1);
				relevel = rs.getInt(2);
				restep = rs.getInt(3);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//게시글에서 답글 순서(restep)
	private void replyUpdate(String seq, String ref, String restep) {
		
		replyList(seq);
		
		String sql = "update qna set restep=restep+1 where ref=? and restep>?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, ref);
			psmt.setString(2, restep);
			
			psmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
		// 게시글 및 답글 삭제
		public void deleteQna(String seq) {
		
		String sql = "delete qna where seq=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, seq);
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}
		
	// 답글 작성	
		public void qnaReply(String seq, String id, String password, String title, String content, String ref, String restep, String relevel) {
			replyUpdate(seq, ref, restep);
			
			String sql = "insert into qna(seq, title, password, id, content, ref, restep, relevel) values (qna_seq.nextval,?,?,?,?,?,?,?)";
			
			Connection conn = null;
			PreparedStatement psmt = null;
			
			
			try {
				conn = DBManager.getConnection();
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, title);
				psmt.setString(2, password);
				psmt.setString(3, id);
				psmt.setString(4, content);
				psmt.setString(5, ref);
				psmt.setInt(6, (Integer.parseInt(restep)+1));
				psmt.setInt(7, (Integer.parseInt(relevel)+1));
				
				psmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, psmt);
			}
		}
		
	
}
