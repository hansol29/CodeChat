package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeChat.dao.UserAndVideoDAO;
import com.codeChat.dao.UserDAO;
import com.codeChat.dao.VideoDAO;
import com.codeChat.dto.UserVO;
import com.codeChat.dto.VideoVO;

public class PaySuccessAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "CodeChatServlet?command=myVideo";
		
		int code = Integer.parseInt(request.getParameter("code")); // 결제한 강의 code를 넘겨받음.
		
		System.out.println("구매한 강의 코드 : " + code );
		
		HttpSession session = request.getSession();
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		
		
		VideoDAO videoDAO = VideoDAO.getInstance();
		VideoVO videoVO = videoDAO.selectVideoByCode(code);
		
		UserDAO userDAO = UserDAO.getInstance();
		userDAO.updateVideoCode(code, loginUser.getId());
		UserVO userVO = userDAO.getUser(loginUser.getId());
		session.setAttribute("loginUser", userVO);
		
		UserAndVideoDAO userAndVideoDAO = UserAndVideoDAO.getInstance();
		userAndVideoDAO.insertUserAndVideo(code, loginUser.getId(), videoVO);
		
		
		System.out.println("userAndVideo 테이블에 구매자 아이디, 강의 코드번호 및 정보 삽입 완료.");
		
		
		request.getRequestDispatcher(url).forward(request, response);
		
		
		
	}

}
