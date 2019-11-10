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
11-09 세번째 게시판 <br>
user와 board 완료하기 ^^<br>
(프로젝트 > 빌드오토메틱컬리 안해놓으면 자동으로 컴파일 안됨.)<br><br>
<%=user %>
<%
if(user==null){
%>
<a href="/views/user/login">로그인하기</a>
<a href="/views/user/signup">회원가입</a>
<%
}else{
%>
<a href="/board/list">게시판가기</a>
<a href="/users/logout">로그아웃</a>
<%
}
%>
</body>
</html>