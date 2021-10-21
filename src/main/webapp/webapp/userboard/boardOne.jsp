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
<img style = "width : 100%; height : 300px" src = "images/computer.jpg"/>
<h1>자유게시판</h1>


<form>
	<input type = "hidden" name = "seq" value = "${board.seq }"/>
	<input type = "hidden" name = "ref" value = "${board.ref }"/>
</form>
<table id = "board_o">
	
	<tr>		
		<th colspan = "4" style="text-align:left" height="30px">${board.title }</th>
	</tr>
	<tr id = "board_" style="height:30px">
		
		<td>${board.id }</td>
		
		<td><fmt:formatDate type = "both" value = "${board.regdate }"/></td>
		<td>조회수</td>
		<td>${board.cnt }</td>
	</tr>
	<tr id = "board_c" >		
		<td style="text-align: left;" colspan = "4">${board.content }</td> 
	</tr>

	

</table><br><br>



<nav id = "buttons">
	
	<input type = "button" value = "목록" id="btn" onclick = "location.href = 'CodeChatServlet?command=board_list'">	
	
	<c:if test = "${board.restep == 0 }">
		<c:if test = "${board.id eq loginUser.id}">
			<input type = "button" value = "수정"  id="submit" onclick = "location.href = 'CodeChatServlet?command=board_update_form&seq=${board.seq}'">
			<input type = "button" value = "삭제"  id="submit" onclick = "location.href = 'CodeChatServlet?command=board_delete&ref=${board.ref}'">
		</c:if>
	</c:if>
	<c:if test = "${board.restep > 0 }">
		<c:if test = "${board.id eq loginUser.id}">
		<input type = "button" value = "수정"  id="submit" onclick = "location.href = 'CodeChatServlet?command=board_update_form&seq=${board.seq}'">
		<input type = "button" value = "삭제" id="submit" onclick = "location.href = 'CodeChatServlet?command=board_reply_delete&seq=${board.seq}'">
		</c:if>
	</c:if>

	
	<input type = "button" value = "답글"  id="submit" onclick = "location.href = 'CodeChatServlet?command=board_reply_view&seq=${board.seq}'">

</nav>

</div>











</body>
</html>

<%@ include file="../footer.jsp"%>