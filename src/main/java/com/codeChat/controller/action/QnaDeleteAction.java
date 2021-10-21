package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.QnaDAO;

public class QnaDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "CodeChatServlet?command=qna_list";
		
		String seq = request.getParameter("seq");

		QnaDAO qnaDAO = QnaDAO.getInstance();
		qnaDAO.deleteQna(seq);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
