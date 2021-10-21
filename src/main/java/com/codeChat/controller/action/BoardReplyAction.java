package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.UserBoardDAO;

public class BoardReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "CodeChatServlet?command=board_list";
		
		String seq = request.getParameter("seq");
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		String ref = request.getParameter("ref");
		String restep = request.getParameter("restep");
		String relevel = request.getParameter("relevel");
		
		
		UserBoardDAO boardDAO = UserBoardDAO.getInstance();
		boardDAO.boardReply(seq, id, title, content, ref, restep, relevel);
		
		
		response.sendRedirect(url);
		//request.getRequestDispatcher(url).forward(request, response);
	}

}
