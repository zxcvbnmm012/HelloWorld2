/*
* covid.js
*/
import {makeRow, url} from './covid_module.js';

console.log("10분 쉬었다하기.");
let centerAry;

	fetch(url)
		.then(data => data.json())
		.then(result => {
			centerAry = result.data; // [{},{},{}...{}]
			// 시도 정보 배열.
			let sidoAry = [];
			// tr>td*2
			// #centerList
			// [].forEach(function(elem, idx, ary){        })
			centerAry.forEach((center,idx) => {
				// sidoAry에 중복하지 않게 담기.	
				if (sidoAry.indexOf(center.sido) == -1){  // 같은 값이 없으면 ?
					sidoAry.push(center.sido); // 추가.
				}		
				if (idx < 10){
					let tr = makeRow(center);

				 	// tr 생성하기.
					document.querySelector('#centerList').appendChild(tr);
					
				} // end of if
			}) // end of forEach
			console.log(sidoAry);
			// sidoAry의 개수만큼 <option value="sido정보">sido정보</option>
			sidoAry.forEach(sido => {
				let opt = document.createElement('option');
				opt.value = sido;
				opt.innerText = sido;
				document.getElementById('sido').appendChild(opt);
			})
		
		})
		.catch(err => console.log(err))
		
// 조회 event
document.querySelector('button.btn-primary').addEventListener('click', function (){
	// 목록지우기
	document.querySelector('#centerList').innerHTML = "";
	let keyword = document.getElementById('centerName').value;
	centerAry
		.reduce((acc, center) => {
			if(center.sido == keyword){
				let tr = makeRow(center);
				acc.appendChild(tr);
			}
			return acc; // 다음 순번의 acc 값으로 반환.
		}, document.querySelector('centerList'));
		//.filter((center) =>  center.centerName.indexOf(keyword) != -1)  // true or false
		//.filter(center => center.centerName.includes(keyword)) // 배열.
		//.forEach(center => {
		  //let tr = makeRow(center);
		  //document.querySelector('#centerList').appendChild(tr);
	//})
});

// select 태그의 change 이벤트.
document.querySelector('#sido').addEventListener('change', function(e){
	document.querySelector('#centerList').innerHTML = "";
	let keyword = document.getElementById('sido').value;

	centerAry
		.filter(center => center.sido == keyword) // 배열.
		.forEach(center => {
		  let tr = makeRow(center);
		  document.querySelector('#centerList').appendChild(tr);
	})
	
});

// [].push(), [].unchift(), [].pop(), [].shift() => [].splice()
// reduce(함수, 초기값) 메소드.
// 이번 순번에서 반환해주는 매개값이 다음 순번의 누산값(acc)으로 사용됨.
// acc : 다음 순번의 값 / elem : 이번 순번의 값
// 0 1 -> 1 3 -> 3 5 -> 5 7
let result = [1, 3, 5, 7].reduce(function(acc, elem, idx, ary){
	console.log(acc, elem);
	if(elem > 4){
		let li = document.createElement('li');
		li.innerHTML = elem;
		console.log(li);
		acc.appendChild(li);
	}
	return acc;
	// return elem;
	// return acc < elem ? elem : acc; -> max 반환.  
}, document.querySelector('#target'));

console.log('결과: ', result);