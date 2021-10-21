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
<body>
<div id = "wrap">
<fieldset id="company_mypage">
<legend>회원정보수정</legend>
    <form action="CodeChatServlet?command=updatecompany" method="post" name="fr" class="form">
    	
    	<div id = "mypage_info">
	        <label class="label"> 아이디: </label><input name = "id" value = "${loginCompany.id }" readonly><br>
	        <label class="label">비밀번호: </label><input type="password" name="password" placeholder="비밀번호를 입력하세요"><br>
	        <label class="label"> 기업명: </label><input type="text" name="name" placeholder="${loginCompany.name }" value="" ><br>
	        <label class="label" style = "width :150px;"> 사업자등록번호: </label><input type="text" name="admin_num" placeholder="${loginCompany.admin_num }" value=""><br>
     	</div>
      	
      	<div class="mypage_button">
	        <input type="button" id="btn" value="취소" onclick="history.go(-1)">
	        <input type="submit" id="submit" value="수정" 
	        		onclick="alert('정보 수정이 완료되었습니다. \n재로그인해 주세요.')" style="width : 60px">
	        <input type="button" id="btn" value="메인" onclick="location.href='CodeChatServlet?command=main'">
  		</div>
    </form>
</fieldset>
</div>
</body>
</html>

<%@ include file="../footer.jsp"%>