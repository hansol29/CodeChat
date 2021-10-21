package com.codeChat.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeChat.dao.CompanyDAO;
import com.codeChat.dao.UserDAO;
import com.codeChat.dto.CompanyBoardVO;
import com.codeChat.dto.CompanyVO;
import com.codeChat.dto.UserBoardVO;
import com.codeChat.dto.UserVO;

public class MyWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "mypage/myWrite.jsp";
		
		
		HttpSession session = request.getSession();
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		CompanyVO loginCompany = (CompanyVO)session.getAttribute("loginCompany");
		
		String id = request.getParameter("id");
		
		UserDAO userDAO = UserDAO.getInstance();
		UserVO userVO = userDAO.getUser(id);
		
		CompanyDAO companyDAO = CompanyDAO.getInstance();
		CompanyVO companyVO = companyDAO.getCompany(id);
		
		ArrayList<UserBoardVO> userList = null;
		ArrayList<CompanyBoardVO> companyList = null;
		
		
		
		/*
		 * if(loginUser == null || loginCompany == null) {
		 * 
		 * if (loginUser == null) { url = "CodeChatServlet?command=login_form"; } else
		 * if (loginCompany == null) { url = "CodeChatServlet?command=admin_login_form";
		 * } }
		 */
			
		if (loginUser != null) {
			userList = userDAO.listBoard(loginUser.getId());
		} else if (loginCompany != null) {
			companyList = companyDAO.listBoard(loginCompany.getId());
		}
			
		
		request.setAttribute("userList",userList);
		request.setAttribute("companyList",companyList);
		request.setAttribute("id", userVO);
		request.setAttribute("id", companyVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
