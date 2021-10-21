<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/video.js"></script>
<link rel = "stylesheet" href = "/css/codeChat.css?ver=<%=System.currentTimeMillis()%>">
</head>
<body>
<div id="wrap" align="center">
		<h2>관리자 페이지</h2>
		<h1>강의 정보 수정</h1>
		<form method="post" enctype="multipart/form-data" name="frm">
			<input type="hidden" name="code" value="${video.code}"> 
			<input type="hidden" name="nonmakeImg" value="${video.videoUrl}">
			<table id="videoList">
				<tr>
					<td>
						<c:choose>
							<c:when test="${empty video.videoUrl}">
								<img src="upload/noimage.gif">
							</c:when>
							<c:otherwise>
								<img src="upload/${video.videoUrl}">
							</c:otherwise>
						</c:choose>
					</td>
					<td>
						<table id = "videoList_u">
							<tr>
								<th style="width: 80px">강의명</th>
								<td><input type="text" name="name" value="${video.name}"
									size="80"></td>
							</tr>
							<tr>
								<th>가 격</th>
								<td><input type="text" name="price"
									value="${video.price}"> 원</td>
							</tr>
							<tr>
								<th>설 명</th>
								<td><textarea name="description">${video.description}</textarea>
								</td>
							</tr>
							<tr>
								<th>업로드</th>
								<td><input type="file" name="videoUrl"><br>
							</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br>
			<div class = "button"> 
				<input type="submit" id="submit"  value="수정" onclick="return videoCheck()"> 
				<input type="button" id="btn"  value="목록" onclick="location.href='videoList.do'">
				<input type="reset" id="btn"  value="재작성"> 
			</div>
		</form>
	</div>
</body>
</html>

<%@ include file="../footer.jsp"%>