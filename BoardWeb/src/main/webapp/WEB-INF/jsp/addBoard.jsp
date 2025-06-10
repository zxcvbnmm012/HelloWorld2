<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../include/header.jsp"/> 
<%
	String logId = (String) session.getAttribute("logId");
%>
<h3>글등록화면(addBoard.jsp)</h3>
	<form action="addBoard.do" method="post"> <!-- post : 요청정보가 body 영역에 데이터가 담겨서 서버로 전달됨 url에 파라미터가 보여지지 않음. 담을 수 있는 데이터가 큼-->
	                                          <!-- get  : header 영역에 데이터가 담겨서 서버로 전달됨, 담을 수 있는 데이터가 한정적임 -->
        
        <input type="hidden" class="form-control" name="writer" value="<%=logId %>">
        <table class="table">
	    <tr>
	      <th>제목</th><td><input type="text" class="form-control" required name="title"></td></tr>  <!-- name : parameter 이름 -->
	    <tr>
	      <th>내용</th><td><textarea class="form-control" required name="content"></textarea></td></tr> 
	    <tr>
	      <th>작성자</th><td><%=logId %></td></tr>  
	    <tr>
	      <td colspan="2" align="center">
	        <input type="submit" value="등록">  <!--  required name : 값을 넣지 않으면 submit 안됨 -->
	        <input type="reset" value="취소">
	      </td></tr>
	  </table>
	</form>
<jsp:include page="../include/footer.jsp"/>
