package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeChat.dao.UserDAO;
import com.codeChat.dto.UserVO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "logout.jsp";
		
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserDAO userDAO = UserDAO.getInstance();
		UserVO userVO = userDAO.getUser(id);
		
		if(userVO != null) {
			if(userVO.getPassword().equals(password)) {
				session.removeAttribute("id");
				session.setAttribute("loginUser", userVO);
				
				url = "CodeChatServlet?command=main";
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
