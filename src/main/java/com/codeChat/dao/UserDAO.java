package com.codeChat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codeChat.dto.UserAndVideoVO;
import com.codeChat.dto.UserBoardVO;
import com.codeChat.dto.UserVO;

import util.DBManager;

public class UserDAO {

	private UserDAO() {
	}

	private static UserDAO instance = new UserDAO();

	public static UserDAO getInstance() {
		return instance;
	}

	public int confirmIDUser(String userid) {

		String sql = "select * from user01 where id = ?";
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return result;
	}

	public int confirmIDCompany(String userid) {

		String sql = "select * from company where id = ?";
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return result;
	}

	public int insertUser(UserVO userVO) {
		int result = 0;

		String sql = "insert into user01(id, password, name, email, role) values(?, ?, ?, ?, 'user')";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userVO.getId());
			pstmt.setString(2, userVO.getPassword());
			pstmt.setString(3, userVO.getName());
			pstmt.setString(4, userVO.getEmail());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public UserVO getUser(String id) {
		String sql = "select * from user01 where id = ?";

		UserVO userVO = null;

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();

			if (rs.next()) {
				userVO = new UserVO();
				userVO.setId(rs.getString("id"));
				userVO.setPassword(rs.getString("password"));
				userVO.setName(rs.getString("name"));
				userVO.setEmail(rs.getString("email"));
				userVO.setRole(rs.getString("role"));
				userVO.setVideoCode(rs.getInt("videoCode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt, rs);
		}
		return userVO;
	}

	public void updateUser(UserVO userVO) {
		//int cnt = 0;

		String sql = "update user01 set password=?, name=?, email=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userVO.getPassword());
			pstmt.setString(2, userVO.getName());
			pstmt.setString(3, userVO.getEmail());
			pstmt.setString(4, userVO.getId());

			pstmt.executeUpdate();
			//cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		//return cnt;

	}
	
	// user삭제
	public void deleteUser(UserVO userVO) {
		//int cnt = 0;

		String sql = "delete user01 where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userVO.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public ArrayList<UserBoardVO> listBoard(String id) {
		  
		  ArrayList<UserBoardVO> List = new ArrayList<UserBoardVO>();
		  String sql = "select * from userboard where id= ? order by seq desc";
		  
		  Connection conn = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  
		  try {
			  
			  conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1, id);
		      rs = pstmt.executeQuery(); 
		      
		      while (rs.next()) {
		    	  UserBoardVO vo = new UserBoardVO();
			    	vo.setSeq(rs.getInt("seq"));
					vo.setTitle(rs.getString("title"));
					vo.setId(rs.getString("id"));
					vo.setRegdate(rs.getTimestamp("regdate"));
					vo.setCnt(rs.getInt("cnt"));
					
					vo.setRef(rs.getInt("ref"));
					vo.setRestep(rs.getInt("restep"));
					vo.setRelevel(rs.getInt("relevel"));
		          
		          List.add(vo);
		      }
		      
		  } catch (Exception e) {
		    e.printStackTrace();
		  }
		 
		  return List;
	   }
	
	 public void deleteBoard(String seq) {
		    String sql = "delete userboard where seq=?";
		    
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    
		    try {
		      conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1, seq);
		      pstmt.executeUpdate();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      DBManager.close(conn, pstmt);
		    }
		 }
	 
	 public void updateVideoCode(int code, String id) {

			String sql = "update user01 set videoCode=? where id=?"; 

			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, code);
				pstmt.setString(2, id);
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			
	 }
	 
	 public List<UserAndVideoVO> getCodeList(String id) {
		  
		  String sql = "select * from userandvideo where id=?";
		  
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
		    	  userAndVideoVO.setVideoCode(rs.getInt("videoCode"));
		    	  
		    	  list.add(userAndVideoVO);
		      }
		  } catch (Exception e) {
		    e.printStackTrace();
		  }
		  
		  return list;
	   }

}
