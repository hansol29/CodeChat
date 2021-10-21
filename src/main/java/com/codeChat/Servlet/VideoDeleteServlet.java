package com.codeChat.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.VideoDAO;
import com.codeChat.dto.VideoVO;


@WebServlet("/videoDelete.do")
public class VideoDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		
		VideoDAO vDao = VideoDAO.getInstance();
		VideoVO vVo = vDao.selectVideoByCode(code);
		
		request.setAttribute("video", vVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("video/videoDelete.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		
		VideoDAO vDao = VideoDAO.getInstance();
		vDao.deleteVideo(code);
		
		response.sendRedirect("videoList.do");
	}

}
