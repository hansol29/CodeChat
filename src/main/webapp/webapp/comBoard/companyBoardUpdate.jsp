<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ include file="../header.jsp" %> 
<%@ page import="com.codeChat.dto.*" %> 
<!DOCTYPE html>

<%
	CompanyBoardVO comBoard = (CompanyBoardVO)request.getAttribute("comBoard");
%>

<html>
<head>
<meta charset="UTF-8">
<title>채용 정보 수정</title>



</head>
<body>
	<div id="wrap">
		<h1>채용공고 수정</h1>
		<form name="form" method="post" action="CodeChatServlet?command=updateComBoard&id=${comBoard.id}&seq=${comBoard.seq}">
			<article id="companyBoard_w">
				<label class="title">공고명</label>
				<input type="text" name="title" value="${comBoard.title}" size="40"><br><br>
				<label class="title">회사명</label>
				<input type="text" name="companyNm" value="${loginCompany.name}" readonly><br><br>
				
				<label class="title">지역</label>
				<input type="radio" name="loc" value="경기" id="gyeonggi" <%if(comBoard.getLoc().equals("경기")){%>checked<%}%>><label for="gyeonggi">경기</label>
				<input type="radio" name="loc" value="서울" id="seoul" <%if(comBoard.getLoc().equals("서울")){%>checked<%}%>><label for="seoul">서울</label>
				<input type="radio" name="loc" value="인천" id="incheon"<%if(comBoard.getLoc().equals("인천")){%>checked<%}%>><label for="incheon">인천</label>
				<input type="radio" name="loc" value="제주" id="jeju"<%if(comBoard.getLoc().equals("제주")){%>checked<%}%>><label for="jeju">제주</label><br><br>
			
				<label class="title">연봉</label>
				<input type="radio" name="sal" value="0" id="0" <%if(comBoard.getSal() == 0){%>checked<%}%>> <label for="0">회사내규에따름</label>&nbsp;&nbsp;
				<input type="radio" name="sal" value="1000" id="1000" <%if(comBoard.getSal() == 1000){%>checked<%}%>><label for="1000">~2,000</label>&nbsp;&nbsp;
				<input type="radio" name="sal" value="2000" id="2000" <%if(comBoard.getSal() == 2000){%>checked<%}%>><label for="2000">2~3,000</label>&nbsp;&nbsp;
				<input type="radio" name="sal" value="3000" id="3000" <%if(comBoard.getSal() == 3000){%>checked<%}%>><label for="3000">3~4,000</label>&nbsp;&nbsp;
				<input type="radio" name="sal" value="4000" id="4000" <%if(comBoard.getSal() == 4000){%>checked<%}%>><label for="4000">4~5,000</label>&nbsp;&nbsp;
				<input type="radio" name="sal" value="5000" id="5000" <%if(comBoard.getSal() == 5000){%>checked<%}%>><label for="5000">5,000~</label><br><br>
			
				<label class="title">경력구분</label>
				<input type="radio" name="career" value="신입" id="junior" <%if(comBoard.getCareer().equals("신입")){%>checked<%}%>><label for="junior" >신입</label>&nbsp;&nbsp;
				<input type="radio" name="career" value="경력" id="senior" <%if(comBoard.getCareer().equals("경력")){%>checked<%}%>><label for="senior">경력</label>&nbsp;&nbsp;
				<input type="radio" name="career" value="무관" id="irrelevant" <%if(comBoard.getCareer().equals("무관")){%>checked<%}%>><label for="irrelevant">무관</label><br><br>
				
				
				<div class="verAlign">
					<label class="title" style = "width : 80px">내용</label>
					
						<textarea name="content" cols="60" rows="10">${comBoard.content}</textarea>
					
				</div><br><br>
				
				
			</article>
			<div align="center"  id = "companyBoard_button">
				<button type="button" id="btn" onclick="history.back();">이전</button>
				<button type="button" id="btn" onclick="location='CodeChatServlet?command=comBoardList'">목록</button>
				<!-- 보류. 이게 들어가려면 회사 공고를 적을때나 회원가입 시 홈페이지를 하나 더 받아야함 -->
				<!-- <input type="button" name="homepage" value="당사 홈페이지로 이동"> -->
				<input type="submit" id="btn"  name="submit" value="저장">
			</div>
		</form>
	</div>
</body>
</html>
<%@ include file="../footer.jsp" %>  