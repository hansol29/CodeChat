<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.codeChat.dto.UserVO" %>

<% 
   UserVO loginUser = (UserVO)session.getAttribute("loginUser"); 
	
   String code = request.getParameter("code");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel = "stylesheet" href = "/css/codeChat.css?ver=<%=System.currentTimeMillis()%>">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap" align="center">
		<h2><%if(loginUser.getId().equals("admin")) {%>관리자 페이지<%}else{} %></h2>
		<h1>강의 목록</h1>
		
		 
		<table id="videoList">
			<tr>
				<td colspan="5" style="border: white; text-align: right">
					<%if(loginUser.getId().equals("admin")) {%><button type = "button" id = "submit" onclick = "location.href='videoWrite.do'">강의 등록</button><%}%>
				</td>
			</tr>
		
			<c:forEach var="video" items="${videoList}">
			<form action="video/kakaoPay.jsp" method="post">
				<tr>
					<td>
						<video width="320" height="240" 
							<%if(loginUser.getId().equals("admin")) {%> 
								controls
							<%}else{} %>>
							  <source src="upload/${video.videoUrl}" type="video/mp4">
						</video>
					</td>
					<td>
					<table id = "video_list">
						<tr>
							<th>강의번호</th>
							<td><input type="text" value="${video.code}" name="code" readonly></td>
						</tr>
						<tr>
							<th>강의명</th>
							<td><input type="text" value="${video.name}" name="name" readonly></td>
						</tr>
						<tr>
							<th>가 격</th>
							<td><input type="text" value="${video.price}" name="totalPrice" readonly> 원</td>
						</tr>
						<tr>
							<th>내 용</th>
							<td><textarea name="description" readonly>${video.description}</textarea></td>
						</tr>
						
						<% 
							if(loginUser.getId().equals("admin")) {
						%>
							<tr>
								<td></td>
								<td>
									<button type = "button" id= "btn" onclick="location.href='videoUpdate.do?code=${video.code}'">강의 수정</button>
									<button type = "button" id= "btn"  onclick = "location.href='videoDelete.do?code=${video.code}'">강의 삭제</button>
								</td>
							</tr>
						<%}else{ %>
							
							<tr id = "cash">
								<td colspan="5" style="border: white; text-align: right"><input type="submit" value="결제"></td>
							</tr>
						<%} %>

					</table>
					</td>
					</tr>
					</form>
				</c:forEach>
			</table>
		
	</div>
</body>
</html>

<%@ include file="../footer.jsp"%>