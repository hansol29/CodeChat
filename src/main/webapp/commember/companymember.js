function go_save() {
  if (document.formm.id.value == "") {
    alert("아이디를 입력하여 주세요.");
    document.formm.id.focus();
  } else if (document.formm.id.value != document.formm.reid.value) {
    alert("중복확인을 클릭하여 주세요.");
    document.formm.id.focus();
  } else if (document.formm.password.value == "") {
    alert("비밀번호를 입력해 주세요.");
    document.formm.password.focus();
  } else if ((document.formm.password.value != document.formm.passwordCheck.value)) {
    alert("비밀번호가 일치하지 않습니다.");
    document.formm.password.focus();
  } else if (document.formm.name.value == "") {
    alert("기업명을 입력해 주세요.");
    document.formm.name.focus();
  } else if (document.formm.admin_num.value == "") {
    alert("사업자등록번호를 입력해 주세요.");
    document.formm.admin_num.focus();
  } else {
    document.formm.action = "CodeChatServlet?command=admin_join";
    document.formm.submit();
  }
}


function go_next() {
	if (document.formm.okon1[0].checked == true) {
	  document.formm.action = "CodeChatServlet?command=admin_join_form";
	  document.formm.submit();
	} else if (document.formm.okon1[1].checked == true) {
	  alert('약관에 동의하셔야만 합니다.');
	}
}

function login() {
	if(document.formm.id.value == ""){
		alert('아이디를 입력하여 주십시오.');
		document.formm.id.focus();
		return;
	}else if(document.formm.password.value == ""){
		alert('비밀번호를 입력하여 주십시오.');
		document.formm.password.focus();
		return;
	}else{
		document.formm.action = "CodeChatServlet?command=admin_login";
		document.formm.submit();
	}
}

function idcheck() {
  if (document.formm.id.value == "") {
    alert('아이디를 입력하여 주십시오.');
    document.formm.id.focus();
    return;
  }
  var url = "CodeChatServlet?command=id_check_form&id=" 
+ document.formm.id.value;
  window.open( url, "_blank_1",
"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=400, height=250");
}
