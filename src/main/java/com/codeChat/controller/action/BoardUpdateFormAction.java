package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeChat.dao.UserBoardDAO;
import com.codeChat.dto.UserBoardVO;
import com.codeChat.dto.UserVO;

public class BoardUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/userboard/boardUpdate.jsp";
		
		HttpSession session = request.getSession();
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		
		String seq = request.getParameter("seq");
		
		if(loginUser == null) {
			url = "CodeChatServlet?command=login_form";
		}else {
			UserBoardDAO dao = UserBoardDAO.getInstance();
		
			dao.updateCnt(seq);
			UserBoardVO vo = dao.selectOneBySeq(seq);
			
			request.setAttribute("board", vo);
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

}
