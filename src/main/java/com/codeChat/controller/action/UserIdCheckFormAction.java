package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.UserDAO;

public class UserIdCheckFormAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "usermember/userIdcheck.jsp";
		
		String id = request.getParameter("id");
		
		UserDAO userDAO= UserDAO.getInstance();
		int Umessage = userDAO.confirmIDUser(id);
		int Cmessage = userDAO.confirmIDCompany(id);
		
		request.setAttribute("Umessage", Umessage);
		request.setAttribute("Cmessage", Cmessage);
		request.setAttribute("id", id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

}
