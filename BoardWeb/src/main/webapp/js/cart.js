/**
 * cart.js
 */
// 장바구니 상품.
const cartItems = [{
	itemId: 1,
	itemName: "상품1",
	price: 2500,
	qty: 3,
	image: 'basket1.jpg'
}, {
	itemId: 2,
	itemName: "상품2",
	price: 3500,
	qty: 2,
	image: 'basket2.jpg'
}, {
	itemId: 3,
	itemName: "상품3",
	price: 4500,
	qty: 1,
	image: 'basket3.jpg'
}]


const cont = document.getElementById('all');
let upid = 1;
let products = document.querySelectorAll('.p_num'+upid);

console.log(products);


cartItems.forEach(function(e) {
	str = `<div class="row data" data-id=`+ e.itemId+ `">
	                <div class="subdiv">
	                    <div class="check"><input type="checkbox" name="buy" value="260" checked="">&nbsp;</div>
	                    <div class="img"><img src="./images/basket1.jpg" width="60"></div>
	                    <div  class="pname"> <span>`+ e.itemName +`</span> </div>
	                </div>
	                <div class="subdiv">
	                    <div class="basketprice">
	                        <input type="hidden" name="p_price" id="p_price1" class="p_price" value=`+ e.price +`>`+e.price+`
	                    </div>
	                    <div class="num">
	                        <div class="updown">
	                            <input type="text" name="p_num" id="p_num`+upid+`" size="2" maxlength="4" class="p_num" value=`+e.qty+`
	                                onkeyup="javascript:basket.changePNum(event);">
	                            <span onclick="javascript:basket.changePNum(event);">
	                                <i id="up`+upid+`" class="fas fa-arrow-alt-circle-up up"></i> </span>                                 
	                            <span onclick="javascript:basket.changePNum(event);">
	                                <i id="down" class="fas fa-arrow-alt-circle-down down"></i> </span>
	                        </div>
	                    </div>
	                    <div class="sum"></div>
	                </div>
	                <div class="subdiv">
	                    <div class="basketcmd">
	                        <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem(event);">삭제</a>
	                    </div>
	                </div>
	            </div>`

  // 각각에 HTML 삽입
  cont.insertAdjacentHTML('beforeend', str);
  upid++;
 
});

let sumqty = 0;
let productAry = [];
let sumAry = [];

function sumf(){
		document.querySelectorAll('input[name="p_num"]').forEach(function(e){
		console.log(e);
		productAry.push(e.value);
		
	})
	productAry.forEach(function(e){
		sumqty += parseInt(e);
	})
	console.log(productAry);
	console.log(sumqty);
	document.getElementById('sum_p_num').querySelector('span').innerHTML = sumqty;
	document.getElementById('sum_p_price').querySelector('span').innerHTML = productAry[0]*2500 + productAry[1]*3500 + productAry[2]*4500;
	productAry = [];
	sumqty = 0;
}

sumf();


// 기능 넣기.

const basket = {
	// 장바구니 수량 변경.
	
	changePNum(event) {
	  const target = event.target;
	  const updownDiv = target.closest('.updown'); 
	  const input = updownDiv.querySelector('input.p_num'); 

	  let currentValue = parseInt(input.value);

	  if (target.classList.contains('up')) {
	    input.value = currentValue + 1;
		sumf();
		
	  } else if (target.classList.contains('down')) {
	    if (currentValue >= 1) {
	      input.value = currentValue - 1;
		  sumf();
	    }
		  
	  }
  	},
	// 상품삭제.
	delItem(event) {
		const target = event.target;
		target.parentElement.parentElement.parentElement.querySelector('input.p_num').value = '0';
		target.parentElement.parentElement.parentElement.remove();
		sumf();
	},
	// 선택상품삭제.
	delCheckedItem() {
		cartItems.forEach(function(e){
			let ck = cont.querySelectorAll('.check');
			ck.forEach(function(e){
				let check = e.querySelector('input');
				console.log(check);
				if(check.checked){
					check.parentElement.parentElement.parentElement.remove();
					
					console.log(check.parentElement.parentElement.parentElement.querySelector());
				}
			})
		});

				

		
	},
	// 장바구니 비우기.
	delAllItem() {
		const target = event.target;
		console.log(target);
		document.getElementById("all").remove();
		document.getElementById('sum_p_num').querySelector('span').innerHTML = "0";
		document.getElementById('sum_p_price').querySelector('span').innerHTML = "0";
		
	}
}

