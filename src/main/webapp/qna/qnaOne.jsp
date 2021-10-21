<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%> 
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href = "css/codeChat.css">
<title>Insert title here</title>
</head>
<body>

<div id = "wrap">
<h1>Q&amp;A</h1>

<form>
	<input type = "hidden" name = "seq" value = "${qna.seq }"/>
<div class = "board">
	<table id = "board_qo">
		
		<tr>
			<th>제목</th>
			<td style = "text-align:left" colspan = "3">${qna.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td style = "text-align:left" colspan = "3">${qna.id }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate type = "both" value = "${qna.regdate}"/></td>
			<th>조회수</th>
			<td>${qna.cnt }</td>
		</tr>
		<tr id = "board_c">
			<th rowspan="5">내용</th>
			<td colspan = "5" rowspan = "5">${qna.content }</td> 
			
		</tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>



		

	</table><br><br>
</div>



<nav id = "buttons">
	
	<input type = "button" value = "목록" id="btn" onclick = "location.href = 'CodeChatServlet?command=qna_list'">	
	<c:if test = "${qna.id eq loginUser.id}">
		<input type = "button" value = "답글" id="submit" onclick = "location.href = 'CodeChatServlet?command=qna_reply_view&seq=${qna.seq}'">
		<input type = "button" value = "삭제"  id="submit" onclick = "location = 'CodeChatServlet?command=qna_delete&seq=${qna.seq}'">
	</c:if>
	<c:if test = "${loginUser.role == 'admin' }">
		<input type = "button" value = "답글"  id="submit" onclick = "location.href = 'CodeChatServlet?command=qna_reply_view&seq=${qna.seq}'">
	</c:if>
	

</nav>

</form>



</div>
</body>
</html>

<%@ include file="../footer.jsp"%>