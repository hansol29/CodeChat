<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%> 
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script>
function delete_myWrite() {
	  var count = 0;

	  if (document.formm.seq.length == undefined) {
	    if (document.formm.seq.checked == true) {
	      count++;
	    }
	  }

	  for ( var i = 0; i < document.formm.seq.length; i++) {
	    if (document.formm.seq[i].checked == true) {
	      count++;
	    }
	  }
	  if (count == 0) {
	    alert("삭제할 항목을 선택해 주세요.");

	  } else {
		  
	    document.formm.action = "CodeChatServlet?command=delete_myWrite";
	    document.formm.submit();
	  }
	}
	
function selectAll(selectAll)  {
	  const checkboxes 
	     = document.querySelectorAll('input[type="checkbox"]');
	  
	  checkboxes.forEach((checkbox) => {
	    checkbox.checked = selectAll.checked
	  })
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id = "wrap">
<h1>내가 쓴 글</h1>
<form name = "formm" method = "post">
	<nav id = "buttons">
		<input type = "button" value = "삭제" onclick = "delete_myWrite()">
	</nav>
				
			<table id = "List_1">
				
				<tr>
					
					<th style= "width : 40px"><input type= "checkbox" onclick="selectAll(this)"></th>
					<th style= "width : 80px">번호</th>
					<th>제목</th>
					<th>등록일</th>
					
				</tr>
				<c:if test="${userList == '[]'}">
					<tr><td colspan="4">작성하신 내역이 없습니다.</td></tr>
				</c:if>
				<c:if test="${companyList == '[]'}">
					<tr><td colspan="4">작성하신 내역이 없습니다.</td></tr>
				</c:if>
				<c:choose>
					<c:when test="${userList != null}">
						<c:forEach var = "list" items = "${userList }" >
							<tr onmouseover = "this.style.background='rgb(9, 26, 92, 0.05)'" onmouseout = "this.style = 'none'" >
								<td><input type= "checkbox" name = "seq" value = "${list.seq }"></td>
								<td>${list.seq }</td>
								<td style = "text-align:left">
									<a style = "text-decoration : none" href = "CodeChatServlet?command=board_one&seq=${list.seq}">${list.title }</a>
								</td>
								<td><fmt:formatDate type="date" value="${list.regdate}" /></td>						
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach var = "list" items = "${companyList }" >
							<tr onmouseover = "this.style.background='rgb(9, 26, 92, 0.05)'" onmouseout = "this.style = 'none'" >
								<td><input type= "checkbox" name = "seq" value = "${list.seq }"></td>
								<td>${list.seq }</td>
								<td style = "text-align:left">
									<a style = "text-decoration : none" href = "CodeChatServlet?command=comBoard&seq=${list.seq}">${list.title }</a>
								</td>
								<td><fmt:formatDate type="date" value="${list.regdate}" /></td>						
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				
		</table>
	</form>
</div>
</body>
</html>
<%@ include file ="../footer.jsp"%>