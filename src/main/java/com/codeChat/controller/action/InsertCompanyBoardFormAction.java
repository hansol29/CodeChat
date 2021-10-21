package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.CompanyBoardDAO;

public class InsertCompanyBoardFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "comBoard/companyBoardWrite.jsp";
		
//		String id = request.getParameter("id");
//		
//		CompanyBoardDAO companyBoardDAO = CompanyBoardDAO.getInstance();
//		String companyNm = companyBoardDAO.getCompanyName(id);
//		request.setAttribute("companyNm", companyNm);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
