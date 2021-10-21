package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeChat.dto.UserVO;

public class QnaWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "qna/qnaWrite.jsp";
		
		HttpSession session = request.getSession();
		UserVO loginUser= (UserVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			url = "CodeChatServlet?command=login_form";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
