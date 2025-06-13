/**
 * promise.js 
 */

// promise 객체역할
// 비동기방식의 처리를 동기방식으로 순서로 처리.

fetch('replyList.do?bno=213')
	.then(function(data){
		console.log(data);
		return data.json();
	})
	.then(function(result){
		console.log(result)
	})
	.catch(function(err){
		console.log(err);
	})
	