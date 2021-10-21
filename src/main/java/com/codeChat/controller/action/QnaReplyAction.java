package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.QnaDAO;

public class QnaReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "CodeChatServlet?command=qna_list";
		
		String seq = request.getParameter("seq");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		String ref = request.getParameter("ref");
		String restep = request.getParameter("restep");
		String relevel = request.getParameter("relevel");
		
		QnaDAO qnaDAO = QnaDAO.getInstance();
		
		if (restep!= null && !restep.equals("")) {
			qnaDAO.qnaReply(seq, id, password, title, content, ref, restep, relevel);
		}
		
		// response.sendRedirect(url);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
