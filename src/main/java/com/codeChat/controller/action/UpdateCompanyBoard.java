package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.CompanyBoardDAO;
import com.codeChat.dto.CompanyBoardVO;

public class UpdateCompanyBoard implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "CodeChatServlet?command=comBoardList";

		CompanyBoardVO cbvo = new CompanyBoardVO();
		cbvo.setTitle(request.getParameter("title"));
		cbvo.setName(request.getParameter("comName"));
		cbvo.setContent(request.getParameter("content"));
		cbvo.setLoc(request.getParameter("loc"));
		cbvo.setSal(Integer.parseInt(request.getParameter("sal")));
		cbvo.setCareer(request.getParameter("career"));
		cbvo.setSeq(Integer.parseInt(request.getParameter("seq")));

		System.out.println("UpdateCompnayBoard : " + cbvo.getTitle());
		
		CompanyBoardDAO companyBoardDAO = CompanyBoardDAO.getInstance();
		companyBoardDAO.updateCompanyBoard(cbvo);
		
		response.sendRedirect(url);
	}
}
