<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>회원가입(signUp.jsp)</h3>
<form name="signForm" action="signup.do" method="post" enctype="multipart/form-data">
  <table class="table">
    <tr>
      <th>아이디</th>
      <td><input class="form-control" type="text" name="userId" required></td>
    </tr>
    <tr>
      <th>비밀번호</th>
      <td><input class="form-control" type="password" name="userPw" required></td>
    </tr>
    <tr>
      <th>이름</th>
      <td><input class="form-control" type="text" name="userName" required></td>
    </tr>
    <tr>
      <th>이미지</th>
      <td><input class="form-control" type="file" name="userImg"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" class="btn btn-primary" value="회원가입">
        <input type="reset" class="btn btn-secondary" value="초기화">
      </td>
  </table>
</form>

<script>
	let check = false;
	// document.forms
	document.forms.signForm.addEventListener('submit', function(e){
		if(!check){
			e.preventDefault(); // submit의 기본 기능 차단 -> 페이지 이동 x
			alert('입력값을 확인...!');
			return;
		}
		
		this.submit();  // validation이 통과된다면 submit.
	})
	
	document.querySelector('input[name="userId"]').addEventListener('change', function(e){
		console.log(this);
		let user = this.value;
		// 회원 입력값 check
		fetch('checkId.do?id='+user)
			.then(data => data.json())
			.then(result =>{
				if(result.retCode == "Exist"){
					alert("존재하는 아이디.");
				} else {
					alert("사용가능한 아이디.");
					check = true;
				}
			})
			.catch(err => console.log(err))
		
	})
	
		document.querySelector('input[name="userPw"]').addEventListener('change', function(e){
		console.log(this);
		let pw = this.value;
		// 회원 입력값 check
		fetch('checkId.do?pw='+pw)
			.then(data => data.json())
			.then(result =>{
				console.log(pw.length);
				if(pw.length < 4){
					alert("4자리 이상 입력.");
					check = false;
				} else {
					check = true;
				}
			})
			.catch(err => console.log(err))
		
	})
</script>