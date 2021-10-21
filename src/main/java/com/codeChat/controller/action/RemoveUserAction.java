package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeChat.dao.CompanyBoardDAO;
import com.codeChat.dao.CompanyDAO;
import com.codeChat.dao.UserBoardDAO;
import com.codeChat.dao.UserDAO;
import com.codeChat.dto.CompanyVO;
import com.codeChat.dto.UserVO;

public class RemoveUserAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "CodeChatServlet?command=main";
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO)session.getAttribute("loginUser");
		CompanyVO company = (CompanyVO)session.getAttribute("loginCompany");
		
		if (user != null && company == null) {
			UserDAO userDAO = UserDAO.getInstance();
			UserBoardDAO userBoardDAO = UserBoardDAO.getInstance();
			
			// user삭제하는 건 좋은데 user가 작성한 board가 외래키로 걸려있어서 일단 내용부터 다 지우고 삭제해야함.
			userBoardDAO.deleteBoardById(user);
			userDAO.deleteUser(user);
			
		} else if (company != null && user == null) {
			CompanyDAO companyDAO = CompanyDAO.getInstance();
			CompanyBoardDAO companyBoardDAO = CompanyBoardDAO.getInstance();
			
			companyBoardDAO.deleteBoardById(company);	// 여기 두 개
			companyDAO.deleteCompany(company);	// 순서 바뀌면 안됨
		}
		
		session.invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		// response.sendRedirect(url);
	}

}
