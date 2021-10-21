<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type = "text/javascript" src = "script/board.js"></script>
<link rel = "stylesheet" href = "css/codeChat.css">
<title>Insert title here</title>
</head>
<body>
<div id = "wrap">
<img style = "width : 100%; height : 300px" src = "images/computer.jpg"/>
<h1>자유게시판</h1>
<h2>게시글 등록</h2>



<form action = "CodeChatServlet" method = "post" name = "frm">
	<input type = "hidden" name = "command" value = "board_write">
	
<div class = "board">	
		<table id = "board">

			<tr>
				
				<td><input name = "title" size = "70" placeholder = "제목을 입력해주세요."></td>
			</tr>
			<tr>
				
				<td><input name = "id" size = "20" value = "${loginUser.id }" readonly></td>
			</tr>
			<tr>
				
				<td><textarea name = "content" cols = "70" rows = "15" placeholder = "내용을 입력해주세요."></textarea></td>
			</tr>
		</table>
		<br>
</div>		
		<div class = "button">
			<input type = "submit" id="submit" value = "등록" onclick = "return boardCheck()">
			<input type = "button" id="btn" value = "목록" onclick = "location.href = 'CodeChatServlet?command=board_list'">
			<input type = "reset" id="btn" value = "재작성">
		</div>
		
</form>
</div>

</body>
</html>

<%@ include file="../footer.jsp"%>