package com.codeChat.controller.action;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.CompanyBoardDAO;
import com.codeChat.dto.CompanyBoardVO;
import com.codeChat.dto.PageVO;

public class SelectAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "comBoard/companyBoardList.jsp";
		
		// 조건 검색 데이터를 위함
		List<CompanyBoardVO> companyList = null;
		
		PageVO pageVO = null;

		String[] locations = request.getParameterValues("loc");
		String[] salarys = request.getParameterValues("sal");
		String[] career = request.getParameterValues("career");
		System.out.println(Arrays.toString(locations));
		System.out.println(Arrays.toString(salarys));
		System.out.println(Arrays.toString(career));
		int size = 0;
		
		if (salarys != null) {
			size = salarys.length;
		}
		int[] intSalarys = new int[size];

		for (int i = 0; i < size; i++) {
			intSalarys[i] = Integer.parseInt(salarys[i]);
		}
		CompanyBoardDAO dao = CompanyBoardDAO.getInstance();
		
		CompanyBoardVO comBoardVO = new CompanyBoardVO();
		comBoardVO.setLocArr(locations);
		comBoardVO.setSalArr(intSalarys);
		comBoardVO.setCareerArr(career);
		
		// 그냥 조회 버튼을 눌렀을 때는 기본 모양이 나와야함
		String nowPage = request.getParameter("nowPage");
		String cntPerPage = request.getParameter("cntPerPage");
		
		CompanyBoardDAO cbDAO = CompanyBoardDAO.getInstance();
		
		int total = 0;
		
		if (locations == null && salarys == null && career == null) {	// 데이터 전체 조회
			total = cbDAO.getListCount();
		} else {	// 조건 검색 들어감
			total = cbDAO.getSelectListCount(comBoardVO);
		}
		
		
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "5";
		}
		
		pageVO = new PageVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
	
		if (locations == null && salarys == null && career == null) {	// 데이터 전체 조회
			companyList = dao.getCompanyList(pageVO);
		} else {	// 조건 검색 들어감
			companyList = dao.selectCompanyBoardList(comBoardVO, pageVO);
		}

		request.setAttribute("page", pageVO);
		request.setAttribute("companyList", companyList);

		request.setAttribute("locations", locations);
		request.setAttribute("salarys", salarys);
		request.setAttribute("career", career);

		request.getRequestDispatcher(url).forward(request, response);
	}
}
