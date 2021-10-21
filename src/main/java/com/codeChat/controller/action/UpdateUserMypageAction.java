package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.UserDAO;
import com.codeChat.dto.UserVO;

public class UpdateUserMypageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "CodeChatServlet?command=main";

		UserVO userVO = new UserVO();
		userVO.setId(request.getParameter("id"));
		
		userVO.setPassword(request.getParameter("password"));
		userVO.setName(request.getParameter("name"));
		userVO.setEmail(request.getParameter("email"));

		System.out.println("UpdateUserMypage : " + userVO.getId());
		
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.updateUser(userVO);
		
		//request.getRequestDispatcher(url).forward(request, response);
		
		response.sendRedirect("CodeChatServlet?command=logout");
	}

}
