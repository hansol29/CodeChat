<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.jsp"%>

<%
	int listcount = ((Integer)request.getAttribute("listcount")).intValue();
	int nowpage = ((Integer)request.getAttribute("nowpage")).intValue();
	int maxpage = ((Integer)request.getAttribute("maxpage")).intValue();
	int startpage = ((Integer)request.getAttribute("startpage")).intValue();
	int endpage = ((Integer)request.getAttribute("endpage")).intValue();
	int limit = ((Integer)request.getAttribute("limit")).intValue();
%>


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
	
	
	<h3 style = "text-align:right">TOTAL : ${listcount }</h3>
		

	<table id = "List_1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>	
		</tr>
		<c:forEach var = "board" items = "${qnaList }">
			
			<tr onmouseover = "this.style.background='rgb(9, 26, 92, 0.05)'" onmouseout = "this.style = 'none'">
				<td style = "font-weight:bold" >${board.seq }</td>
				
				
				<td style = "text-align:left" >
					<c:if test = "${board.secret eq'N'}">		
						<c:choose>
							<c:when test = "${board.id eq loginUser.id || loginUser.role eq 'admin'}">
								 <c:forEach begin = "1" end = "${board.relevel }">&nbsp;&nbsp;&nbsp;<img src = "images/reply_icon.png" style="width:10px; height:10px;"/></c:forEach>
							<a style = "text-decoration:none" href = "CodeChatServlet?command=qna_one&seq=${board.seq}">${board.title }</a>
							</c:when>
							
							<c:otherwise><img style = "width : 13px; height : 13px; padding-right : 1%"src = "images/lock.png">비밀글은 작성자와 관리자만 볼 수 있습니다.</c:otherwise>
						</c:choose>
					</c:if>	
					<c:if test = "${board.secret eq 'Y' }">
						<c:forEach begin = "1" end = "${board.relevel }">&nbsp;&nbsp;&nbsp;<img src = "images/reply_icon.png" style="width:10px; height:10px;"/></c:forEach>
							<a style = "text-decoration:none" href = "CodeChatServlet?command=qna_one&seq=${board.seq}">${board.title }</a>		
					</c:if>
		
				</td>
				<td>${board.id }</td>
				<td><fmt:formatDate value = "${board.regdate }"/></td>
				<td>${board.cnt }</td>
			</tr>
		</c:forEach>
	</table>
	
	<div id = "page">
	<table>
	<tr style = "text-align:center">
		<%if(nowpage<=1){ %>
		<td>이전&nbsp;</td>
		<%}else{ %>
		<td><a href = "./CodeChatServlet?command=qna_list&nowpage=<%=nowpage-1%>">이전  </a>&nbsp;</td><%} %>
		<%for(int a = startpage;a<=endpage;a++){ 
		if(a==nowpage){%>
		<td><%=a %></td>
		<%}else{ %>
		<td><a href = "./CodeChatServlet?command=qna_list&nowpage=<%=a%>"><%=a   %></a>&nbsp;</td><%} %>
		<%} %>
		
		<%if(nowpage>=maxpage){ %>
		<td>다음</td>
		<%}else{ %>
		<td><a href = "./CodeChatServlet?command=qna_list&nowpage=<%=nowpage+1%>">다음  </a></td><%} %>
	</tr>
	</table>
	</div>
		
	
<nav id = "buttons">
<c:if test = "${loginUser != null }">
	<input type = "button" id="submit" value = "등록" onclick = "location.href='./CodeChatServlet?command=qna_write_form'">
</c:if>	
</nav>
</div>


</body>
</html>

<%@ include file="../footer.jsp"%>