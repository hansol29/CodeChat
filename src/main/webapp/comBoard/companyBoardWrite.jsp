<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채용 정보 작성</title>
<style>

</style>
<script type="text/javascript" src="comBoard/companyBoard.js?ver=1"></script>
</head>
<body>
	<div id="wrap">
		<h1>채용공고 작성</h1>
		<form name="form" method="post" action="CodeChatServlet?command=insertComBoard">
			<input type="hidden" name="id" value="${loginCompany.id}">
			<article id="companyBoard_w">
			
				<label class="title">공고명</label>
				<input type="text" name="title" size = "53" ><br><br>
				<label class="title">회사명</label>
				<input type="text" name="companyNm" value="${loginCompany.name}" readonly><br><br>
				<div>
				<label class="title">지역</label>
				<input type="radio" name="loc" value="경기" id="gyeonggi"><label for="gyeonggi">경기</label>
				<input type="radio" name="loc" value="서울" id="seoul"><label for="seoul">서울</label>
				<input type="radio" name="loc" value="인천" id="incheon"><label for="incheon">인천</label>
				<input type="radio" name="loc" value="제주" id="jeju"><label for="jeju">제주</label><br><br>

			
				<label class="title">연봉</label>
				<input type="radio" name="sal" value="0" id="0" > <label for="0">회사 내규에 따름</label>&nbsp;&nbsp;
				<input type="radio" name="sal" value="1000" id="1000" ><label for="1000">~2,000</label>&nbsp;&nbsp;
				<input type="radio" name="sal" value="2000" id="2000" ><label for="2000">2~3,000</label>&nbsp;&nbsp;
				<input type="radio" name="sal" value="3000" id="3000" ><label for="3000">3~4,000</label>&nbsp;&nbsp;
				<input type="radio" name="sal" value="4000" id="4000" ><label for="4000">4~5,000</label>&nbsp;&nbsp;
				<input type="radio" name="sal" value="5000" id="5000" ><label for="5000">5,000~</label><br><br>
				</div>
				<div>
				<label class="title">경력구분</label>
				<input type="radio" name="career" value="신입" id="junior"><label for="junior" >신입</label>&nbsp;&nbsp;
				<input type="radio" name="career" value="경력" id="senior" ><label for="senior">경력</label>&nbsp;&nbsp;
				<input type="radio" name="career" value="무관" id="irrelevant"><label for="irrelevant">무관</label><br><br>
				</div>
				
				
				
				
				
				
				
				
				
				<div class="verAlign">
					<label class="title" style = "width : 80px">내용</label>
					<textarea name="content" cols="60" rows="10"></textarea>
				</div><br><br>
				
				
				</article>
				<div align="center" id = "companyBoard_button">
					<button type="reset" id="btn">재작성</button>
					<input type="button" id="btn" value="저장" onclick="save()">
					<button type="button" id="btn" onclick="location='CodeChatServlet?command=comBoardList'">목록</button>				
				</div>
		</form>
	</div>
</body>
</html>
<%@ include file="../footer.jsp" %>  