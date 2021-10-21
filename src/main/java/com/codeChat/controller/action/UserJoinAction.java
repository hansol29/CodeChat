package com.codeChat.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeChat.dao.UserDAO;
import com.codeChat.dto.UserVO;

public class UserJoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "CodeChatServlet?command=main";

		HttpSession session = request.getSession();

		UserVO userVO = new UserVO();

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		userVO.setId(id);
		userVO.setPassword(password);
		userVO.setName(name);
		userVO.setEmail(email);

		UserDAO userDAO = UserDAO.getInstance();
		UserVO user = userDAO.getUser(userVO.getEmail());

		if (user != null) { 
			// 회원가입할 때 이미 카카오 계정으로 등록이 되어 있는 회원이라면?
			//if (user.getEmail().equals(email)) {
				request.setAttribute("isUser", "yes");
				url = "CodeChatServlet?command=login_form";
			//}
		} else {
			session.setAttribute("id", request.getParameter("id"));
			userDAO.insertUser(userVO);
			userVO = userDAO.getUser(request.getParameter("id"));
			if (userVO != null) {
				url = "CodeChatServlet?command=login";
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}