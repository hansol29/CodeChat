<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>	 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="usermember/usermember.js"></script>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="js/jquery-3.6.0.min.js"></script> -->
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel = "stylesheet" href = "../css/codeChat.css">
</head>
<body>
<div id = "login" align ="center">
	<h2>개인 로그인</h2>
	<form action="CodeChatServlet?command=login" method="post" name="formm" >
		<div id="result"></div>
		<table>
			<tr>
				<td><input id = "login_c" type="text" name="id" value="${id}" placeholder="아이디"></td>
			</tr>
			<tr>
				<td><input id = "login_c" type="password" name="password" placeholder="비밀번호"></td>
			</tr>
			<tr>
				<td colspan="2">
				<div id = "login_button">
					<input type="button" value="로그인"
								onclick = "login()">&nbsp;&nbsp;
					<input type="button" value="회원가입"
								onclick="location.href='CodeChatServlet?command=usercontract'">
				</div>
				</td>
			</tr>
			<tr><td colspan="2" >${message}</td></tr>
		</table>
	
		<a id="kakao-login-btn"></a>
	</form>
	
<!-- 
	<a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=a8da732256e9c4c33925ad93bdf41577&redirect_uri=http://localhost:8181/CodeChat/CodeChatServlet?command=login">
    	<img src="images/kakao_login_medium_narrow.png" style="cursor: pointer"/>
	</a>
	<script>
	var walletAddress;
	var totalReceirved;
	var key;
	var txIdarray = null;
	var txId = null;
	
	// api불러오기
	function api(code) {
		var grant_type = "autorization_code";
		var client_id = "a8da732256e9c4c33925ad93bdf41577";
		var redirect_uri = "http://localhost:8181/CodeChat/CodeChatServlet?command=login";
		var code = code;
		
		$.post("https://kauth.kakao.com/oauth/token", {grant_type:grant_type, client_id:client_id, redirect_uri:redirect_uri, code:code});
			
		var access_token = date['access_token']
		
		tokenFunction(access_token);
	}
	
	var tokenRequest = new XMLHttpRequest();
	
	function tokenfunction(access_token) {
		var access_token = access_token;
		
		tokenRequest.open("Post", "../tokenServlet?access_token=" + access_token, true);
		tokenRequest.onreadystatechange = tokenProcess;
		tokenRequest.send(null);
	}
	
	function tokenProcess() {
		
		if (tokenRequest.readyState == 4 && tokenRequest.status == 200) {
			
			var result = tokenRequest.responseText;
			
			if (result == 1) {
				alert("location.href사용해서 로그인완료 펭지ㅣ로 이동시키기");
			} else {
				alert("location.href사용해서 회원가입 페이지로 이동시키기");
			}
		}
	}
 </script> -->
</div>
<script type="text/javascript">
// 지금 이메일이 선택동의로 되어있는데 비즈니스로 돈 내고 가입하면 이메일도 필수동의 할 수 있음. 근데 지금 굳이 그럴 필요는 없으니까 항상 전체 동의하고 로그인 시도하겠음

Kakao.init('825e20e9b495041667a0d8602b13404f');
console.log(Kakao.isInitialized());	// 초기화가 잘 되었는지 확인하는 메소드(isInitialized())

  Kakao.Auth.createLoginButton({	// 로그인 버튼에 이벤트 핸들러를 등록해주는 함수
    container: '#kakao-login-btn',	// 자동으로 카카오계정으로 로그인이 씌워지네
    success: function(authObj) {	// 로그인 버튼을 눌렀을 때 제대로 작동이 되는 경우
      Kakao.API.request({	// 카카오에 api를 요청한다
        url: '/v2/user/me',	// 카카오에서 여기로 요청하라고 이미 적어놓은 주소
        success: function(result) {	// 요청이 제대로 먹혀 들어가서 성공했다면
          console.log(result);	// 확인
          id = result.id	// 결과 중 id값 받기
          connected_at = result.connected_at	// 연결 시간 받기
          kakao_account = result.kakao_account	// 카카오 계정(내가 동의항목에서 요청했던거 - 성별, 이메일 등등) 받기
          console.log(kakao_account);
         // resultdiv = '<input type="hidden" name="id" value=' + id  + connected_at + '/>'
          email ="";
          name = "";
          if(typeof kakao_account != 'undefined'){	// 카카오계정에 값이 있는 경우
        	  email = kakao_account.email;	// 이메일과
        	  name = kakao_account.profile.nickname;	// 닉네임 받음
          }
        
         // 아래 세 개 servlet으로 보내는 코드 
         // resultdiv = '<input type="hidden" name="id" value="id"/>'
         // resultdiv += '<input type="hidden" name="email" value="email"'/>'
         // resultdiv += '<input type="hidden" name="name" value="name"/>'
         const form = document.createElement('form'); 
         form.setAttribute('method', 'post');
         form.setAttribute('action', 'CodeChatServlet?command=login');
         document.charset = 'utf-8';
         /* const hiddenPwd = document.createElement('input');	// 비밀번호
         hiddenPwd.setAttribute('type', 'hidden');
         hiddenPwd.setAttribute('name', 'password');
         hiddenPwd.setAttribute('value', id);
         form.appendChild(hiddenPwd); */
         const hiddenEmail = document.createElement('input');	// email
         hiddenEmail.setAttribute('type', 'hidden');
         hiddenEmail.setAttribute('name', 'email');
         hiddenEmail.setAttribute('value', email);
         form.appendChild(hiddenEmail);
         const hiddenName = document.createElement('input');	// 닉네임(뒤에서는 계속 name이라는 변수로 사용함)
         hiddenName.setAttribute('type', 'hidden');
         hiddenName.setAttribute('name', 'name');
         hiddenName.setAttribute('value', name);
         form.appendChild(hiddenName);
         
         $('#result').append(form);
         form.submit();
         
        },
        fail: function(error) {	// api 요청이 제대로 안먹혔다면
          alert(
            'login success, but failed to request user information: ' +
              JSON.stringify(error)
          )
        },
      })
    },
    fail: function(err) {	// 로그인 버튼 눌렀는데 제대로 실행이 안됐다면
      alert('failed to login: ' + JSON.stringify(err))
    },
  })
</script>
</body>
</html>
<%@ include file="../footer.jsp" %>