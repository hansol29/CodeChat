package com.codeChat.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.CompanyBoardDAO;
import com.codeChat.dto.CompanyBoardVO;
import com.codeChat.dto.PageVO;

public class CompanyBoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "comBoard/companyBoardList.jsp";
		
		// 여기부터 페이지 기능
		String nowPage = request.getParameter("nowPage");
		String cntPerPage = request.getParameter("cntPerPage");
	
		CompanyBoardDAO cbDAO = CompanyBoardDAO.getInstance();
		int total = cbDAO.getListCount();
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "4";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "4";
		}
		
		PageVO pageVO = new PageVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		
		List<CompanyBoardVO> companyList = cbDAO.getCompanyList(pageVO);
		
		request.setAttribute("page", pageVO);
		request.setAttribute("companyList", companyList);
				
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}