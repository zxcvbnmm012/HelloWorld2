<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.service.BoardServiceImpl"%>
<%@page import="com.yedam.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  <!--  c 태그 라이브러리 : 커스텀태그  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  <!--  포맷관련 라이브러리  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("msg", "Hello");
		session.setAttribute("errorMsg", "ID,PW확인."); // session : 일정기간 실행하기 위해 사용하는 객체
		application.setAttribute("projectName", "BoardWeb"); // applicatoin : 생명주기가 긴 객체
		
		BoardService svc = new BoardServiceImpl();
		SearchDTO search = new SearchDTO();
		search.setPage(1);
		List<BoardVO> list = svc.boardList(search);
		request.setAttribute("blist", list);
	%>
	
	<!-- 표현식 -> 주석문 안에서 사용 x -->
	
	<!--  문자열 출력  -->
	<p>${'Hello, World'}</p>  <!--  화면에 출력  -->
	<p>${10-5 == 10}</p> <!-- 연산도 가능  -->
	
	<!--  비교연산자   -->
	<p>${10-5 eq 10}</p> <!-- eq : ==  -->
	<!-- <p>${10 - 5 ne 10}</p> <!-- ne : !=  -->  
	<p>${10-5 gt 10}</p> <!-- gt : >  -->
	<p>${10-5 ge 10}</p> <!-- ge : >=  -->
	<p>${10-5 lt 10}</p> <!-- lt : <  -->
	<p>${10-5 le 10}</p> <!-- le : <=  -->
	
	<!--  Attribute 출력 -->
	<p>${msg }</p>
	<p>${!empty msg }</p>  <!--  msg가 비어있지 않으면 true -->
	<p>${errorMsg }</p>
	<p>${empty hello }</p> <!--  hello라는 Attribute가 없으면 true -->
	
	<!--  라이브러리에서 가져온 c태그 사용  -->
	<c:set var="name" value="Hongkildong"></c:set>  <!--  입력 태그 -->
	<c:out value="${name }"></c:out>  <!--  출력 태그  -->
	
	<c:set var="age" value="15"></c:set>
	<c:if test="${age >= 20}">
		<p>성인</p>
	</c:if>
	
	<!--  조건문  -->
	<c:choose>
		<c:when test="${!empty logId }">
			<p>로그인상태</p>	<!--  if   -->
		</c:when>
		<c:otherwise>
			<p>로그아웃상태</p> <!-- else  -->
		</c:otherwise>
	</c:choose>
	
	<!--  반복문   -->
	<c:forEach var="i" begin="1" end="5" step="2">
		<span>i의 값은 ${i }</span>
	</c:forEach>	
	
	<!--  반복문2 -->
	<table border="1">
	<c:forEach var="board" items="${blist }">  <!--  blist에 담긴 개수만큼 반복  -->
		<tr>
			<td>${board.boardNo }</td>  <!--  board.getBoardNo()  -> 표현식 안에는 메소드 사용 x / 속성이름을 적으면 메소드를 유추해서 호출 -->
			<td>${board.title }</td>    <!--  board.getTitle()  -->
			<td><c:out value="${board.writer }"/></td>   
			<td><fmt:formatDate value="${board.writeDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td>   
		</tr>
	</c:forEach>
	</table>
	
	
	

</body>
</html>