package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.CompanyDAO;

public class CompanyIdCheckFormAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "commember/companyIdcheck.jsp";
		
		String id = request.getParameter("id");
		
		CompanyDAO companyDAO = CompanyDAO.getInstance();
		int Umessage = companyDAO.confirmIDUser(id);
		int Cmessage = companyDAO.confirmIDCompany(id);
		
		request.setAttribute("Umessage", Umessage);
		request.setAttribute("Cmessage", Cmessage);
		request.setAttribute("id", id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

}
