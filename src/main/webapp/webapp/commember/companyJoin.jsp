<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript" src="commember/companymember.js"></script>
<link rel = "stylesheet" href = "css/codeChat.css">
     <div id = "login" align="center">
	    <h2>회원가입(기업)</h2>
	    <form id="join" action="CodeChatServlet?command=admin_join_form" method="post" name="formm">
	      <table cellpadding="0" cellspacing="0" align="center">
		      <tr>

		      	<td>
			      	<input id = "login_c"  type="text"      name="id"     placeholder = "아이디" style="margin-left : 7%;">
			        <input type="hidden"    name="reid">
			        <input type="button"    value="중복 체크"  class="dup" onclick="idcheck()">
		      	</td>
		      </tr>
		  	  <tr>
			  
		      	<td>
		      		<input id = "login_c"  type="password"  name="password" placeholder = "비밀번호">
		      	</td>
		  	  </tr>
		  	  <tr>
		  	  	
		      	<td>
			      	<input id = "login_c"  type="password"  name="passwordCheck"  placeholder = "비밀번호 확인">
		      	</td>
		  	  </tr>
		  	  <tr>

		      	<td>
		      		<input id = "login_c"  type="text"      name="name"  placeholder = "기업명"> 
		      	</td>
		  	  </tr>
		  	  <tr>

		      	<td>
		      		<input id = "login_c"  type="number"      name="admin_num"   placeholder = "사업자등록번호">
		      	</td>
		  	  </tr>
		  	  <tr>
		  	  	<td colspan="2" align="center">
		  	  	<div id = "login_button">
		  	  		<input type="reset"  id="buttons"    value="다시 작성"  >&nbsp;&nbsp;&nbsp;
		  	  		<input type="button" id="buttons"    value="회원가입"    onclick="go_save()">
		  	  	</div>
		  	  	</td>
		  	  </tr>
	      </table>
	    </form>
	  </div>
  <%@ include file="../footer.jsp"%>