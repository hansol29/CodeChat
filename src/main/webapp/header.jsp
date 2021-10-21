<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href = "css/codeChat.css?ver=<%=System.currentTimeMillis()%>">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="js/main.js" ></script> 

<title>Code Chat</title>

</head>
<body>
	<div id="wrap" >
		<header id="mainimg">
			<div id="logo">
				<a href="CodeChatServlet?command=main">
					<img src="images/logo_.png" width="180" height="100" alt="CodeChat">
				</a>
			</div>
			<nav id="menu">
				<ul >
				<c:choose>
					<c:when test="${empty sessionScope.loginUser.id && empty sessionScope.loginCompany.id}">
						<!-- 로그인 전 start -->
						<li><a>로그인</a>
						<div id="test">
							<ul id = "test">
								<li>
									<a href="CodeChatServlet?command=login_form">개인</a>
								</li>
								<li class="white">  </li>
								<li>
									<a href="CodeChatServlet?command=admin_login_form">기업</a>							
								</li>
							</ul>
						</div>
						</li>
						
						<li class="white"> | </li>
						<li><a>회원가입</a>
						<div id="test">
							<ul id="test">
								<li>						
									<a href="CodeChatServlet?command=usercontract">개인</a>
								</li>
								<li class="white">  </li>
								<li>						
									<a href="CodeChatServlet?command=companycontract">기업</a>
								</li>
							</ul>
						</div>
						</li>
						<li class="white"> | </li>
						<!-- 로그인 전 end -->
					</c:when>
					<c:otherwise>
						<!-- 로그인 후 start -->
						<li style="color:darkblue; font-weight:bold; font-size:23px">
							<c:if test="${!empty sessionScope.loginUser.id}">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								${sessionScope.loginUser.name}(${sessionScope.loginUser.id })님
							</c:if>
							<c:if test="${!empty sessionScope.loginCompany.id}">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								${sessionScope.loginCompany.name}(${sessionScope.loginCompany.id })님
							</c:if>
						</li>
						
						<!-- 로그인 후 end -->
					</c:otherwise>
					
				</c:choose>
					
					<li>
					<c:choose>
						<c:when test="${empty sessionScope.loginUser.id && empty sessionScope.loginCompany.id}">
							<!-- 로그인 전 start -->
							<!-- 로그인 전 end -->
						</c:when>
						
						<c:otherwise>
							<!-- 로그인 후 start -->
							<li class="white"> | </li>
							<li class="mypage">
							<div id = "test">
							<a><img src = "images/mypage.png" style ="width : 30px; height : 30px"></a>
								<!-- 김은수 menubar 테스트 -->
								
								<ul id ="test" style = "width : 50px; ">
									<c:choose>
										<c:when test="${empty sessionScope.loginUser.id && empty sessionScope.loginCompany.id}">
										</c:when>
										<c:otherwise>
											<c:if test="${!empty sessionScope.loginUser.id}">
												<li><a href="CodeChatServlet?command=mypage">회원정보수정</a>
												</li>
											</c:if>
											<c:if test="${!empty sessionScope.loginCompany.id}">
												<li><a href="CodeChatServlet?command=admin_mypage">회원정보수정</a></li>
											</c:if>
										</c:otherwise>
									</c:choose>
									<li class="white"></li>
									<li>
										<a href="CodeChatServlet?command=myWrite">내가 쓴 글</a>
									</li>
									<li class="white"></li>
									<li>
										<a href="CodeChatServlet?command=myVideo">내 강의실</a>
									</li>
								</ul>
								</div>
							</li>
							<li class="white"> | </li>
							<li>
							<a href="CodeChatServlet?command=logout"><img src = "images/logout.png" style = "width : 30px; height : 30px"></a>
							</li>
							<li class="white"> | </li>
							<li>
								<a href="CodeChatServlet?command=qna_list">Q&A</a>
							</li>
							<li class="white"> | </li>
							<!-- 로그인 후 end -->
						</c:otherwise>
					</c:choose>
							
					</li>
					<!-- <li> / </li>
					<li>
						<a href="CodeChatServlet?command=qna_list">Q&amp;A(1:1)</a>
					</li> -->
					
					<li><a>MENU</a>
					<div id = "test">
						<ul id = "test">
							<li>
								<a href="CodeChatServlet?command=board_list">자유게시판</a>
							</li>

							<li>
								
								<a href="CodeChatServlet?command=comBoardList">채용공고</a>
							</li>

							<li>
								
								<a href="videoList.do">동영상 강의</a>
							</li>
						</ul>
					</div>		
					</li>
					
				</ul>
			</nav>
			<!-- <nav id="top_menu">
				<ul>
					<li>
						<a href="CodeChatServlet?command=board_list">자유게시판</a>
					</li>
					<li>
						
						<a href="CodeChatServlet?command=comBoardList">채용공고</a>
					</li>
				</ul>
			</nav> -->
			<div class="clear"></div>
		</header>
		<hr>
</div>

