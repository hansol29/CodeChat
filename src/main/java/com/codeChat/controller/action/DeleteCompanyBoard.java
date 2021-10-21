package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.BoardDAO;
import com.codeChat.dao.CompanyBoardDAO;

public class DeleteCompanyBoard implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "CodeChatServlet?command=comBoardList";
		
		String seq = request.getParameter("seq");
		
		CompanyBoardDAO boardDAO = CompanyBoardDAO.getInstance();
		boardDAO.deleteCompanyBoard(Integer.parseInt(seq));
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}