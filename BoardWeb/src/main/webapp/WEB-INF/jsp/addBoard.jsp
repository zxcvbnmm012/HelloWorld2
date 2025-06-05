<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
<!-- 부트스트랩 사용 -->
</head>
<body>
	<form action="addBoard.do" method="post"> <!-- post : 요청정보가 body 영역에 데이터가 담겨서 서버로 전달됨 url에 파라미터가 보여지지 않음. 담을 수 있는 데이터가 큼-->
	                                          <!-- get  : header 영역에 데이터가 담겨서 서버로 전달됨, 담을 수 있는 데이터가 한정적임 -->
        <table class="table">
	    <tr>
	      <th>제목</th><td><input type="text" required name="title"></td></tr>  <!-- name : parameter 이름 -->
	    <tr>
	      <th>내용</th><td><input type="text" required name="content"></td></tr> 
	    <tr>
	      <th>작성자</th><td><input type="text" required name="writer"></td></tr>  
	    <tr>
	      <td colspan="2" align="center">
	        <input type="submit" value="등록">  <!--  required name : 값을 넣지 않으면 submit 안됨 -->
	        <input type="reset" value="취소">
	      </td></tr>
	  </table>
	</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>

</body>
</html>