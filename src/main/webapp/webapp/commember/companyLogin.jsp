<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>	 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="commember/companymember.js"></script>
<link rel = "stylesheet" href = "css/codeChat.css">
</head>
<body>
<div id = "login" align="center">
	<h2>기업 로그인</h2>
	<form action="CodeChatServlet?command=admin_login" method="post" name="formm" >
		<table>
			<tr>
				
				<td><input id = "login_c"  type="text" name="id" value="${id}"  placeholder="아이디"></td>
			</tr>
			<tr>
				
				<td><input id = "login_c"  type="password" name="password"  placeholder="비밀번호"></td>
			</tr>
			<tr>
				<td colspan="2">
				<div id = "login_button">
					<input type="button" value="로그인"
								onclick = "login()";>&nbsp;&nbsp;
					<input type="button" value="회원가입"
								onclick="location.href='CodeChatServlet?command=companycontract'">
				</div>
				</td>
			</tr>
			<tr><td colspan="2" >${message}</td></tr>
		</table>
	</form>
</div>
</body>
</html>
<%@ include file="../footer.jsp" %>