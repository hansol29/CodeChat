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
<script type = "text/javascript" src = "script/board.js"></script>
</head>
<body>
<div id="wrap">
<img style = "width : 100%; height : 300px" src = "images/computer.jpg"/>
<h1>자유게시판</h1>
<h2>글 수정</h2>
	<form method = "post" action = "CodeChatServlet">
	
		<input type = "hidden" value = "${board.seq }" name = "seq">
		<!-- <input type = "hidden" value = "${board.id }" name = "id"> -->
		<input type = "hidden" value = "board_update" name = "command">
		
		<table id = "board">
			<tr>
				
				<td><input name = "title" value = "${board.title }"></td>
			</tr>
			<tr>
				
				<td><input name = "id" size = "20" value = "${board.id }" readonly></td>
			</tr>
			<tr>
				
				<td><textarea name = "content" cols = "70" rows = "15">${board.content }</textarea></td> 
			</tr>
		</table><br><br>
		<div class="button">
		<input type = "submit" id="submit" value = "등록" onclick = "return boardCheck()">
		<input type = "reset" id="btn" value = "재작성">
		<input type = "button" id="btn"  value = "취소" onclick = "location.href='CodeChatServlet?command=board_list'">
		</div>
	</form>
</div>
</body>
</html>

<%@ include file="../footer.jsp"%>