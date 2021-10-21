const loc = document.getElementsByName("loc");
let locVal;
const sal = document.getElementsByName("sal");
let salVal;
const career = document.getElementsByName("career");
let careerVal;

function save() {

	if (locVal == undefined) {
		for (let i = 0; i < loc.length; i++) {
			if (loc[i].type === 'radio' && loc[i].checked) {
				locVal = loc[i].value;
			}
		}
	}

	if (salVal == undefined) {
		for (let i = 0; i < sal.length; i++) {
			if (sal[i].type === 'radio' && sal[i].checked) {
				salVal = sal[i].value;
			}
		}
	}
	
	if (careerVal == undefined) {
		for (let i = 0; i < career.length; i++) {
			if (career[i].type === 'radio' && career[i].checked) {
				careerVal = career[i].value;
			}
		}
	}

	if (document.form.title.value == "") {
		alert("등록하실 공고의 제목을 입력해 주세요");
		document.form.title.focus();
	} else if (document.form.content.value == "") {
		alert("채용 공고 내용은 최소 1자 이상 입력해주셔야 합니다");
		document.form.content.focus();
	} else if (locVal == undefined) {
		alert("지역을 선택해주세요");
		document.form.loc.focus();
	} else if (salVal == undefined) {
		alert("연봉을 선택해주세요");
		document.form.sal.focus();
	} else if (careerVal == undefined) {
		alert("요구되는 경력을 체크해주세요");
		document.form.career.focus();
	} else {
		document.form.action = "CodeChatServlet?command=insertComBoard";
		document.form.submit();
	}
}