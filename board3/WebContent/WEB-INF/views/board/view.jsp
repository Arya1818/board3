<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/WEB-INF/views/common/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>제목</th>
			<td>${board.biTitle }</td>
		</tr>
		<tr>	
			<th>내용</th>
			<td>${board.biContent }</td>
		</tr>
		<tr>	
			<th>작성자</th>
			<td>${board.uiName }</td>
		</tr>
		<tr>	
			<th>작성일</th>
			<td>${board.credat }</td>
		</tr>
		<tr>	
			<th>작성시간</th>
			<td>${board.cretim }</td>
		</tr>
		<tr>
			<th colspan="2">
			<button onclick="goPage('/board/list')">리스트가기</button>
			<c:if test="${user.uiNum==board.uiNum }">
			<button onclick="goPage('/board/update?biNum=${board.biNum}')">수정</button>
			<button onclick="goPage('/board/delete?biNum=${board.biNum}')">삭제</button>
			</c:if>
		</tr>
		
		<script>
			function goPate(url){
				location.href = url;
			}
		</script>
	</table>
</body>
</html>