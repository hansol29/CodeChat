package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.CompanyDAO;
import com.codeChat.dao.UserDAO;

public class DeleteMyWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "CodeChatServlet?command=myWrite";

		if (request.getSession().getAttribute("loginUser") != null) {
			String[] seqArr = request.getParameterValues("seq");

			for (String seq : seqArr) {
				System.out.println(seq);
				UserDAO userDAO = UserDAO.getInstance();
				userDAO.deleteBoard(seq);
			}
		} else if (request.getSession().getAttribute("loginCompany") != null) {
			String[] seqArr = request.getParameterValues("seq");

			for (String seq : seqArr) {
				System.out.println(seq);
				CompanyDAO companyDAO = CompanyDAO.getInstance();
				companyDAO.deleteBoard(seq);
			}
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

}
