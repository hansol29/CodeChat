<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href = "css/codeChat.css?ver=<%=System.currentTimeMillis()%>">
<title>강의 관리</title>
</head>
<body>
	<div id="wrap" align="center">
		<h2>관리자 페이지</h2>
		<h1>강의 삭제</h1>
		<form action="videoDelete.do" method="post">
			<table id="videoList">
				<tr>
					<td>
						<video width="320" height="240" controls>
							  <source src="upload/${video.videoUrl}" type="video/mp4">
						</video>
					</td>	
					<td>
						<table id ="video_list_d">
							<tr>
								<th style="width:80px">강의명</th>
								<td>${video.name }</td>
							</tr>
							<tr>
								<th>가 격</th>
								<td>${video.price }원</td>
							</tr>
							<tr>
								<th>설 명</th>
								<td><div style="height:220px; width:100%">${video.description }</div></td>
							</tr>
						</table>
					</td>
				</tr>	
			</table>
			<br>
			<div class = "button"> 
				<input type="hidden" name="code" value="${video.code }">
				<input type="submit" value="삭제" id = "submit" >
				<input type="button" value="목록"  id= "btn" onclick="location.href='videoList.do'">
			</div>
		</form>
	</div>
</body>
</html>

<%@ include file="../footer.jsp"%>