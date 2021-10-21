package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.CompanyBoardDAO;
import com.codeChat.dto.CompanyBoardVO;

public class UpdateComBoardFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "comBoard/companyBoardUpdate.jsp";
		
		String seq = request.getParameter("seq");
		
		CompanyBoardDAO companyBoardDAO = CompanyBoardDAO.getInstance();
		//CompanyBoardVO comBoard = companyBoardDAO.getCompanyBoard(id, Integer.parseInt(seq));
		CompanyBoardVO comBoard = companyBoardDAO.getCompanyBoard(Integer.parseInt(seq));
		request.setAttribute("comBoard", comBoard);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
