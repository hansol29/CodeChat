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
<script type = "text/javascript" src = "../usermember/usermember.js"></script>
<style>

	}
	
</style>
</head>
<body>
<div id = "wrap">
<fieldset id="user_mypage">
<legend>회원정보수정</legend>
    <form action="CodeChatServlet?command=updateuser" method="post" name="fr" class="form">
    	
    	<div id = "mypage_info">
	        <label class="label"> 아이디: </label><input name = "id" value = "${loginUser.id }" readonly><br>
	        <label class="label">비밀번호: </label><input type="password" name="password" placeholder="비밀번호를 입력하세요" required><br>
	        <label class="label"> 닉네임: </label><input type="text" name="name" placeholder="${loginUser.name }" value="" ><br>
	        <label class="label"> 이메일: </label><input type="text" name="email" placeholder="${loginUser.email }" value=""><br>
     	</div>
      	
      	<div class="mypage_button">
	        <input type="button" id="btn" value="취소" onclick="history.go(-1)">
	        <input type="submit" id="submit" value="수정" style="width : 60px">
	        <input type="button" id="btn" value="메인" onclick="location.href='CodeChatServlet?command=main'">
  		</div>
    </form>
</fieldset>
</div>
</body>
</html>

<%@ include file="../footer.jsp"%>