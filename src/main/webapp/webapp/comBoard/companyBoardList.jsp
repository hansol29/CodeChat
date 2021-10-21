<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.jsp" %>  
<%@ page import="java.util.*" %>
<%@ page import="com.codeChat.dto.*" %>

<!DOCTYPE html>

<%
	// 이걸 받아온 이유는 조건 검색을 하고 나면 내가 원래 체크했던 내용들이 사라지게 됨.
	// 그렇기에 체크가 풀린 내역들을 다시 체크해주기 위해 데이터를 받아옴
	String[] locations = (String[])request.getAttribute("locations");
	String[] salarys = (String[])request.getAttribute("salarys");
	String[] career = (String[])request.getAttribute("career");
	
%>

<html>
<head>
<link rel ="stylesheet" href="../css/codeChat.css">
<meta charset="UTF-8">
<title>채용 정보</title>

<style>

	
</style>
<script>
	/* "체크해제" 버튼 누르면 체크되었던 거 전체 해제됨*/
	function unchk(selectAll)  {
	  const checkboxes 
	     = document.querySelectorAll('.conditionChk');
	  
	  checkboxes.forEach((checkbox) => {
	    checkbox.checked = selectAll.checked
	  })
	}
	
	<%-- function intrstYnSave(obj){
        // 비로그인시 로그인화면으로 이동
         const loginUser = <%=(UserVO)session.getAttribute("loginUser")%>;
         const loginCompany = <%=(CompanyVO)session.getAttribute("loginCompany")%>;

         if (loginUser == null && loginCompany == null) {
        	alert(1);
            /* $(obj).prop("checked", false);
            if(confirm("로그인이 필요한 서비스입니다.\n로그인 하시겠습니까?")){
              	location.href="CodeChatServlet?command=login_form";
            } */
        } else if (loginCompany != null) {
        	alert(2);
            /* var cmpId = $(obj).parents(".item").data("id");
            var intrstYn = $(obj).is(":checked") ? "Y" : "N";

            interestCompanySave(cmpId, intrstYn, function(data){
            }); */
        }
    } --%>
</script>

<body>
	<div id="wrap">
		<img style = "width: 100%; height: 300px; " src = "images/meeting.png"/>
		
		<section>
		<h1>조건별 검색</h1>
		
		
		<div align="right">
			<button type="button" class="unchkBtn" onclick="unchk(this)">체크해제</button>
		</div>
		<form method="post" name="form" action="CodeChatServlet?command=select&nowPage=${page.startPage}&cntPerPage=${page.cntPerPage}">
			<article id="category">
				<fieldset>
					<b>지역</b>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" class="conditionChk" name="loc" value="경기" id="gyeonggi" <%if(locations != null && Arrays.asList(locations).contains("경기")) {%>checked<%}%>><label for="gyeonggi">&nbsp;경기</label>
					<input type="checkbox" class="conditionChk" name="loc" value="서울" id="seoul" <%if(locations != null && Arrays.asList(locations).contains("서울")) {%>checked<%}%>><label for="seoul">&nbsp;서울</label>
					<input type="checkbox" class="conditionChk" name="loc" value="인천" id="incheon" <%if(locations != null && Arrays.asList(locations).contains("인천")) {%>checked<%}%>><label for="incheon">&nbsp;인천</label>
					<input type="checkbox" class="conditionChk" name="loc" value="제주" id="jeju" <%if(locations != null && Arrays.asList(locations).contains("제주")) {%>checked<%}%>><label for="jeju">&nbsp;제주</label>
				</fieldset>				
			</article>
			<article id = "category">
					<fieldset>
					<b>연봉</b>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" class="conditionChk" name="sal" value="0" id="0"  <%if(salarys != null && Arrays.asList(salarys).contains("0")) {%>checked<%}%>> <label for="0">회사 내규에 따름</label>&nbsp;&nbsp;
					<input type="checkbox" class="conditionChk" name="sal" value="1000" id="1000" <%if(salarys != null && Arrays.asList(salarys).contains("1000")) {%>checked<%}%>><label for="1000">&nbsp;~2,000</label>&nbsp;&nbsp;
					<input type="checkbox" class="conditionChk" name="sal" value="2000" id="2000" <%if(salarys != null && Arrays.asList(salarys).contains("2000")) {%>checked<%}%>><label for="2000">&nbsp;2~3,000</label>&nbsp;&nbsp;
					<input type="checkbox" class="conditionChk" name="sal" value="3000" id="3000" <%if(salarys != null && Arrays.asList(salarys).contains("3000")) {%>checked<%}%>><label for="3000">&nbsp;3~4,000</label>&nbsp;&nbsp;
					<input type="checkbox" class="conditionChk" name="sal" value="4000" id="4000" <%if(salarys != null && Arrays.asList(salarys).contains("4000")) {%>checked<%}%>><label for="4000">&nbsp;4~5,000</label>&nbsp;&nbsp;
					<input type="checkbox" class="conditionChk" name="sal" value="5000" id="5000" <%if(salarys != null && Arrays.asList(salarys).contains("5000")) {%>checked<%}%>><label for="5000">&nbsp;5,000이상</label>
				</fieldset>
			</article>
			<article id = "category">	
				<fieldset>
					<b>경력</b>&nbsp;&nbsp;&nbsp;
					<input type="checkbox" class="conditionChk" name="career" value="신입" id="junior" <%if(career != null && Arrays.asList(career).contains("신입")) {%>checked<%}%>><label for="junior" >&nbsp;신입</label>
					<input type="checkbox" class="conditionChk" name="career" value="경력" id="senior" <%if(career != null && Arrays.asList(career).contains("경력")) {%>checked<%}%>><label for="senior">&nbsp;경력</label>
					<input type="checkbox" class="conditionChk" name="career" value="무관" id="irrelevant" <%if(career != null && Arrays.asList(career).contains("무관")) {%>checked<%}%>><label for="irrelevant">&nbsp;무관</label>
				</fieldset>
			</article>
		
			<input type="submit" class="select" value="조회" style="cursor: pointer;">
			<br><br>
		</form>
		<h1>채용공고<!-- 여기 조건문은 로그인한 사람이 기업일 때만 채용공고를 작성할 수 있는 버튼을 나타내게 해주려고 걸어줌 -->
		<c:if test="${!empty loginCompany.id}">
			<a class="insert" name="insertCompanyBoard" href="CodeChatServlet?command=insertComBoardForm">작성</a>
		</c:if>
		</h1>
			<div class="comList">
				<c:forEach var="company" items="${companyList}">
					<div id = "box" onmouseover = "this.style.background='rgb(128,128,128,0.2)'" onmouseout="this.style='none'">
					 <div onclick="location.href='CodeChatServlet?command=comBoard&seq=${company.seq}'" style="cursor: pointer;">
					 	<a class="comNm">[${company.name}]</a><br><br>
					 	<a class="comNm_T">${company.title}</a>
					 	<div class="title">
						 	<div class="ellipsis">
						 	 						 		
						 	</div>
							<%-- <input type="checkbox" name="like${company.seq}" id="like${company.seq}" onclick="intrstYnSave(this)"><label for="like${company.seq}"><img src="images/emptyStar.png" width="25" height="25"></label> --%>
							
						
							<div class="comInfo">
							<span>${company.loc} | </span>
							<!-- 연봉이 0이면 "회사 내규에 따름"이라는 문구가 출력되고, 아니라면 연봉이 커스텀 되어 출력됨 -->
							<c:choose>
								<c:when test="${company.sal ne 0}">
									<span><fmt:setLocale value="ko_KR"/><fmt:formatNumber type="currency" value="${company.sal}" />만원</span>
								</c:when>
								<c:otherwise>
									<span>회사 내규에 따름</span>
								</c:otherwise>
							</c:choose>
								<span>| ${company.career}</span><br>
							</div>
						</div>
					</div> 
					<span class="right">조회수 : ${company.cnt}</span>
					</div>
				</c:forEach>
			</div>
		</section>
		
		<div id = "companyPage">	
		<table>
			<%-- <td><a class="page" href="CodeChatServlet?command=comBoardList&nowPage=${page.startPage }&cntPerPage=${page.cntPerPage }">처음</a></td> --%>
		<c:if test="${page.startPage != 1 }">
		
		
		
			<c:choose>
				<c:when test="${locations == null && salarys == null && career == null}">
					<td><a class="page" href="CodeChatServlet?command=comBoardList&nowPage=${page.startPage - 1 }&cntPerPage=${page.cntPerPage}">이전</a></td>
				</c:when>
				<c:otherwise>
					<td><a class="page" href="CodeChatServlet?command=select&nowPage=${page.startPage - 1 }&cntPerPage=${page.cntPerPage}">이전</a></td>
				</c:otherwise>
			</c:choose>
		</c:if>
		<c:forEach begin="${page.startPage }" end="${page.endPage }" var="p">
			<c:choose>
				<c:when test="${p == page.nowPage }">
					<td><b>${p}</b></td>
				</c:when>
				<c:when test="${p != page.nowPage }">
					<c:choose>
						<c:when test="${locations == null && salarys == null && career == null}">
							<td><a class="page" href="CodeChatServlet?command=comBoardList&nowPage=${p}&cntPerPage=${page.cntPerPage}">
								${p }
							</a></td>
						</c:when>
						<c:otherwise>
							<td><a class="page" href="CodeChatServlet?command=select&nowPage=${p}&cntPerPage=${page.cntPerPage}
							<% if (locations != null) {
								for (int i = 0; i < locations.length; i++) {%>
								&loc=<%=locations[i] %>
							<%}}%>
							<% if (salarys != null) {
							for (int i = 0; i < salarys.length; i++) {%>
								&sal=<%=salarys[i] %>
							<%}}%>
							<% if (career != null) {
							for (int i = 0; i < career.length; i++) {%>
								&loc=<%=career[i] %>
							<%}}%>
							">${p }</a></td>
						</c:otherwise>
					</c:choose>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${page.endPage != page.lastPage}">
			<c:choose>
				<c:when test="${locations == null && salarys == null && career == null}">
					<td><a class="page" href="CodeChatServlet?command=comBoardList&nowPage=${page.endPage+1 }&cntPerPage=${page.cntPerPage}">다음</a></td>
				</c:when>
				<c:otherwise>
					<td><a class="page" href="CodeChatServlet?command=select&nowPage=${page.endPage+1 }&cntPerPage=${page.cntPerPage}">다음</a></td>
				</c:otherwise>
			</c:choose>
		</c:if>
		<%-- <td><a class="page" href="CodeChatServlet?command=comBoardList&nowPage=${page.endPage }&cntPerPage=${page.cntPerPage }">마지막</a></td> --%>
	</table>	
	</div>
	</div>
</body>
</html>

<%@ include file="../footer.jsp" %>  