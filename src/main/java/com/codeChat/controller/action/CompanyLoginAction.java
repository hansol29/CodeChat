package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeChat.dao.CompanyDAO;
import com.codeChat.dto.CompanyVO;

public class CompanyLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "CodeChatServlet?command=admin_login_form";
		
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		CompanyDAO cDAO = CompanyDAO.getInstance();
		CompanyVO cVO = cDAO.getCompany(id); 
		
		if(cVO != null) {
			if(cVO.getPassword().equals(password)) {
				session.removeAttribute("id");
				session.setAttribute("loginCompany", cVO);
				
				url = "CodeChatServlet?command=main";
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
