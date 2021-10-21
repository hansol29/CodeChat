package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.CompanyBoardDAO;
import com.codeChat.dto.CompanyBoardVO;

public class InsertCompanyBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "CodeChatServlet?command=comBoardList";
		
		String title = request.getParameter("title");
		String companyNm = request.getParameter("companyNm");
		String content = request.getParameter("content");
		String loc = request.getParameter("loc");
		String sal = request.getParameter("sal");
		String career = request.getParameter("career");
		String id = request.getParameter("id");

		CompanyBoardVO companyBoardVO = new CompanyBoardVO();
		companyBoardVO.setTitle(title);
		companyBoardVO.setName(companyNm);
		companyBoardVO.setContent(content);
		companyBoardVO.setLoc(loc);
		companyBoardVO.setSal(Integer.parseInt(sal));
		companyBoardVO.setCareer(career);
		companyBoardVO.setId(id);
		
		CompanyBoardDAO companyBoardDAO = CompanyBoardDAO.getInstance();
		companyBoardDAO.insertCompanyBoard(companyBoardVO);
		
		response.sendRedirect(url);
	}
}
