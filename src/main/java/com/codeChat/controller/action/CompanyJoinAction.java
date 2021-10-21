package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeChat.dao.CompanyDAO;
import com.codeChat.dto.CompanyVO;

public class CompanyJoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "CodeChatServlet?command=main";
		
		HttpSession session = request.getSession();

		CompanyVO companyVO = new CompanyVO();
		
		companyVO.setId(request.getParameter("id"));
		companyVO.setPassword(request.getParameter("password"));
		companyVO.setName(request.getParameter("name"));
		companyVO.setAdmin_num(Integer.parseInt(request.getParameter("admin_num")));  
	    
	    CompanyDAO companyDAO = CompanyDAO.getInstance();
	    companyDAO.insertCompany(companyVO);
	    
	    session.setAttribute("id",request.getParameter("id"));
	    
	    companyVO = companyDAO.getCompany(request.getParameter("id"));
	    if (companyVO != null) {
	    	url = "CodeChatServlet?command=main";
	    }
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

}
