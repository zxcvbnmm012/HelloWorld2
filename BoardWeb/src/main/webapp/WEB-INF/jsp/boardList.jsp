<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="com.yedam.common.PageDTO"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- https://startbootstrap.com/template/simple-sidebar -->
<!--  부트스트랩 템플릿  -->
<jsp:include page="../include/header.jsp" />   <!-- include: action 태그 -->
  <%
    List<BoardVO> list = (List<BoardVO>) request.getAttribute("blist");
 // getAttribute 반환 : object 타입 -> 모든 클래스의 부모클래스이므로 자식클래스 List로 형변환 가능
    PageDTO paging = (PageDTO) request.getAttribute("pageInfo");
 	SearchDTO search = (SearchDTO) request.getAttribute("search");
  %>
  <p><%=paging %></p>
  <h3>게시글 목록</h3>
 
 <!-- 검색조건추가. -->
 <form action="boardList.do">
  <div class="row">
    <div class="col-sm-4"> <!-- sm : 화면크기 --> <!-- 전체 화면을 12등분해서 4/12 만큼 차지하게 하겠다 -->
      <select name="searchCondition" class="form-control">
        <option value="">선택하세요</option>
        <option value="T"  <%=search.getSearchCondition() != null && search.getSearchCondition().equals("T") ? "selected":"" %>>제목</option>
        <option value="W"  <%=search.getSearchCondition() != null && search.getSearchCondition().equals("W") ? "selected":"" %>>작성자</option>
        <option value="TW" <%=search.getSearchCondition() != null && search.getSearchCondition().equals("TW") ? "selected":"" %>>제목&작성자</option>
      </select>
    </div>
    <div class="col-sm-6">
      <!-- input[name="keyword"].form-control  : 속성이 name=keyword이고 클래스이름이 form-control인 input 태그 만들기-->
      <input type="text" name="keyword" class="form-control" value="<%=search.getKeyword() == null ? "" : search.getKeyword() %>">
    </div>
    <div class="col-sm-2">
      <!-- input:submit : 타입이 submit인 input 태그 만들기-->
      <input type="submit" value="검색" class="btn btn-primary">
    </div>
  </div>
</form>

  <table class="table">
    <thead>
      <tr>
        <th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th><th>조회수</th>
      </tr>
    </thead>
    <tbody>
      <%for (BoardVO board : list) { %>
      <tr>
        <td><a href="board.do?bno=<%=board.getBoardNo() %>&searchCondition=<%=search.getSearchCondition()%>&keyword=<%=search.getKeyword()%>&page=<%=paging.getCurrentPage()%>"><%=board.getBoardNo() %></a></td>
        <td><%=board.getTitle() %></td>
        <td><%=board.getWriter() %></td>
        <td><%=board.getWriteDate() %></td>
        <td><%=board.getReadCnt() %></td>
      </tr>
      <%} %>
    </tbody>
  </table>
  <!-- paging 시작. -->
<nav aria-label="Page navigation example">
<ul class="pagination justify-content-center">
  <!-- 이전페이지 활성화. -->
  <%if(!paging.isPrev()) {%>
  <li class="page-item disabled">
    <a class="page-link">Previous</a>
  </li>
  <%} else { %>
  <li class="page-item">
    <a class="page-link" href="boardList.do?page=<%=paging.getStart()-1 %>">Previous</a>
  </li>
  <%} %>
  
  <!-- paging 정보를 활용. -->
  <%for(int p = paging.getStart(); p <= paging.getEnd(); p++) { %>
  <%  if(p != paging.getCurrentPage()) {%>
  <li class="page-item">
    <a class="page-link" href="boardList.do?searchCondition=<%=search.getSearchCondition()%>&keyword=<%=search.getKeyword() %>&page=<%=p %>"><%=p %></a>
  </li>
  <%}else{ %>
  <li class="page-item active" aria-current="page">
    <span class="page-link"><%=p %></span>
  </li>
  <%} } %>

  <!-- 이후페이지 활성화. -->
  <%if(!paging.isNext()) {%>
  <li class="page-item disabled">
    <a class="page-link">Next</a>
  </li>
  <%} else { %>
  <li class="page-item">
    <a class="page-link" href="boardList.do?page=<%=paging.getEnd()+1 %>">Next</a>
  </li>
  <%} %>

</ul>
</nav>  

  <!-- paging 종료. -->
<jsp:include page="../include/footer.jsp" />
