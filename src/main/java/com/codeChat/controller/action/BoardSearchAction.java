package com.codeChat.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.UserBoardDAO;
import com.codeChat.dto.UserBoardVO;

public class BoardSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "userboard/boardSearch.jsp";
		
		String opt = request.getParameter("opt");
		String condition = request.getParameter("condition");
		
		UserBoardDAO boardDAO = UserBoardDAO.getInstance();
		List<UserBoardVO> boardList = boardDAO.searchKeyword(opt, condition);
		
		System.out.println(boardList);
		
		System.out.println("search");
		
		request.setAttribute("boardList", boardList);
		
		request.getRequestDispatcher(url).forward(request, response);
				
	}

}
