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
<script type = "text/javascript" src = "/member/member.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<script type="text/javascript">

Kakao.init('825e20e9b495041667a0d8602b13404f');

	function test() {
		const result = confirm("탈퇴하시면 지금까지 작성하신 모든 내역이 사라집니다. \n 정말 탈퇴하시겠습니까?");
		
	   if (result) {
	    	
	    	Kakao.API.request({
	    	      url: '/v1/user/unlink',	// 카카오에서 제공하는 연결 끊는 방법
	    	      success: function(res) {
	    	        alert('success: ' + JSON.stringify(res))	// JSON.stringify() 메서드는 JavaScript 값이나 객체를 JSON 문자열로 변환합니다.
	    	      },
	    	      fail: function(err) {
	    	        alert('fail: ' + JSON.stringify(err))
	    	      },
	    	    })
    	    location.href="CodeChatServlet?command=removeUser";
	    }
	}
	
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
			location.href='CodeChatServlet?command=updateuser2';
		}
	}
</script>
<body>
<div id = "wrap">
<fieldset id="user_mypage">
<legend>회원 정보 수정</legend>
	<form action="CodeChatServlet?command=updateuser2" method="post" name="formm" class="form">
		<div id = "mypage_info">
			<label class="label">아이디: </label>	
			<label class="label_c">${loginUser.id}</label>	<br><br>
						
			<label class="label">비밀번호: </label><input type="password" class="label_c"  name="password" placeholder="비밀번호를 입력하세요" required><br><br>
		</div>
		<!-- 
		<label class="label">닉네임: </label><label class="label">${loginUser.name}</label><br><br>
		<label class="label">이메일: </label><label class="label">${loginUser.email}</label><br><br>
		 -->
		<div class ="mypage_button">
			<input type="button" id="submit" value="회원 정보 수정" onclick = "pwcheck()">
			<input type="button" id="btn" value="메인" onclick="location.href='CodeChatServlet?command=main'">
			<input type="button" id="submit" value="회원 탈퇴" onclick="test()">
		</div>	
	</form>

</fieldset>
</div>
<br><br>
</body>
</html>

<%@ include file="../footer.jsp"%>