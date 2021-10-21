<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href = "css/codeChat.css">
<title>ID 중복확인</title>
<script type="text/javascript">
function idok(){
	opener.formm.id.value="${id}"; 
	opener.formm.reid.value="${id}";
	self.close();
}
</script>

</head>
<body>
	<div id="wrap">
		<div id = "idcheck">
			<h1>ID 중복확인</h1>
			<form method="post" name="formm" action="CodeChatServlet?command=id_check_form" style="margin-right:0 ">
				<label>User ID</label>
					 <input type=text name="id" value=""> 
		            <input type=submit value="검색" id = "idchk_btn" ><br> 
		    <div style="margin-top: 20px" >
		    	<script>
		    		opener.document.formm.id.value="";
		    	</script>
		    	 <c:if test="${Cmessage == 1 || Umessage == 1}">
		    	 	${id }는 이미 사용중인 아이디 입니다.
		    	 </c:if> 
		    	 <c:if test="${Cmessage == -1 && Umessage == -1}">
		    	 	${id }는 사용가능한 아이디 입니다.
		    	 	<input type="button" value="사용" id="idchk_btn" onclick="idok()">
		    	 </c:if>           
 			</div>
 			</form>
    	</div>
    </div>
	

</body>
</html>