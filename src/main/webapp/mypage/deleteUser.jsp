<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/codeChat.css">
<title>Insert title here</title>
<script type="text/javascript" src="../usermember/usermember.js"></script>
</head>
<body>
	<%
	// 로그인 처리 -> 로그인 x (로그인페이지 이동)
	String id = (String) session.getAttribute("id");
	if (id == null) {
		response.sendRedirect("CodeChatServlet?command=login");
	}
	%>
	<fieldset>
		<legend>회원 탈퇴</legend>
		<form action="CodeChatServlet?command=deleteuser" method="post">
			<!-- input타입중 hidden은 화면에 있는 해당 input태그를 숨겨서 정보 전달   -->
			아이디 : <input type="text" name="id" value="<%=id%>" readonly><br>
			비밀번호 : <input type="password" name="password"><br> <input
				type="submit" class="btn" value="탈퇴하기"> <input type="button"
				class="btn" value="뒤로가기" onclick="location.href='../index'">
		</form>
	</fieldset>
</body>
</html>

<%@ include file="../footer.jsp"%>