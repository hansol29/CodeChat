$(function() {
	const iframe1 = document.getElementById("iframe1");
	let idx = -1;
	
   // 메인 화면에 자유게시판, 채용공고 관련 스크립트
   const userBoardWrap = document.getElementById("userBoardWrap");
   const companyBoardWrap = document.getElementById("companyBoardWrap");

   userBoardWrap.addEventListener('mouseover', function() {
      userBoardWrap.setAttribute("class", "half");
   });

   companyBoardWrap.addEventListener('mouseover', function() {
      companyBoardWrap.setAttribute("class", "half");
   });

   userBoardWrap.addEventListener('click', function() {
      location.href = "CodeChatServlet?command=board_list";
   });

   companyBoardWrap.addEventListener('click', function() {
      location.href = "CodeChatServlet?command=comBoardList";
   });

/*
   // html에 있는 iframe1을 가져옴
   const iframe1 = document.getElementById("iframe1");

   setInterval(function switchSrc() {
      // const ran1 = Math.round(Math.random() * srcValArr.length);
      const srcVal1 = srcValArr[ran1];

      iframe1.setAttribute("src", srcVal1);
      return switchSrc;
   }(), 5000);
*/
	
    $(".roll_left").click(function() {
       prevVideo();
    });

    $(".roll_right").click(function() {
         nextVideo();
    });


	// 변경할 영상 소스
   const srcValArr = [
      'https://www.youtube.com/embed/cqlY1Hc70H0',
      'https://www.youtube.com/embed/Bhzz9E3xuXY',
      'https://www.youtube.com/embed/SZclqh4GpEI',
      'https://www.youtube.com/embed/8Kp7QoVxjoA',
      'https://www.youtube.com/embed/WSpz6HXFYLQ',
      'https://www.youtube.com/embed/13-M9GNq_CI',
      'https://www.youtube.com/embed/AmSKD4p-jhw',
      'https://www.youtube.com/embed/lMp-bLDZ7TM',
      'https://www.youtube.com/embed/VNyQshlrfBQ',
      'https://www.youtube.com/embed/kkQiIXH5w2A',
      'https://www.youtube.com/embed/0nPDwJPxOVQ',
      'https://www.youtube.com/embed/26VBVedAOUo',
      'https://www.youtube.com/embed/cqlY1Hc70H0',
      'https://www.youtube.com/embed/ljohLVTdWLU',
      'https://www.youtube.com/embed/jtjyNe1yfOM'
   ];

	// 화면 시작하자마자 영상 랜덤으로 하나 추천
	const ran = (Math.round(Math.random(srcValArr.length) * 10));
	iframe1.setAttribute("src", srcValArr[ran]);
	idx = ran;
	
	// 다음 영상
	function nextVideo() {
		idx++;
		
		if (idx == srcValArr.length) {idx = 0};
		
		const srcVal1 = srcValArr[idx];
		iframe1.setAttribute("src", srcVal1);
		
	}
	
	// 이전 영상
	function prevVideo() {
		idx--;
		
		if (idx < 0) {idx = srcValArr.length - 1};
		
		const srcVal1 = srcValArr[idx];
		iframe1.setAttribute("src", srcVal1);
		
	}
	
	/*// 그러나 영상은 5초마다 한 번씩 자동으로 돌아감
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
	}*/
	

});

 
