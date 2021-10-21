package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.UserBoardDAO;
import com.codeChat.dto.UserBoardVO;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBoardVO vo = new UserBoardVO();
		
		vo.setSeq(Integer.parseInt(request.getParameter("seq")));
		
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setId(request.getParameter("id"));
		
		UserBoardDAO dao = UserBoardDAO.getInstance();
		dao.updateBoard(vo);
		
		response.sendRedirect("CodeChatServlet?command=board_list");		
	}

}
