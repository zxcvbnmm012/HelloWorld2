<%@page import="com.yedam.common.PageDTO"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- https://startbootstrap.com/template/simple-sidebar -->
<!--  부트스트랩 템플릿  -->

<jsp:include page="../include/header.jsp"/>     <!-- include: action 태그 -->
 <%
 	List<BoardVO> list = (List<BoardVO>) request.getAttribute("blist"); 
 // getAttribute 반환 : object 타입 -> 모든 클래스의 부모클래스이므로 자식클래스 List로 형변환 가능
 	System.out.println(list);
 	PageDTO paging = (PageDTO) request.getAttribute("pageInfo");
 %>
 	<p><%=paging %></p>
    <h3>게시글 목록</h3>
    <table class="table">
        <thead>
            <tr>
                <th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th><th>조회수</th>
            </tr>
        </thead>
        <tbody>
        <% for (BoardVO board : list) { %>
            <tr>
                <td><a href = "board.do?bno=<%=board.getBoardNo() %>"><%=board.getBoardNo() %></a></td><td><%=board.getTitle() %></td>
                <td><%=board.getWriter() %></td><td><%=board.getWriteDate() %></td>
                <td><%=board.getReadCnt() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    
    <!-- paging 시작 -->
	<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
    <!--  이전페이지 활성화 previous  -->
    <% if(!paging.isPrev()) {%>
    <li class="page-item disabled">  <!-- 비활성화 -->
      <a class="page-link">Previous</a>
    </li>
    <%} else {%>
    <li class="page-item">
      <a class="page-link" href="boardList.do?page=<%=paging.getStart()-1 %>">Previous</a>
    </li>
    <%} %>
    <!--  paging 정보를 활용 -->
    <% for (int p = paging.getStart(); p <= paging.getEnd(); p++){ %>
    <li class="page-item"><a class="page-link" href="boardList.do?page=<%= p %>"><%= p %></a></li>
    <% } %>
    
     <!--  이후페이지 활성화 Next  -->
    <% if(paging.isPrev()) {%>
    <li class="page-item disabled">  <!-- 비활성화 -->
      <a class="page-link">Next</a>
    </li>
    <%} else {%>
    <li class="page-item">
      <a class="page-link" href="boardList.do?page=<%=paging.getEnd()+1 %>">Next</a>
    </li>
    <%} %>
 
    </li>
    </ul>
    </nav>
    
    <!-- paging 종료 -->
    
<jsp:include page="../include/footer.jsp"/>
