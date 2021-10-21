package com.codeChat.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeChat.dao.UserAndVideoDAO;
import com.codeChat.dto.UserAndVideoVO;
import com.codeChat.dto.UserVO;

public class MyVideoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "mypage/myVideo.jsp";
		
		HttpSession session = request.getSession();
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		
		System.out.println("로그인 유저 정보 가져옴 : " + loginUser.getId() );

		
		UserAndVideoDAO userAndVideoDAO = UserAndVideoDAO.getInstance();
		ArrayList<UserAndVideoVO> myVideos = userAndVideoDAO.getCodeList(loginUser.getId());
		
		System.out.println("로그인 아이디와 일치하는 강의 목록 list에 추가 : " + myVideos);
		
		session.setAttribute("myVideos", myVideos);
		
//		System.out.println("유저 정보에 등록된 코드 가져옴 : " + userVO.getVideoCode() );
//		
//		VideoDAO videoDAO = VideoDAO.getInstance();
//		VideoVO videoVO = videoDAO.selectVideoByCode(userVO.getVideoCode());
		
//		request.setAttribute("videoVO", videoVO);
		
		System.out.println("session영역에 해당 유저의 강의 정보 저장");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
