package com.codeChat.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeChat.dao.QnaDAO;

import com.codeChat.dto.QnaVO;
import com.codeChat.dto.UserVO;


public class QnaListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "qna/qnaList.jsp";
		
		HttpSession session = request.getSession();
		UserVO loginUser = (UserVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			url = "CodeChatServlet?command=login_form";
		}else {
			
		
		
		QnaDAO qnaDAO = QnaDAO.getInstance();
		int nowpage = 1;
		int limit = 10;
		
		if(request.getParameter("nowpage")!= null) {
			nowpage = Integer.parseInt(request.getParameter("nowpage"));
		}
		int listcount = qnaDAO.getListCount();
	
		
		
		List<QnaVO> qnaList = qnaDAO.selectAllBoard(nowpage, limit);
		
		
		int maxpage = (int)((double)listcount/limit+0.95);
		int startpage = (((int)((double)nowpage / 10 + 0.9)) - 1) * 10 + 1;
		
		int endpage = startpage+9;
		
		if(endpage>maxpage)
			endpage = maxpage;
		
		request.setAttribute("nowpage", nowpage);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("limit", limit);
		
		request.setAttribute("qnaList", qnaList);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	
	}

}
