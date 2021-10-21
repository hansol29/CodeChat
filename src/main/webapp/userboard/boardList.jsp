<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.jsp"%>
<%@ page import = "com.codeChat.dto.UserBoardVO" %>

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

<!-- <script>
	function search(){
		if(document.search.condition.value == ""){
			alert("검색어를 입력해주세요.")
			document.search.condition.focus();
		}else{
			document.search.action("CodeChatServlet?command=board_search");
			document.search.submit();
		}
	}
</script> -->
<meta charset="UTF-8">
<link rel = "stylesheet" href = "css/codeChat.css">
<title>Insert title here</title>
</head>
<body>

<div id = "wrap">
	
	<img style = "width : 100%; height : 300px" src = "images/computer.jpg"/>
	<h1>자유게시판</h1>
	
	
	
	<nav id = "buttons">
		<input type = "button" value = "조회수"  id="btn" name = "cnt" onclick = "location.href ='./CodeChatServlet?command=board_list_cnt'">
		<input type = "button" value = "작성일"  id="btn"  name = "reg" onclick = "location.href ='./CodeChatServlet?command=board_list'">
	</nav><br>		
	<h3 style = "text-align:left">TOTAL : ${listcount }</h3>
		

	<table id = "List_1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>	
		</tr>
		<c:forEach var = "board" items = "${boardList }">
			<tr onmouseover = "this.style.background='rgb(9, 26, 92, 0.05)'" onmouseout = "this.style = 'none'">
				<td style = "font-weight:bold" >${board.seq }</td>
				<td style = "text-align:left">
					
					<c:forEach begin = "1" end = "${board.relevel }"  varStatus="num">
						<c:choose>
							<c:when test="${num.current == board.relevel}">
								&nbsp;&nbsp;&nbsp;<img src = "images/reply_icon.png" style="width:10px; height:10px;"/>
							</c:when>
							<c:otherwise>
								&nbsp;&nbsp;&nbsp;<img src = "images/re_reply_icon.jpg" style="width:10px; height:10px;"/>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<a style = "text-decoration:none" href = "CodeChatServlet?command=board_one&seq=${board.seq}">${board.title }</a>
					
				</td>
				<td>${board.id }</td>
				<td><fmt:formatDate value = "${board.regdate }"/></td>
				<td>${board.cnt }</td>
			</tr>
		</c:forEach>
	</table>
	
	
	<!--페이징 -->
	<div id = "page">
	<table>
	<tr >
		
		<%if(nowpage<=1){ %>
		<td>
			처음&nbsp;
		</td>
		<td>
			이전&nbsp;
		</td>
		
		<%}else{ %>
		<td onmouseover = "this.style.background='rgb(9, 26, 92, 0.05)'" onmouseout = "this.style = 'none'">
			<a href = "./CodeChatServlet?command=board_list&nowpage=<%=startpage%>">처음 </a>&nbsp;
		</td>
		<td onmouseover = "this.style.background='rgb(9, 26, 92, 0.05)'" onmouseout = "this.style = 'none'">
			<a href = "./CodeChatServlet?command=board_list&nowpage=<%=nowpage-1%>">이전 </a>&nbsp;
		</td><%} %>
		
		<%for(int a = startpage;a<=endpage;a++){ 
		if(a==nowpage){%>
			<td onmouseover = "this.style.background='rgb(9, 26, 92, 0.05)'" onmouseout = "this.style = 'none'">
				<%=a %>
			</td>
		<%}else{ %>
			<td onmouseover = "this.style.background='rgb(9, 26, 92, 0.05)'" onmouseout = "this.style = 'none'">
				&nbsp;<a href = "./CodeChatServlet?command=board_list&nowpage=<%=a%>"><%=a   %></a>&nbsp;
			</td><%} %>
		<%} %>
		
		<%if(nowpage>=maxpage){ %>
		<td>
			다음
		</td>
		<td>
			끝
		</td>
		<%}else{ %>
			<td onmouseover = "this.style.background='rgb(9, 26, 92, 0.05)'" onmouseout = "this.style = 'none'">
				<a href = "./CodeChatServlet?command=board_list&nowpage=<%=nowpage+1%>">다음  </a>
			</td>
			<td onmouseover = "this.style.background='rgb(9, 26, 92, 0.05)'" onmouseout = "this.style = 'none'">
				<a href = "./CodeChatServlet?command=board_list&nowpage=<%=maxpage%>">끝  </a>
			</td>
		<%} %>
		
		
	</tr>
	</table>
	</div>	
	
	
	
<nav id = "buttons">
<c:if test = "${loginUser != null }">
	<input type = "button" value = "등록" id="submit" onclick = "location.href='./CodeChatServlet?command=board_write_form'">
</c:if>	
</nav>

	<!--검색 -->
	<div id = "search">
		<form name = "search" action ="./CodeChatServlet?command=board_search" method ="post">
		
			<table>
				<tr>
					<td>
						<select name = "opt">
							<option value = "T_C">제목+내용
							<option value = "TITLE">제목
							<option value = "CONTENT">내용
							<option value = "ID">작성자
						</select>						
						<input name = "condition" id = "search_condition" type = "text" required>
						<input type = "submit" id ="submit" value = "검색" >	
					
					</td>
				</tr>
			</table> 		
		</form>
	</div>		
</div>
</body>
</html>

<%@ include file="../footer.jsp"%>