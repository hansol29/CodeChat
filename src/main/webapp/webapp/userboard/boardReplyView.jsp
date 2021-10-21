<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../header.jsp"%>

<html>
<head>
<link rel = "stylesheet" href = "css/codeChat.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action = "CodeChatServlet" method = "post" name = "frm">
	<input type = "hidden" name = "command" value = "board_reply">
	
	<input type = "hidden" name = "seq" value = "${reply.seq }">
	<input type = "hidden" name = "ref" value = "${reply.ref }">
	<input type = "hidden" name = "restep" value = "${reply.restep }">
	<input type = "hidden" name = "relevel" value = "${reply.relevel }">
	
<div id = "wrap">
<img style = "width : 100%; height : 300px" src = "images/computer.jpg"/>
	<h1>자유게시판</h1>
	<h2>답글 작성</h2>

	<table id = "board_r">
	
		
		<!-- 
		<tr>
			<th>글번호</th>
			<td>${reply.seq }</td>
		</tr>
		
		<tr>
			<th>조회수</th>
			<td>${reply.cnt }</td>
		</tr> 
		 -->
		<tr>
			<td><input type = "hidden" name = "id" value = "${loginUser.id }" readonly></td>
		</tr> 
		<tr>
			<th>원 글 제목</th>
			<td><input name = "title_o" value = "${reply.title }" readonly></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input name = "title" value = "" placeholder="답글 제목을 입력해주세요."></td>
		</tr>


		<tr>
			<th>내용</th>
			<td><textarea name = "content" cols = "60" rows = "15" placeholder="내용을 입력해주세요."></textarea></td>
		</tr>
		</table>
		<div class = "button">							
				<input type = "submit" id="submit" value = "답글">
				<input type = "button" value = "목록" id="btn" onclick = "location.href = 'CodeChatServlet?command=board_list'">				
				<input type = "reset" value = "재작성"  id="btn" >			
			
		
		</div>
	

</div>		
</form>

</body>
</html>

<%@ include file="../footer.jsp"%>