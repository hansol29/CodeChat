<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file= "../header.jsp"%>
<%@ include file = "../popup.jsp" %>
<link rel="stylesheet" href="css/codeChat.css">
<!-- <script>
	let idx = -1;
	//let videoId = '';

//변경할 영상 소스
const srcValArr = [
   'cqlY1Hc70H0',
   'Bhzz9E3xuXY',
   'SZclqh4GpEI',
   '8Kp7QoVxjoA',
   'WSpz6HXFYLQ',
   '13-M9GNq_CI',
   'AmSKD4p-jhw',
   'lMp-bLDZ7TM',
   'VNyQshlrfBQ',
   'kkQiIXH5w2A',
   '0nPDwJPxOVQ',
   '26VBVedAOUo',
   'cqlY1Hc70H0',
   'ljohLVTdWLU',
   'jtjyNe1yfOM'
];

	// 화면 시작하자마자 영상 랜덤으로 하나 추천
	const ran = (Math.round(Math.random(srcValArr.length) * 10));
	videoId = srcValArr[ran];
	fnChangeVideoId(videoId);
	idx = ran;
	
	// 다음 영상
	function nextVideo() {
		idx++;
		
		if (idx == srcValArr.length) {idx = 0};
		
		const srcVal1 = srcValArr[idx];
		videoId = srcValArr[srcVal1];
		fnChangeVideoId(videoId);
		
	}
	
    $(".roll_left").click(function() {
       prevVideo();
    });

    $(".roll_right").click(function() {
         nextVideo();
    });
	
	// 이전 영상
	function prevVideo() {
		idx--;
		
		if (idx < 0) {idx = srcValArr.length - 1};
		
		const srcVal1 = srcValArr[idx];
		videoId = srcValArr[srcVal1];
		fnChangeVideoId(videoId);
	}
	
	// 그러나 영상은 5초마다 한 번씩 자동으로 돌아감
	const interval = setInterval(nextVideo, 5000);
	
	const toggle = true;
	
	function onPlayerStateChange(event) {
		if (event.data === 1) {
			clearInterval(interval);
			toggle = false;
		} else {
			interval = setInterval(nextVideo, 5000);
			toggle = true;
		}
	}
	
    var tag = document.createElement('script');

    tag.src = "https://www.youtube.com/iframe_api";
    var firstScriptTag = document.getElementsByTagName('script')[0];
    firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

    var player;
    function onYouTubeIframeAPIReady() {
    player = new YT.Player('player', {
        height: '315',
        width: '560',
        videoId: videoId,
        events: {
            'onStateChange': onPlayerStateChange
            }
        });
    }

  var done = false;
  function onPlayerStateChange(event) {
      if (event.data == YT.PlayerState.PLAYING && !done) {
          setTimeout(stopVideo, 6000);
          done = true;
      }
  }
  function stopVideo() {
      player.stopVideo();
  }
  console.log( player.loadVideoById(videoId));
  function fnChangeVideoId(videoId){
      player.loadVideoById(videoId);
 }
</script> -->
		<div class="video" style="margin-bottom: 100px;">
			<h1>추천 강좌</h1>
			<div class="video_rollwrap">
                 <button class="roll_left"></button>
                 <button class="roll_right"></button>
                 <div class="video_roll">
                   	<iframe id="iframe1" width="560" height="315" src="" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                 	<!-- <div id="player"></div> -->
                 </div>
             </div>
	 	</div>

		<div id="front">
			<div id = "Section">
				<div id="bestProductContainer">
					<div id="bestProduct">
						<table style="border-collapse: collapse">
							<caption>▷NEW5◁</caption>
							<tr>
								<th>게시판</th>
								<th>제 목</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						<c:forEach var="boardVO" items="${newBoardList}">
							<!-- <div id="item"> -->
								<tr id="item">
									<c:choose>
										<c:when test="${boardVO.kind == 1 }">
											<td><b>자유게시판</b></td>
											<td><a style = "text-decoration:none" href="CodeChatServlet?command=board_one&seq=${boardVO.seq }">${boardVO.title }</a></td>
										</c:when>
										<c:otherwise>
											<td><b>채용공고</b></td>
											<td><a style = "text-decoration:none"  href="CodeChatServlet?command=comBoard&seq=${boardVO.seq }">${boardVO.title }</a></td>
										</c:otherwise>
									</c:choose>
									<td><fmt:formatDate value="${boardVO.regdate }" type="date"/></td>
									<td>${boardVO.cnt }</td>
								</tr>
							<!-- </div> -->
						</c:forEach>
						</table>
					</div>
					
					<div id="bestProduct" >
						<table>
							<caption>▷BEST5◁</caption>
							<tr>
								<th>게시판</th>
								<th>제 목</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
							<c:forEach var="boardVO" items="${bestBoardList}">
								<div id="item">
									<tr>
										<c:choose>
											<c:when test="${boardVO.kind == 1 }">
												<td><b>자유게시판</b></td>
												<td><a style = "text-decoration:none"  href="CodeChatServlet?command=board_one&seq=${boardVO.seq }">${boardVO.title }</a></td>
											</c:when>
											<c:otherwise>
												<td><b>채용공고</b></td>
												<td><a style = "text-decoration:none"  href="CodeChatServlet?command=comBoard&seq=${boardVO.seq }">${boardVO.title }</a></td>
											</c:otherwise>
										</c:choose>
										<td><fmt:formatDate value="${boardVO.regdate }" type="date"/></td>
										<td>${boardVO.cnt }</td>
									</tr>
								</div>
							</c:forEach>
						</table>
					</div>
					
				</div>
				
				<!-- 자유게시판시작 -->
				<div id="bestProduct" class="userBoard">
					<table>
						<tr>
							<th>게시판</th>
							<th>제 목</th>
							<th>작성일</th>
							<th>조회수</th>
						</tr>
					<c:forEach var="boardVO" items="${userBoardList}" varStatus="vs">
						<c:if test="${vs.index == 0}">
							<tr class="tr"></tr>
						</c:if>
						<div id="item">
							<tr>
								<td>
									<b>자유게시판</b>
								</td>
								<td>
									<a style = "text-decoration:none"  href="CodeChatServlet?command=board_one&seq=${boardVO.seq }">${boardVO.title }</a>
								</td>
								<td>
									<fmt:formatDate value="${boardVO.regdate }" type="date"/>
								</td>
								<td>
									${boardVO.cnt }
								</td>
							</tr>
						</div>
					</c:forEach>
					</table>
				</div>
				<!-- 자유게시판 끝 -->
				
				<div class="boardWrapParent">
					<div class="boardWrap" id="userBoardWrap">
						<h1>자유게시판</h1>
					</div>
					<div class="boardWrap" id="companyBoardWrap">
						<h1>채용공고</h1>
					</div>
				</div>
				
				<!-- 채용공고시작 -->
				<div id="bestProduct" class="companyBoard">
					<table>
							<tr>
								<th>게시판</th>
								<th>제 목</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						<c:forEach var="boardVO" items="${companyBoardList}" varStatus="vs">
							<c:if test="${vs.index == 0}">
								<tr class="tr"></tr>
							</c:if>
							<div id="item">
								<tr>
									<td>
										<b>채용공고</b>
									</td>
									<td>
										<a style = "text-decoration:none" href="CodeChatServlet?command=comBoard&seq=${boardVO.seq }">${boardVO.title }</a>
									</td>
									<td>
										<fmt:formatDate value="${boardVO.regdate }" type="date"/>
									</td>
									<td>
										${boardVO.cnt }
									</td>
								</tr>
							</div>
						</c:forEach>
					</table>
				</div>
				<!-- 채용공고끝 -->
			
		</div>
				
		
		<div class="clear"></div>
		<div style="margin-bottom: 400px;"></div>

<%@ include file="../footer.jsp"%>
