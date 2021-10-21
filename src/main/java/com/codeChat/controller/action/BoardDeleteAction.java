package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeChat.dao.UserBoardDAO;
import com.codeChat.dto.UserVO;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "CodeChatServlet?command=login_form";
		String seq = request.getParameter("seq");
		String ref = request.getParameter("ref");
		
		HttpSession session = request.getSession();
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			request.getRequestDispatcher(url).forward(request, response);
		}else {
			UserBoardDAO dao = UserBoardDAO.getInstance();
			dao.deleteBoard(ref);
		}

		
		
		response.sendRedirect("CodeChatServlet?command=board_list");
	}

}
