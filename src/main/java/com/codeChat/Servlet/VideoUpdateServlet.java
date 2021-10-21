
package com.codeChat.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.VideoDAO;
import com.codeChat.dto.VideoVO;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/videoUpdate.do")
public class VideoUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		
		VideoDAO vDao = VideoDAO.getInstance();
		VideoVO vVo = vDao.selectVideoByCode(code);
		
		request.setAttribute("video", vVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("video/videoUpdate.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 1000 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType);
		
		String code = multi.getParameter("code");
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String description = multi.getParameter("description");
		String videoUrl = multi.getFilesystemName("videoUrl");
		if (videoUrl == null) {
			videoUrl = multi.getParameter("nonmakeImg");
		}
		VideoVO vVo = new VideoVO();
		vVo.setCode(Integer.parseInt(code));
		vVo.setName(name);
		vVo.setPrice(price);
		vVo.setDescription(description);
		vVo.setVideoUrl(videoUrl);
		
		VideoDAO vDao = VideoDAO.getInstance();
		vDao.updateVideo(vVo);

		response.sendRedirect("videoList.do");

	}
}
