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
<script type = "text/javascript" src = "../commember/companymember.js"></script>
</head>
<script type="text/javascript">


	function pwcheck() {
		var password = <%=(String)session.getAttribute("password")%>;
		
		if(document.formm.password.value == "") {
			alert('비밀번호를 입력하여 주십시오.');
			document.formm.password.focus();
			return false;
		} else if(document.formm.password.value != '1234') {
			alert('비밀번호가 일치하지 않습니다.');
			document.formm.password.focus();
			return false;
		} else {
			location.href='CodeChatServlet?command=updatecompany2';
		}
	}
	function test(){
		const result = confirm("탈퇴하시면 지금까지 작성하신 모든 내역이 사라집니다. \n 정말 탈퇴하시겠습니까?");
		
		if(result){
			
			location.href="CodeChatServlet?command=removeUser";
		
		}
	}
</script>
<body>
<div id = "wrap">
<fieldset id="company_mypage">
<legend>회원 정보 수정</legend>
	<form action="CodeChatServlet?command=updatecompany2" method="post" name="formm" class="form">
		<div id = "mypage_info">
			<label class="label">아이디: </label>	
			<label class="label_c">${loginCompany.id}</label>	<br><br>
						
			<label class="label">비밀번호: </label><input type="password" class="label_c"  name="password" placeholder="비밀번호를 입력하세요"><br><br>
		</div>
		<!-- 
		<label class="label">기업명: </label><label class="label">${loginCompany.name}</label><br><br>
		<label class="label">사업자등록번호: </label><label class="label">${loginCompany.admin_num}</label><br><br>
		 -->
		<div class ="mypage_button">
			<input type="button" id="submit" value="회원 정보 수정" onclick = "pwcheck()">
			<input type="button" id="btn" value="메인" onclick="location.href='CodeChatServlet?command=main'">
			<input type="button" id="submit" value="회원 탈퇴" onclick = "test()">
		</div>	
	</form>

</fieldset>
</div>
</body>
</html>

<%@ include file="../footer.jsp"%>