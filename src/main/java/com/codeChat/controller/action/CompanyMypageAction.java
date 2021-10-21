package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeChat.dao.CompanyDAO;
import com.codeChat.dao.UserDAO;
import com.codeChat.dto.CompanyVO;
import com.codeChat.dto.UserVO;

public class CompanyMypageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "mypage/companyMypage.jsp";
		
		HttpSession session = request.getSession();
		CompanyVO loginCompany = (CompanyVO)session.getAttribute("loginCompany");

		String id = request.getParameter("id");
		
		CompanyDAO companyDAO = CompanyDAO.getInstance();
		CompanyVO companyVO = companyDAO.getCompany(id);
		
		System.out.println(loginCompany.getPassword());
		
		if(loginCompany==null) {
			url = "CodeChatServlet?command=admin_login_form";
		}
		

		request.setAttribute("id", companyVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
