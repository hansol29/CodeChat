package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.UserBoardDAO;
import com.codeChat.dto.UserBoardVO;

public class BoardOneAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "/userboard/boardOne.jsp";
			
		
		
		String seq = request.getParameter("seq");
		
			
		
		UserBoardDAO dao = UserBoardDAO.getInstance();
		UserBoardVO vo = dao.selectOneBySeq(seq);
		dao.updateCnt(seq);
		
		request.setAttribute("board", vo);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
