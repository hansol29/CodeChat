package com.codeChat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.codeChat.dto.CompanyBoardVO;
import com.codeChat.dto.CompanyVO;
import com.codeChat.dto.PageVO;

import util.DBManager;

// 회사 공고 게시판 관련 DB
public class CompanyBoardDAO {

	private CompanyBoardDAO() {
	}

	private static CompanyBoardDAO instance = new CompanyBoardDAO();

	public static CompanyBoardDAO getInstance() {
		return instance;
	}

	// 회사 채용공고 리스트(어차피 회사 이름만 보여지기 때문에 getCompanyList라고 메서드명 지음)
//	public List<CompanyBoardVO> getCompanyList() {
//
//		List<CompanyBoardVO> companyList = new ArrayList<CompanyBoardVO>();
//		// String sql = "select c.name, cb.* " + "from company c, companyboard cb " +
//		// "where c.id = cb.id";
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			conn = DBManager.getConnection();
//			// 회사 이름도 가져와야하기 때문에 company테이블과 조인해서 데이터 조회함
//			pstmt = conn.prepareStatement("select c.name, cb.* from company c, companyboard cb where c.id = cb.id order by seq desc");
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//
//				CompanyBoardVO companyVO = new CompanyBoardVO();
//				
//				companyVO.setName(rs.getString("name"));
//				companyVO.setSeq(rs.getInt("seq"));
//				companyVO.setId(rs.getString("id"));
//				companyVO.setTitle(rs.getString("title"));
//				companyVO.setContent(rs.getString("content"));
//				companyVO.setCareer(rs.getString("career"));
//				companyVO.setLoc(rs.getString("loc"));
//				companyVO.setSal(rs.getInt("sal"));
//				companyVO.setRegdate(rs.getDate("regdate"));
//				companyVO.setCnt(rs.getInt("cnt"));
//
//				companyList.add(companyVO);
//			}
//
//		} catch (Exception e) {
//			System.out.println("CompanyBoardDAO클래스 getCompanyList()에서 나는 오류");
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, pstmt, rs);
//		}
//
//		return companyList;
//	}

//	// 채용 정보 상세 보기
//	public CompanyBoardVO getCompanyBoard(String id, int seq) {
//
//		CompanyBoardVO companyBoardVO = null;
//		String sql = "select c.name, cb.* from company c, companyboard cb where c.id = cb.id and c.id=? and seq=?";
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			conn = DBManager.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			pstmt.setInt(2, seq);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				companyBoardVO = new CompanyBoardVO();
//
//				companyBoardVO.setName(rs.getString("name"));
//				companyBoardVO.setSeq(rs.getInt("seq"));
//				companyBoardVO.setId(rs.getString("id"));
//				companyBoardVO.setTitle(rs.getString("title"));
//				companyBoardVO.setContent(rs.getString("content"));
//				companyBoardVO.setCareer(rs.getString("career"));
//				companyBoardVO.setLoc(rs.getString("loc"));
//				companyBoardVO.setSal(rs.getInt("sal"));
//				companyBoardVO.setRegdate(rs.getDate("regdate"));
//				companyBoardVO.setCnt(rs.getInt("cnt"));
//			}
//
//		} catch (Exception e) {
//			System.out.println("CompanyBoardDAO클래스 getCompany()에서 나는 오류");
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, pstmt, rs);
//		}
//
//		return companyBoardVO;
//	}

	// 채용 정보 상세 보기
	public CompanyBoardVO getCompanyBoard(int seq) {

		CompanyBoardVO companyBoardVO = null;
		String sql = "select c.name, cb.* from company c, companyboard cb where c.id = cb.id and seq=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				companyBoardVO = new CompanyBoardVO();

				companyBoardVO.setName(rs.getString("name"));
				companyBoardVO.setSeq(rs.getInt("seq"));
				companyBoardVO.setId(rs.getString("id"));
				companyBoardVO.setTitle(rs.getString("title"));
				companyBoardVO.setContent(rs.getString("content"));
				companyBoardVO.setCareer(rs.getString("career"));
				companyBoardVO.setLoc(rs.getString("loc"));
				companyBoardVO.setSal(rs.getInt("sal"));
				companyBoardVO.setRegdate(rs.getDate("regdate"));
				companyBoardVO.setCnt(rs.getInt("cnt"));
			}

		} catch (Exception e) {
			System.out.println("CompanyBoardDAO클래스 getCompany()에서 나는 오류");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return companyBoardVO;
	}

//	public String getCompanyName(String id) {
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			conn = DBManager.getConnection();
//			pstmt = conn.prepareStatement("select name from company where id=?");
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery();
//		} catch (Exception e) {
//			System.out.println("CompanyBoardDAO클래스 updateCompanyBoard()에서 나는 오류");
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, pstmt);
//		}
//
//		return "";
//	}

	// 회사 공고 수정
	public void updateCompanyBoard(CompanyBoardVO cbVO) {

		String sql = "update companyboard set title=?, content=?, loc=?, sal=?, career=? where seq=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cbVO.getTitle());
			pstmt.setString(2, cbVO.getContent());
			pstmt.setString(3, cbVO.getLoc());
			pstmt.setInt(4, cbVO.getSal());
			pstmt.setString(5, cbVO.getCareer());
			// pstmt.setString(6, cbVO.getId());
			pstmt.setInt(6, cbVO.getSeq());

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("CompanyBoardDAO클래스 updateCompanyBoard()에서 나는 오류");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 채용공고 삭제
	public void deleteCompanyBoard(int seq) {

		String sql = "delete from companyBoard where seq=? ";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, seq);

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("CompanyBoardDAO클래스 deleteCompanyBoard()에서 나는 오류");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//게시글 삭제(id로 조회해서, 해당 id로 로그인한 사람의 모든 글 삭제) - 회원 탈퇴를 위함
	public void deleteBoardById(CompanyVO vo) {
		String BOARD_DELETE = "delete companyboard where id=?";
		
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

	// 채용 공고 등록
	public void insertCompanyBoard(CompanyBoardVO cbVO) {

		String sql = "insert into companyboard(seq, title, content, loc, sal, career, id) values(com_seq.NEXTVAL,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cbVO.getTitle());
			pstmt.setString(2, cbVO.getContent());
			pstmt.setString(3, cbVO.getLoc());
			pstmt.setInt(4, cbVO.getSal());
			pstmt.setString(5, cbVO.getCareer());
			pstmt.setString(6, cbVO.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("CompanyBoardDAO클래스 insertCompanyBoard()에서 나는 오류");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	

	// 조건 검색
	public List<CompanyBoardVO> selectCompanyBoardList(CompanyBoardVO cbVO, PageVO pageVO) {

		List<CompanyBoardVO> comList = new ArrayList<CompanyBoardVO>();

		String sql = "select * from (select rownum rn, a.* from ( select c.name, cb.* from company c, companyboard cb where (c.id = cb.id) ";

		int locSize = 0;
		int salSize = 0;
		int careerSize = 0;

		if (cbVO.getLocArr() != null) {
			locSize = cbVO.getLocArr().length;
		}
		if (cbVO.getSalArr() != null) {
			salSize = cbVO.getSalArr().length;
		}
		if (cbVO.getCareerArr() != null) {
			careerSize = cbVO.getCareerArr().length;
		}

		if (locSize > 0) {
			sql += " and (loc='" + cbVO.getLocArr()[0] + "'";

			for (int i = 1; i < locSize; i++) {
				sql += " or loc='" + cbVO.getLocArr()[i] + "'";
			}
			sql += ")";
		}

		if (salSize > 0) {

			if (cbVO.getSalArr()[0] == 5000) {
				sql += "and (sal >= " + cbVO.getSalArr()[0] + ") ";
			} else {
				sql += " and (sal between " + cbVO.getSalArr()[0] + " and " + (cbVO.getSalArr()[0] + 999);

				for (int i = 1; i < salSize; i++) {
					sql += "  or sal between " + cbVO.getSalArr()[i] + " and " + (cbVO.getSalArr()[i] + 999);
				}
				sql += ")";
			}
		}

		if (careerSize > 0) {
			sql += " and (career='" + cbVO.getCareerArr()[0] + "'";

			for (int i = 1; i < careerSize; i++) {
				sql += " or career='" + cbVO.getCareerArr()[i] + "'";
			}
			sql += ")";
		}

		sql += " order by seq desc ) a) where rn between ? and ?";

		System.out.println(sql); // 이거 확인해보면 위 for문 코드 이해 가능함

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageVO.getStart());
			pstmt.setInt(2, pageVO.getEnd());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CompanyBoardVO company = new CompanyBoardVO();

				company.setName(rs.getString("name"));
				company.setSeq(rs.getInt("seq"));
				company.setId(rs.getString("id"));
				company.setTitle(rs.getString("title"));
				company.setContent(rs.getString("content"));
				company.setCareer(rs.getString("career"));
				company.setLoc(rs.getString("loc"));
				company.setSal(rs.getInt("sal"));
				company.setRegdate(rs.getDate("regdate"));
				company.setCnt(rs.getInt("cnt"));

				comList.add(company);
			}
			System.out.println(comList);
		} catch (Exception e) {
			System.out.println("CompanyBoardDAO클래스 selectCompanyBoardList()에서 나는 오류");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return comList;
	}

	// 조회수 업데이트
	public void updateCnt(String seq) {
		String UPDATE_CNT = "update companyboard set cnt = cnt + 1 where seq = ?";

		Connection conn = null;
		PreparedStatement psmt = null;

		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(UPDATE_CNT);
			psmt.setString(1, seq);

			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);
		}
	}

	// 총 게시글 수 조회
	public int getListCount() {

		String sql = "select count(*) from companyboard";
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	// 조건 검색 시 선택된 데이터 자료
	public int getSelectListCount(CompanyBoardVO cbVO) {

		int result = 0;
		String sql = "select count(*) from (select a.* from ( select c.name, cb.* from company c, companyboard cb where (c.id = cb.id) ";

		int locSize = 0;
		int salSize = 0;
		int careerSize = 0;

		if (cbVO.getLocArr() != null) {
			locSize = cbVO.getLocArr().length;
		}
		if (cbVO.getSalArr() != null) {
			salSize = cbVO.getSalArr().length;
		}
		if (cbVO.getCareerArr() != null) {
			careerSize = cbVO.getCareerArr().length;
		}

		if (locSize > 0) {
			sql += " and (loc='" + cbVO.getLocArr()[0] + "'";

			for (int i = 1; i < locSize; i++) {
				sql += " or loc='" + cbVO.getLocArr()[i] + "'";
			}
			sql += ")";
		}

		if (salSize > 0) {

			if (cbVO.getSalArr()[0] == 5000) {
				sql += "and (sal >= " + cbVO.getSalArr()[0] + ") ";
			} else {
				sql += " and (sal between " + (cbVO.getSalArr()[0]) + " and " + (cbVO.getSalArr()[0] + 999);

				for (int i = 1; i < salSize; i++) {
					sql += "  or sal between " + (cbVO.getSalArr()[i] + " and " + (cbVO.getSalArr()[i] + 999));
				}
				sql += ")";
			}
		}

		if (careerSize > 0) {
			sql += " and (career='" + cbVO.getCareerArr()[0] + "'";

			for (int i = 1; i < careerSize; i++) {
				sql += " or career='" + cbVO.getCareerArr()[i] + "'";
			}
			sql += ")";
		}

		sql += " ) a)";

		System.out.println(sql); // 이거 확인해보면 위 for문 코드 이해 가능함

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("CompanyBoardDAO클래스 getSelectListCount()에서 나는 오류");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	// 페이징처리를 위한 데이터 조회
	public List<CompanyBoardVO> getCompanyList(PageVO pageVO) {

		List<CompanyBoardVO> companyList = new ArrayList<CompanyBoardVO>();
		String sql = "select * from ( select rownum rn, a.*	from ( select c.name, cb.* from company c, companyboard cb where c.id = cb.id order by seq desc ) a) where rn between ? and ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageVO.getStart());
			pstmt.setInt(2, pageVO.getEnd());
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

				companyList.add(companyVO);
			}

		} catch (Exception e) {
			System.out.println("CompanyBoardDAO클래스 getCompanyList()에서 나는 오류");
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return companyList;
	}
}
