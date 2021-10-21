package com.codeChat.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeChat.dao.VideoDAO;
import com.codeChat.dto.UserVO;
import com.codeChat.dto.VideoVO;


@WebServlet("/videoList.do")
public class VideoListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "video/videoList.jsp";
		VideoDAO vDao = VideoDAO.getInstance();
		
		List<VideoVO> videoList = vDao.selectAllVideos();
		request.setAttribute("videoList", videoList);
		
		HttpSession session2 = request.getSession();
		UserVO loginUser = (UserVO)session2.getAttribute("loginUser"); 
		   
		if(loginUser == null){
			url = "CodeChatServlet?command=login_form";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
