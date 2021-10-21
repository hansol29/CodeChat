package com.codeChat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.codeChat.dto.UserBoardVO;
import com.codeChat.dto.UserVO;

import util.DBManager;

public class UserBoardDAO {

	private UserBoardDAO() {
	}

	private static UserBoardDAO instance = new UserBoardDAO();

	public static UserBoardDAO getInstance() {
		return instance;
	}
	

//전체 글 갯수
public int getListCount(){
    int count = 0;
    String BOARD_COUNT = "select count(*) from userboard";
    
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;
    
    try{
        conn = DBManager.getConnection();
        psmt = conn.prepareStatement(BOARD_COUNT);
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


//자유게시판 전체보기
public List<UserBoardVO> selectAllBoard(int nowpage, int limit){

		
		
		String SELECT_ALL_SEQ = "select * from (select rownum rnum, seq, id, title, content, ref, relevel, restep, cnt, regdate from (select * from userboard order by ref desc, restep asc)) where rnum>=? and rnum<=?";
				//"select * from userboard order by ref desc, restep asc";
		//String SELECT_ALL_CNT = "select * from userboard order by cnt desc";
		
		List<UserBoardVO> list = new ArrayList<UserBoardVO>();
		
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
				UserBoardVO vo = new UserBoardVO();
				
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setId(rs.getString("id"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				
				vo.setRef(rs.getInt("ref"));
				vo.setRestep(rs.getInt("restep"));
				vo.setRelevel(rs.getInt("relevel"));
				
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		return list;
	}

//자유게시판 전체보기(조회수 정렬)
	public List<UserBoardVO> selectAllBoard_CNT(int nowpage, int limit){
		
		
		
		String SELECT_ALL_CNT = "select * from (select rownum rnum, seq, id, title, content, ref, relevel, restep, cnt, regdate from (select * from userboard order by cnt desc)) where rnum>=? and rnum<=?";
				//"select * from userboard order by cnt desc";
		
		List<UserBoardVO> list = new ArrayList<UserBoardVO>();
		
		int startrow = (nowpage-1)*10+1;
		int endrow = startrow + limit-1;
		
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			
			psmt = conn.prepareStatement(SELECT_ALL_CNT);
			psmt.setInt(1, startrow);
			psmt.setInt(2, endrow);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				UserBoardVO vo = new UserBoardVO();
				
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setId(rs.getString("id"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				
				vo.setRef(rs.getInt("ref"));
				vo.setRestep(rs.getInt("restep"));
				vo.setRelevel(rs.getInt("relevel"));
				
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		return list;
	}

//새 글 작성
	public void insertBoard(UserBoardVO vo) {
		String BOARD_INSERT = "insert into userboard(seq, title, id, content, ref) values (user_seq.nextval,?,?,?,user_seq.currval)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(BOARD_INSERT);
			
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getId());
			psmt.setString(3, vo.getContent());
			
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}

//상세보기
	public UserBoardVO selectOneBySeq(String seq) {
		String BOARD_ONE = "select * from userboard where seq = ?";
		
		UserBoardVO vo = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(BOARD_ONE);
			psmt.setString(1, seq);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo = new UserBoardVO();
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setCnt(rs.getInt("cnt"));
				vo.setId(rs.getString("id"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				vo.setSeq(rs.getInt("seq"));
				
				vo.setRef(rs.getInt("ref"));
				vo.setRestep(rs.getInt("restep"));
				vo.setRelevel(rs.getInt("relevel"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		
		return vo;
	}
//조회수 업데이트	
	public void updateCnt(String seq) {
		String UPDATE_CNT = "update userboard set cnt = cnt + 1 where seq = ?";
		
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

//게시글 수정
	public void updateBoard(UserBoardVO vo) {
		String BOARD_UPDATE = "update userboard set title=?, content=?, id=? where seq=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(BOARD_UPDATE);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getId());
			psmt.setInt(4, vo.getSeq());
			
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}

	//게시글 삭제
	public void deleteBoard(String seq) {
		String BOARD_DELETE = "delete userboard where ref=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(BOARD_DELETE);
			psmt.setString(1, seq);
			
			
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//게시글 삭제(id로 조회해서, 해당 id로 로그인한 사람의 모든 글 삭제) - 회원 탈퇴를 위함
	public void deleteBoardById(UserVO vo) {
		String BOARD_DELETE = "delete userboard where id=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(BOARD_DELETE);
			psmt.setString(1, vo.getId());
			
			
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteBoard_R(String seq) {
		String BOARD_DELETE_R = "delete userboard where seq=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(BOARD_DELETE_R);
			psmt.setString(1, seq);
			
			
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


//답글보기 뷰(상세보기랑 동일)
	public UserBoardVO replyBoardView(String seq) {
		String sql = "select * from userboard where seq = ?";
		
		UserBoardVO vo = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, seq);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo = new UserBoardVO();
				
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setId(rs.getString("id"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				vo.setRef(rs.getInt("ref"));
				vo.setRestep(rs.getInt("restep"));
				vo.setRelevel(rs.getInt("relevel"));
								
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
		String sql = "select ref, relevel, restep from userboard where seq=?";
		
		
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
		
		String sql = "update userboard set restep=restep+1 where ref=? and restep>?";
		
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
	
//답글 작성	
	public void boardReply(String seq, String id, String title, String content, String ref, String restep, String relevel) {
		replyUpdate(seq, ref, restep);
		
		String sql = "insert into userboard(seq, title, id, content, ref, restep, relevel) values (user_seq.nextval,?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, id);
			psmt.setString(3, content);
			psmt.setString(4, ref);
			psmt.setInt(5, Integer.parseInt(restep)+1);
			psmt.setInt(6, Integer.parseInt(relevel)+1);
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}

//검색	
	public ArrayList<UserBoardVO> searchKeyword(String opt,String condition){
		
		
				
		ArrayList<UserBoardVO> list = new ArrayList<UserBoardVO>();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String BOARD_SEARCH = "select * from userboard ";
		String sql = "";
		
		if(opt.equals("TITLE")) {
			sql = "where TITLE like '%" + condition.trim() + "%'";
		}else if(opt.equals("ID")) {
			//sql = "where ID='" + condition.trim() + "'";			//아이디 정확히 기입
			sql = "where ID like '%" + condition.trim() + "%'";		//아이디 일부 기입
		}else if(opt.equals("CONTENT")) {
			sql = "where CONTENT like '%" + condition.trim() + "%'";		
		}else if(opt.equals("T_C")) {
			sql = "where TITLE like '%" + condition.trim() + "%' or CONTENT like '%" + condition.trim() + "%'";
		}
		
		BOARD_SEARCH = BOARD_SEARCH + sql;
		
		//sql += "order by regdate desc";
		sql += "order by regdate desc";
		
		try {
			conn = DBManager.getConnection();
			
			//if(opt.equals("TITLE")) {
				//BOARD_SEARCH ="select * from userboard where ? like '%'||?||'%' order by regdate desc";
				
				psmt = conn.prepareStatement(BOARD_SEARCH);
				
				//psmt.setString(1, opt);
				//psmt.setString(2, condition);
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					UserBoardVO vo = new UserBoardVO();
					
					vo.setSeq(rs.getInt("seq"));
					vo.setTitle(rs.getString("title"));
					vo.setId(rs.getString("id"));
					vo.setRegdate(rs.getTimestamp("regdate"));
					vo.setCnt(rs.getInt("cnt"));
					
					vo.setRef(rs.getInt("ref"));
					vo.setRestep(rs.getInt("restep"));
					vo.setRelevel(rs.getInt("relevel"));
					
					list.add(vo);
				
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return list;
	}
	

}
