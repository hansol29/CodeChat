<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.codeChat.dto.UserVO" %>
<%@ page import="com.codeChat.dto.UserAndVideoVO" %>
<%@ page import="java.util.*" %>
<%@ page import="com.codeChat.dao.UserDAO" %>

<% 
	UserVO loginUser = (UserVO)session.getAttribute("loginUser");
	System.out.println("session에서 가져온 현재 로그인 유저의 videoCode : " + loginUser.getVideoCode());
	
	UserDAO userDAO = UserDAO.getInstance();
	UserVO userVO = userDAO.getUser(loginUser.getId());
	System.out.println("getUser()를 통해 가져온 현재 로그인 유저의 videoCode : " + userVO.getVideoCode());
	

	//List<UserAndVideoVO> myVideos = (List<UserAndVideoVO>)request.getAttribute("myVideos");
	List<UserAndVideoVO> myVideos = (List<UserAndVideoVO>)session.getAttribute("myVideos"); 
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
		<%if(loginUser.getVideoCode() == 0) {%>
			<h1>내 강의 목록이 비었습니다.</h1>
		<%}else{ %>
		<h1>내 강의 목록</h1>
		<c:forEach var="video" items="${myVideos }">
		<table id = "videoList">
				<tr>
					<td>
						<video width="500" height="300" controls>
							  <source src="upload/${video.videoUrl}" type="video/mp4">
						</video>
					</td>
					<td>
					<table id = "video_list_d">
						<tr>
							<th>강의번호</th>
							<td>${video.videoCode}</td>
						</tr>
						<tr>
							<th>강의명</th>
							<td>${video.name}</td>
						</tr>
						<tr>
							<th>가 격</th>
							<td>${video.price} 원</td>
						</tr>
						<tr>
							<th>내 용</th>
							<td>${video.description}</td>
						</tr>

					</table>
					</td>
					</tr>
			</table>
			</c:forEach>
		<%} %>
	</div>
</body>
</html>

<%@ include file="../footer.jsp"%>