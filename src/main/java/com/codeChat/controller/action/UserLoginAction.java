package com.codeChat.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codeChat.dao.UserDAO;
import com.codeChat.dto.UserVO;

public class UserLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "CodeChatServlet?command=login_form";

		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String name = request.getParameter("name");

		// 이메일을 id로 db에 저장했기 때문에 다음과 같은 코드를 작성해줌
		if (password == null) {
			id = email;
		}

		UserDAO userDAO = UserDAO.getInstance();
		UserVO userVO = userDAO.getUser(id);

		// 기존 우리 회원이라면
		if (userVO != null) {

			// 카카오 로그인 시
			if (password == null) {
				
				session.removeAttribute("id");
				session.setAttribute("loginUser", userVO);

				url = "CodeChatServlet?command=main";

			} else {

				if (userVO.getPassword().equals(password)) {
					session.removeAttribute("id");
					session.setAttribute("loginUser", userVO);

					url = "CodeChatServlet?command=main";
				}
			}

		// 기존 우리 회원이 아니라면
		} else {
			
			if (password == null) {
				userVO = userDAO.getUser(email);

				
				// 여기서 id를 쿼리스트링으로 넘겨주지 않으면 계속 id에 null값이 떠서 아래처럼 처리해줌
				url = "CodeChatServlet?command=join&id=" + email; // 카카오로 로그인 한 적 없는 유저라면 회원가입도 동시에 진행
			} else {
				request.setAttribute("!user", "!user");
				url = "CodeChatServlet?command=usercontract";
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
