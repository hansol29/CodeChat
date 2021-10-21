package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.QnaDAO;
import com.codeChat.dto.QnaVO;

public class QnaOneAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "qna/qnaOne.jsp";
		
		String seq = request.getParameter("seq");
		
		QnaDAO qnaDAO = QnaDAO.getInstance();
		QnaVO vo = qnaDAO.selectOneBySeq(seq);
		qnaDAO.updateCnt(seq);
		
		request.setAttribute("qna", vo);

		request.getRequestDispatcher(url).forward(request, response);
	}
}
