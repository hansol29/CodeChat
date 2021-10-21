package com.codeChat.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeChat.dao.BoardDAO;
import com.codeChat.dto.BoardVO;

public class mainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/index.jsp";
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		ArrayList<BoardVO> newBoardList = boardDAO.listNewBoard();
		ArrayList<BoardVO> bestBoardList = boardDAO.listBestBoard();
		ArrayList<BoardVO> userBoardList = boardDAO.listUserBoard();
		ArrayList<BoardVO> companyBoardList = boardDAO.listCompanyBoard();
		
		request.setAttribute("newBoardList",newBoardList);
		request.setAttribute("bestBoardList",bestBoardList);
		request.setAttribute("userBoardList",userBoardList);
		request.setAttribute("companyBoardList",companyBoardList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
