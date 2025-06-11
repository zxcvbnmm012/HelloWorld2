<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  <!--  c 태그 라이브러리 : 커스텀태그  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  <!--  포맷관련 라이브러리  -->

<%
	BoardVO board = (BoardVO) request.getAttribute("board"); 
	String pg = (String) request.getAttribute("page"); 
	String sc = (String) request.getAttribute("searchCondition"); 
	String kw = (String) request.getAttribute("keyword"); 

	String logId = (String) session.getAttribute("logId");

 %>
    <h3>상세화면(board.jsp)</h3>
    <form action="modifyBoard.do">
    <input type="hidden" name="bno" value="${board.boardNo }">
    <input type="hidden" name="page" value="${pg }">
    <input type="hidden" name="searchCondition" value="${sc }">
    <input type="hidden" name="keyword" value="${kw }">
    
    <table class="table">
        <tr>
            <th>글번호</th><td>${board.boardNo}</td>
            <th>조회수</th><td>${board.readCnt}</td>
        </tr>
        <tr>
            <th>제목</th><td colspan="3">${board.title }</td>
        </tr>
        <tr>
            <th>내용</th><td colspan="3"><textarea cols="45" rows="4" readonly>${board.content }</textarea></td>
        </tr>
        <tr>
            <th>작성자</th><td colspan="3">${board.writer }</td>
        </tr>
        <tr>
            <th>작성일시</th><td colspan="3">${board.writeDate }</td>
        </tr>
        <tr>
            <td colspan="4" align="center">
            	 <%if (board.getWriter().equals(logId)) {%>
                <input type="submit" value="수정" class="btn btn-warning" >
                <button class="btn btn-danger" type="button" >삭제</button>
                <%} else{ %>
                <input type="submit" value="수정" class="btn btn-warning" disabled>
                <button class="btn btn-danger" type="button" disabled>삭제</button>
                <%} %>
            </td>
        </tr>
    </table>
    </form>
    <script>
    	let bno = "<%=board.getBoardNo() %>";
    	console.log(bno);
    	document.querySelector('button.btn-danger').addEventListener('click', function(){
    		location.href = 'removeBoard.do?bno='+bno;  // GET 방식
    	})
    </script>
