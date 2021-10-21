package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeChat.dao.UserBoardDAO;
import com.codeChat.dto.UserBoardVO;
import com.codeChat.dto.UserVO;

public class BoardReplyViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "userboard/boardReplyView.jsp";
		String seq = request.getParameter("seq");
		
		HttpSession session = request.getSession();
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		
		
		if(loginUser == null) {
			url = "CodeChatServlet?command=login_form";
		}else {
		
			UserBoardDAO boardDAO = UserBoardDAO.getInstance();
			UserBoardVO vo = boardDAO.replyBoardView(seq);
		

			request.setAttribute("reply", vo);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	

}
