<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href = "css/codeChat.css">
<meta charset="UTF-8">
<title>채용 정보 상세</title>


</head>
<body>

	<div id="wrap">
	<img style = "width: 100%; height: 300px; " src = "images/meeting.png"/>
		<h1>채용공고 상세</h1>
			<article id = "companyBoard_d">
				<div style = "margin-left : 50px;">
					<label>공고명</label>
					<p> ${comBoard.title}</p>
				<br><br>
				<label>회사명</label>
				<p> ${comBoard.name}</p><br><br>
				</div>
				
				<div id = "condition_container">
					<div id = "condition">
					<label>근무조건</label><br>
									
					<label id = "sub">지역</label>
					<p>${comBoard.loc}</p><br><br>
					<label id = "sub">연봉</label>
					<c:choose>
						<c:when test="${comBoard.sal ne 0}">
							<p><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${comBoard.sal}" />만원</p>
						</c:when>
						<c:otherwise>
							<p>회사 내규에 따름</p>
						</c:otherwise>
					</c:choose><br><br>
					</div>
					
					<div id = "carrer">
					<label>지원요건</label><br>
					<label id = "sub">경력</label>
					<p> ${comBoard.career}</p>
					</div>
				</div>
				<div class="verAlign">
					<label>내용</label>
					<div id="content">
					<p> ${comBoard.content}</p>
					</div>
				</div><br><br>
			</article>
			
			<div id="companyboard_d_b" align="center">
				<button type="button" id="backBtn" onclick="history.back();">이전</button>
				<button type="button" id="toListBtn" onclick="location='CodeChatServlet?command=comBoardList'">목록</button>
				<c:if test="${loginCompany.id eq comBoard.id}">
					<button type="button" id="eventBtn" onclick="location='CodeChatServlet?command=updateComBoardForm&seq=${comBoard.seq}'">수정</button>
					<button type="button" id="eventBtn" value="삭제" onclick="location='CodeChatServlet?command=deleteComBoard&seq=${comBoard.seq}'">삭제</button>
				</c:if>
			</div>
	</div>
</body>
</html>
<%@ include file="../footer.jsp" %>  