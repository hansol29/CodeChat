package com.codeChat.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeChat.dao.UserBoardDAO;
import com.codeChat.dao.UserDAO;
import com.codeChat.dto.UserBoardVO;
import com.codeChat.dto.UserVO;


public class UserMypageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "mypage/userMypage.jsp";
		
		HttpSession session = request.getSession();
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		
		String id = request.getParameter("id");
		
		UserDAO userDAO = UserDAO.getInstance();
		UserVO userVO = userDAO.getUser(id);
		
		System.out.println(loginUser.getPassword());
		
		if(loginUser==null) {
			url = "CodeChatServlet?command=login_form";
		}
		

		request.setAttribute("id", userVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
