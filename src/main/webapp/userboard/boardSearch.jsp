<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../header.jsp"%>
<!DOCTYPE html>



<div id = "wrap">
<img style = "width : 100%; height : 300px" src = "images/computer.jpg"/>
<h2>검색결과</h2>
<table id = "List">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th><a style = "text-decoration:none" href = "./CodeChatServlet?command=board_list">작성일</a></th>
			<th><a style = "text-decoration:none" href = "./CodeChatServlet?command=board_list_cnt">조회수</a></th>	
		</tr>
		<c:forEach var = "board" items = "${boardList }">
			<tr>
				<td>${board.seq }</td>
				<td style ="text-align:left"><a style = "text-decoration:none" href = "CodeChatServlet?command=board_one&seq=${board.seq}">${board.title }</a></td>
				<td>${board.id }</td>
				<td><fmt:formatDate value = "${board.regdate }"/></td>
				<td>${board.cnt }</td>
			</tr>
		</c:forEach>
	</table>
	
	<nav id = "buttons">
	<input type = "button" id= "btn" value = "목록" onclick = "location.href = 'CodeChatServlet?command=board_list'">
	</nav>
</div>	


<%@ include file="../footer.jsp"%>