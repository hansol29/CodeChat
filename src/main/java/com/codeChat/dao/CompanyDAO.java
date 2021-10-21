package com.codeChat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.codeChat.dto.CompanyBoardVO;
import com.codeChat.dto.CompanyVO;

import util.DBManager;

public class CompanyDAO {

	private CompanyDAO() {
	}

	private static CompanyDAO instance = new CompanyDAO();

	public static CompanyDAO getInstance() {
		return instance;
	}
	
	public int confirmIDUser(String userid) {
		  
		  String sql= "select * from user01 where id = ?";
		  int result = -1;
		  Connection conn = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  
		  try {
			  conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1, userid);
		      rs = pstmt.executeQuery();
		      
		      if(rs.next()) {
		    	  result = 1;
		      }else {
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
		  
		  String sql= "select * from company where id = ?";
		  int result = -1;
		  Connection conn = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  
		  try {
			  conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1, userid);
		      rs = pstmt.executeQuery();
		      
		      if(rs.next()) {
		    	  result = 1;
		      }else {
		    	  result = -1;
		      }
		      
			} catch (Exception e) {
			      e.printStackTrace();
			} finally {
			  DBManager.close(conn, pstmt, rs);
			}
		  
		  return result;
	  }
	
	public int insertCompany(CompanyVO companyVO) {
		  int result = 0;
		  
		  String sql = "insert into company(id, password, name, admin_num) values(?, ?, ?, ?)";
		    
		  Connection conn = null;
		  PreparedStatement pstmt = null;
		   
		  try {
			  conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      
		      pstmt.setString(1, companyVO.getId());      
		      pstmt.setString(2, companyVO.getPassword());
		      pstmt.setString(3, companyVO.getName());
		      pstmt.setInt(4, companyVO.getAdmin_num());
		     
		      result = pstmt.executeUpdate();
			} catch (Exception e) {
			      e.printStackTrace();
			} finally {
			  DBManager.close(conn, pstmt);
			}
		  return result;
	  }
	
	public CompanyVO getCompany(String id) {
		String sql = "select * from company where id = ?";
		
		CompanyVO companyVO = null;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				companyVO = new CompanyVO();
				companyVO.setId(rs.getString("id"));
				companyVO.setPassword(rs.getString("password"));
				companyVO.setName(rs.getString("name"));
				companyVO.setAdmin_num(Integer.parseInt(rs.getString("admin_num")));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		return companyVO;
	}
	
	public void updateCompany(CompanyVO companyVO) {

		String sql = "update company set password=?, name=?, admin_num=? where id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, companyVO.getPassword());
			pstmt.setString(2, companyVO.getName());
			pstmt.setInt(3, companyVO.getAdmin_num());
			pstmt.setString(4, companyVO.getId());

			System.out.println("CompanyDAO : " + companyVO.getId());
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("CompanyDAO 클래스 updateCompany()에서 나는 오류");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// company삭제
	public void deleteCompany(CompanyVO companyVO) {

		String sql = "delete company where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, companyVO.getId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public ArrayList<CompanyBoardVO> listBoard(String id) {
		  
		  ArrayList<CompanyBoardVO> List = new ArrayList<CompanyBoardVO>();
		  String sql = "select c.name, cb.* from company c, companyboard cb where c.id = cb.id and c.id=?";
		  
		  Connection conn = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  
		  try {
			  
			  conn = DBManager.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1,id);
		      rs = pstmt.executeQuery(); 
		      
		      while (rs.next()) {
		    	  	CompanyBoardVO companyVO = new CompanyBoardVO();
		    	  	companyVO.setName(rs.getString("name"));
					companyVO.setSeq(rs.getInt("seq"));
					companyVO.setId(rs.getString("id"));
					companyVO.setTitle(rs.getString("title"));
					companyVO.setContent(rs.getString("content"));
					companyVO.setCareer(rs.getString("career"));
					companyVO.setLoc(rs.getString("loc"));
					companyVO.setSal(rs.getInt("sal"));
					companyVO.setRegdate(rs.getDate("regdate"));
					companyVO.setCnt(rs.getInt("cnt"));
		          
		          List.add(companyVO);
		      }
		      
		  } catch (Exception e) {
		    e.printStackTrace();
		  }
		 
		  return List;
	   }
	
	public void deleteBoard(String seq) {
	    String sql = "delete companyboard where seq=?";
	    
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
	
}
