<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href = "css/codeChat.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action = "CodeChatServlet" method = "post" name = "frm">
	<input type = "hidden" name = "command" value = "qna_reply">
	
	<input type = "hidden" name = "seq" value = "${re_q.seq }">
	<input type = "hidden" name = "ref" value = "${re_q.ref }">
	<input type = "hidden" name = "restep" value = "${re_q.restep }">
	<input type = "hidden" name = "relevel" value = "${re_q.relevel }">
<div id = "wrap">
	<div class = "reply">
	<table id = "board">
		<tr>
			<th>글번호</th>
			<td>${re_q.seq }</td>
		</tr>
		<tr>
			<th>질문글 제목</th>
			<td><input name = "title_o"  size = "70" value = "${re_q.title } "></td>
		</tr>
				<tr>
			<th>답변글 제목</th>
			<td><input name = "title"  size = "70" value = ""></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input name = "id" value = "${loginUser.id }" readonly></td>
		</tr>

		<tr>
			<th>내용</th>
			<td><textarea name = "content" cols = "50" rows = "10" placeholder="내용을 입력해주세요."></textarea></td>
		</tr>
		</table>
		<div class = "button">
		
					
				<input type = "submit" id="submit" value = "답변">
				<input type = "button" id= "btn" value = "목록" onclick = "location.href = 'CodeChatServlet?command=qna_list'">				
							
			
		
		</div>
	
	</div>
</div>		
</form>

</body>
</html>

<%@ include file="../footer.jsp"%>