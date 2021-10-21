<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 관리</title>
<script type="text/javascript" src="script/video.js"></script>
<link rel = "stylesheet" href = "/css/codeChat.css?ver=<%=System.currentTimeMillis()%>">
</head>
<body>
	<div id="wrap" align="center">
		<h2>관리자 페이지</h2>
		<h1>강의 등록</h1>
		<form method="post" enctype="multipart/form-data" name="frm">
			<table id="videoList_w">
				<tr>
					<th>강의명</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>가  격</th>
					<td><input type="text" name="price"> 원</td>
				</tr>
				<tr>
					<th>설  명</th>
					<td><textarea name="description" cols="60" rows = "10"></textarea></td>
				</tr> 
				<tr>
					<th>업로드</th>
					<td>
						<input type="file" name="videoUrl"><br>
					</td>
				</tr>
				
			</table>
			<br>
				<div class = "button">
					<input type="submit" id="submit"  value="등록" onclick="return videoCheck()">
					<input type="button" id="btn" value="목록" onclick="location.href='videoList.do'">

					<input type="reset" id="btn" value="재작성">
					
				</div>
		</form>
	</div>
</body>
</html>

<%@ include file="../footer.jsp"%>