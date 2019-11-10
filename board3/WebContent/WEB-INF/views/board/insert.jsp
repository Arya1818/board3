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
	<form method="post" action="/board/insert">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><%=user.get("uiId")%></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="biTitle"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="biContent"></textarea></td>
			</tr>
			<tr>
				<th colspan="2"><button>등록하기</button></th>
			</tr>
		</table>
	</form>
</body>
</html>