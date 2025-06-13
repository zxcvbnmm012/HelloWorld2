/**
 * ajax.js
 * Asynchronous Javascript And Xml
 */

// 비동기 vs 동기 방식
/*  비동기방식
setTimeout(function(){
	console.log("1");
}, 1000)  //  일정시간이 지나면 함수를 실행함 -> (매개값1 : 함수, 매개값2: 지연시간) 1000: 1초

setTimeout(function(){
	console.log("2");
}, 2000)  //  일정시간이 지나면 함수를 실행함 -> (매개값1 : 함수, 매개값2: 지연시간) 2000: 2초

setTimeout(function(){
	console.log("start");
}, 2500)  //  일정시간이 지나면 함수를 실행함 -> (매개값1 : 함수, 매개값2: 지연시간) 2500: 2.5초
*/

/*  동기방식 : 하나의 작업이 끝나면 다음 작업을 수행
setTimeout(function(){
	console.log("1");
	
	setTimeout(function(){
		console.log("2");
		
		setTimeout(function(){
			console.log("start");
		}, 2500)  
	}, 2000)  
}, 1000)  
*/

// {"id":1, "first_name": "Hong"} => json 객체
// -> {id: 1, first_name: "Hong"} => javascript 객체

// 객체. XMLHttpRequest
//console.log("start");
let xhtp = new XMLHttpRequest();  // 비동기방식으로 처리 : ajax
xhtp.open('get', 'replyList.do?bno=213'); // 요청할 페이지 지정.
xhtp.send(); // 페이지 요청.
xhtp.onload = function() {
	console.log(xhtp.responseText);
	let data = JSON.parse(xhtp.responseText);
	data.forEach(function(item) {
		// console.log(item);
		let tr = makeRow(item);
		
		// tr을 tbody에 추가
		document.querySelector('table:nth-of-type(2) tbody').appendChild(tr); // 2번째 테이블 태그의 tbody에 넣겠다.
	});
	//document.querySelector('#show').innerHTML = xhtp.responseText;
};

// 등록이벤트.
document.querySelector('#addReply').addEventListener('click', addReplyFnc);

// 댓글 등록 함수.
function addReplyFnc(e){
	const bno = document.querySelector('#bno').value;  // input 태그의 value 읽어오기
	const reply = document.querySelector('#reply').value;  // input 태그의 value 읽어오기
	
	// 필수입력 : bno, reply, logId 값이 모두 있으면 Ajax 호출
	if (!bno || !reply || !logId){
		alert('필수값 입력!');
		return;
	}
	const addAjax = new XMLHttpRequest();
	addAjax.open('get', 'addReply.do?bno=' + bno + '&reply=' + reply + '&replyer=' + logId);
	addAjax.send();
	addAjax.onload = function(ev){
		let result = JSON.parse(addAjax.responseText);
		if (result.retCode == 'Success'){
			alert('등록성공!');
			let tr = makeRow(result.retVal);	
			
			// 부모요소.insertBefore(새요소, 대상)
			let target = document.querySelector('table:nth-of-type(2) tbody tr');
			document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr, target); // 2번째 테이블 태그의 tbody에 넣겠다.

		} else {
			alert('등록실패!');
	
		}
		
	}
}

// 댓글 삭제 함수.
function deleteReplyFnc(e){
	if (!confirm("삭제하시겠습니까?")){
		return;
	}
	let rno = e.target.parentElement.parentElement.dataset.rno;
	console.log(rno);
	const delAjax = new XMLHttpRequest();
	delAjax.open('get', 'removeReply.do?rno='+rno);
	delAjax.send(); // 서버상에 데이터 요청
	delAjax.onload = function(ev){ // 처리된 결과를 받아왔을때 발생하는 이벤트 : onload
		// load 이벤트가 발생하면 function(e) 실행.
		let result = JSON.parse(delAjax.responseText);
		if (result.retCode == 'Success'){
			e.target.parentElement.parentElement.remove(); // 화면처리
		} else {
			alert('처리실패');
		}
	}
	
}

// 댓글 출력 함수.
function makeRow(item){
	let tr = document.createElement('tr'); // <tr></tr>
	tr.setAttribute('data-rno', item.replyNo); // <tr data-rno="8" ></tr>
	// 글번호,내용,작성자
	for (let prop of ['replyNo', 'reply', 'replyer']) {
		let td = document.createElement('td'); // <td>3</td>
		td.innerHTML = item[prop]; // item['replyNo']
		tr.appendChild(td); // <tr><td>3</td></tr>
	}
	// button생성.
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.addEventListener('click', deleteReplyFnc)
	btn.innerHTML = '삭제';
	btn.className = 'btn btn-danger';
	td.appendChild(btn);
	tr.appendChild(td);
	return tr; // makeRow를 호출한 영역으로 tr 반환.
} // end of makeRow.

function memberList() {
	//console.log("1");
	//console.log(xhtp.responseText); // parsing
	let data = JSON.parse(xhtp.responseText);
	//console.log(data);
	let str = "<ul>";
	data.forEach(function(item, idx, arr) {
		console.log(item);
		str += "<li>" + item.id + "," + item.first_name + "</li>";
	});
	str += "</ul>";
	document.querySelector('#show').innerHTML = str;
}
//console.log("end");

// fetch('data/sample.json')