<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  <!--  c 태그 라이브러리 : 커스텀태그  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  <!--  포맷관련 라이브러리  -->

<link href="//cdn.datatables.net/2.3.2/css/dataTables.dataTables.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="//cdn.datatables.net/2.3.2/js/dataTables.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
    <h3>상세화면(board.jsp)</h3>
    <form action="modifyBoard.do">
    <input type="hidden" name="bno" value="${board.boardNo }">
    <input type="hidden" name="page" value="${page }">
    <input type="hidden" name="searchCondition" value="${searchCondition }">
    <input type="hidden" name="keyword" value="${keyword }">
    
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
            	<c:choose>
            		<c:when test="${board.writer eq logId}">
                		<input type="submit" value="수정" class="btn btn-warning" >
                		<button class="btn btn-danger" type="button" >삭제</button>
            		 </c:when>
            		 <c:otherwise>
            		    <input type="submit" value="수정" class="btn btn-warning" disabled>
               		    <button class="btn btn-danger" type="button" disabled>삭제</button>
            		 </c:otherwise>
            	</c:choose>
            </td>
        </tr>
    </table>
    </form>
    
<!-- 댓글관련 페이지 -->
<style>
    div.reply ul {
        list-style-type: none;
    }

    div.reply span {
        display: inline-block;
    }
</style>
<div class="container reply">
    <div class="header">
        <input class="col-sm-7" id="reply">
        <button class="col-sm-2 btn btn-primary" id="addReply">등록</button>
        <button class="col-sm-2 btn btn-danger" id="delReply">삭제</button>
    </div>
	<!--  datatable 적용. -->
	<table id="example" class="display">
        <thead>
            <tr>
                <th>댓글번호</th>
                <th>댓글내용</th>
                <th>작성자</th>
                <th>작성일시</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>댓글번호</th>
                <th>댓글내용</th>
                <th>작성자</th>
                <th>작성일시</th>
            </tr>
        </tfoot>
    </table>
</div>
<!-- 댓글관련 페이지 -->

<script>
    let bno = "${board.boardNo}";
    let logId = "${logId}";
    document.querySelector('button.btn-danger').addEventListener('click', function () {
        location.href = 'removeBoard.do?bno=' + bno;
    })
</script>

<script>

const table = new DataTable('#example', {
    ajax: 'replyList.do?bno='+bno,
    columns: [
        { data: 'replyNo' },
        { data: 'reply' },
        { data: 'replyer' },
        { data: 'replyDate' }
    ],
    lengthMenu: [5, 10, 15, -1],
    order: [[0, 'desc']]
});

function addNewRow() {
	// ajax.
	let reply = document.querySelector('#reply').value;
	if(!reply || !logId){
		return;
	}
	fetch('addReply.do?bno='+bno+'&reply='+reply+'&replyer='+logId)
	.then(data => data.json())
	.then(result => {
		let rvo = result.retVal;
	
	// 화면
    table.row
        .add({replyNo: rvo.replyNo,
        	  reply: rvo.reply,
        	  replyer: rvo.replyer,
        	  replyDate: rvo.replyDate
        })
        .draw(false);
	})
	.catch(err => console.log(err)); 

}

// row 삭제.
// jquery
table.on('click', 'tbody tr', (e) => {  // tbody에 있는 tr을 클릭하면 {}블록 안의 코드 실행
    let classList = e.currentTarget.classList;
 
    if (classList.contains('selected')) {  // 선택한 tr에 selected라는 클래스가 할당된 상태면
        classList.remove('selected');  // 삭제
    }
    else {  // each : 반복문   // 선택한 tr이 없다면 -> 새로운 tr을 선택할때
        table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));  // 이전에 선택한 tr은 삭제
        classList.add('selected');
    }
});
 
document.querySelector('#delReply').addEventListener('click', async function () { // id가 delReply인 요소에 클릭이벤트 등록
	// 화면갱신.
	if(!document.querySelector('tr.selected')){
		alert("댓글을 선택하세요!")
		return;
	}
	
	let rno = document.querySelector('tr.selected').children[0].innerHTML;
	let data = await fetch('removeReply.do?rno='+rno);
	let result = await data.json();  // await : 프로미스 객체여야 함
	if(result.retCode == 'Success'){
	    table.row('.selected').remove().draw(false);
		
	}
		
});
 
document.querySelector('#addReply').addEventListener('click', addNewRow);
</script>