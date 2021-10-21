<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "../header.jsp"%>
<link rel = "stylesheet" href = "css/codeChat.css">
 
<form name = "formm" method = "post" action = "CodeChatServlet?command=qna_write">

<div id = "wrap">
<h1>Q&amp;A</h1>
	
	<div class="board">
		<table id = "board">

			<tr>
			
				<td><input name = "title"   placeholder = "제목을 입력해주세요."></td>
			</tr>
			<tr>

				<td><input name = "id"  value = "${loginUser.id }" readonly></td>
			</tr>
			<tr>

				<td><textarea name = "content" cols = "70" rows = "8" placeholder = "궁금하신 내용을 입력해주세요."></textarea></td>
			</tr>
			
			
		</table>
		</div>
			<table style="margin-left : 160px; width:60%" id = "secret"  >
				<tr>
					<td>
						<b>공개글 설정&nbsp;&nbsp;  </b>
				    	<input type="radio" name="secret" id="secret" value="Y" />공개
				    	<input type="radio" name="secret" id="secret" value="N"/>비공개
					</td>
				</tr>
			</table>	
		

	</div>	
	<div class ="clear"></div>
		
		
		<div class = "button">
			<input type = "submit" id="submit" value = "질문">
			<input type = "reset" id="btn" value = "재작성">
			<input type = "button" id ="btn" value = "목록" onclick = "location.href='CodeChatServlet?command=qna_list'">
		</div>
	

</form>



<%@ include file = "../footer.jsp"%>