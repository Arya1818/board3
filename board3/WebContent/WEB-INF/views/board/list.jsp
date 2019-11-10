<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/common/header.jspf"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>작성시간</th>
		</tr>
 
		<c:if test="${empty list}">
			<tr>
				<td colspan="5">게시물이 없습니다.</td>
			</tr>
		</c:if> 

		<c:forEach var="board" items="${list}">
		
			<tr>
				<td>${board.biNum}</td>
				<td><a href="/board/view?biNum=${board.biNum}">${board.biTitle }</td>
				<td>${board.uiId}</td>
				<td>${board.credat }</td>
				<td>${board.cretim }</td>
			</tr>
		</c:forEach>

	</table>
	<a href="/views/board/insert">글쓰기</a>
</body>
</html>