<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/WEB-INF/views/common/header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/users/signup" onsubmit="return checkForm()">
		<table border="1" >
			<tr>
				<th>이름</th>
				<td><input type="text" name="uiName" id="uiName"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="uiId" id="uiId"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="uiPwd" id="uiPwd"></td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td><input type="password" name="uiPwdCheck" id="uiPwdCheck"></td>
			</tr>
			<tr>
				<th colspan="2"><button>회원가입</button></th>
			</tr>
		</table>
	</form>
	<script>
		function checkForm(){
			var uiNameObj = document.getElementById('uiName');
			if(uiName.value.trim().length <2){
				alert("이름은 2글자 이상입니다");
				uiNameObj.value='';
				uiNameobj.focus();
				return false;
			}
			var uiIdObj = document.getElementById('uiId');
			if(uiId.value.trim().length<5){
				alert("아이디는 5글자 이상입니다");
				uiIdObj.value='';
				uiIdObj.focus();
				return false;
			}
			var uiPwdObj = document.getElementById('uiPwd');
			if(uiPwd.value.trim().length<4){
				alert("비밀번호는 4글자 이상입니다");
				uiPwdObj.value = '';
				uiPwdObj.focus();
				return false;
			}
			var uiPwdCheckObj = document.getElementById('uiPwdCheck');
			if(uiPwd.value!=uiPwdCheckObj.value){
				alert("비밀번호와 일치하지 않습니다");
				uiPwdCheckObj.value='';
				uiPwdCheckObj.focus();
				return false;
			}
			return true;
		}
	</script>
</body>
</html>