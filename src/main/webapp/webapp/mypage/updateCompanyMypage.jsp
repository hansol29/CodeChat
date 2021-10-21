<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href = "css/codeChat.css">
<title>Insert title here</title>
<script type = "text/javascript" src = "../companymember/companymember.js"></script>
</head>
<body>
<fieldset>
<legend>회원정보수정</legend>
	<form action="CodeChatServlet?command=admin_mypage" method="post" name="fr">
		아이디: <input type="text" name="id" value="${loginCompany.id }" readonly><br>
		비밀번호: <input type="password" name="password" placeholder="비밀번호를 입력하세요" required><br>
		닉네임: <input type="text" name="name" value="${loginCompany.name } "><br>
		이메일: <input type="text" name="admin_num" value="${loginCompany.admin_num }"><br>
		<input type="button" class="btn" value="회원 탈퇴">
		<input type="submit" class="btn" value="회원 정보 수정">
		<input type="button" class="btn" value="메인으로" onclick="location.href='../index'">
	</form>
</fieldset>
</body>
</html>

<%@ include file="../footer.jsp"%>