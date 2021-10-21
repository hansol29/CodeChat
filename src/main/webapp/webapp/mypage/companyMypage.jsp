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
<script type = "text/javascript" src = "../commember/companymember.js"></script>
</head>
<body>
<fieldset>
<legend>회원정보수정</legend>
	<form action="CodeChatServlet?command=updatecompany" method="post" name="fr">
		아이디: <label name = "id">${loginCompany.id }</label><br>
		비밀번호: <input type="password" name="password" placeholder="비밀번호를 입력하세요" required><br>
		기업명: <label name = "id">${loginCompany.name }</label><br>
		사업자등록번호: <label name = "id">${loginCompany.admin_num }</label><br>
		<input type="button" class="btn" value="회원 탈퇴">
		<input type="submit" class="btn" value="회원 정보 수정">
		<input type="button" class="btn" value="메인으로" onclick="location.href='../index'">
	</form>
</fieldset>
</body>
</html>

<%@ include file="../footer.jsp"%>