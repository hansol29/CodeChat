package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.QnaDAO;
import com.codeChat.dto.QnaVO;

public class QnaWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		QnaVO vo = new QnaVO();
		
		vo.setTitle(request.getParameter("title"));
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setContent(request.getParameter("content"));
		vo.setSecret(request.getParameter("secret"));
		
		
		
	
		
		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.insertQNA(vo);
		
		response.sendRedirect("CodeChatServlet?command=qna_list");
	}

}
