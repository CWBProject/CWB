<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../includes/header.jsp" %>

<title>회원등록</title>
<style>
	/* .help-block 을 일단 보이지 않게 설정 */
	#registerForm .help-block{
		display: none;
	}
	/* glyphicon 을 일단 보이지 않게 설정 */
	#registerForm .glyphicon{
		display: none;
	}
</style>

<form id="registerForm" role="form" action="insert.do" method="post">

<div class="container">
    <h4><strong>회원등록</strong></h4>
    <div class="form-group" id="divId">
    	<label for="inputId" class="col-lg-2 control-label">아이디</label>
		<div class="col-lg-7">
			<input type="text" class="form-control onlyAlphabetAndNumber" name="id" data-rule-required="true" placeholder="12자이내의 알파벳, 언더스코어(_), 숫자만 입력 가능합니다." maxlength="12">
		</div>
    </div>
    <div class="form-group" id="divPassword">
		<label for="inputPassword" class="col-lg-2 control-label">패스워드</label>
		<div class="col-lg-7">
			<input type="password" class="form-control onlyAlphabetAndNumber" name="password" data-rule-required="true" placeholder="패스워드. 12자이내의 알파벳, 숫자만 입력 가능합니다." maxlength="12">
		</div>
	</div>
	<div class="form-group" id="divPasswordCheck">
		<label for="inputPasswordCheck" class="col-lg-2 control-label">패스워드 확인</label>
		<div class="col-lg-7">
			<input type="password" class="form-control onlyAlphabetAndNumber" name="passwordCheck" data-rule-required="true" placeholder="패스워드 확인" maxlength="12">
		</div>
	</div>
		<div class="form-group" id="divHeight">
		<label for="inputHeight" class="col-lg-2 control-label">신장(cm)</label>
		<div class="col-lg-7">
			<input type="text" class="form-control onlyNumber" name="height" data-rule-required="true" placeholder="키를 cm단위로 입력하세요" maxlength="3">
		</div>
	</div>
		<div class="form-group" id="divAddress">
		<label for="inputAddress" class="col-lg-2 control-label">주소</label>
		<div class="col-lg-7">
			<input type="text" class="form-control onlyHangul" name="address" data-rule-required="true" placeholder="주소를 시/군(구)/동까지만 입력하세요. 최대 한글 25글자" maxlength="50">
		</div>
	</div>
	<div class="form-group" id="divNickname">
		<label for="inputNickname" class="col-lg-2 control-label">별명</label>
		<div class="col-lg-7">
			<input type="text" class="form-control" name="nickname" data-rule-required="true" placeholder="별명을 입력하세요. 최대 한글 50글자" maxlength="100">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPosition" class="col-lg-2 control-label">포지션</label>
		<div class="col-lg-7">
			<select class="form-control" name="position">
				<option value="1">Point Guard</option>
				<option value="2">Shooting Guard</option>
				<option value="3">Small Forward</option>
				<option value="4">Power Forward</option>
				<option value="5">Center</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="inputGender" class="col-lg-2 control-label">성별</label>
		<div class="col-lg-7">
			<select class="form-control" name="gender">
				<option value="1">남자</option>
				<option value="2">여자</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<div class="col-lg-offset-2 col-lg-10">
			<button data-oper="register" class="btn btn-success">가입</button>
		</div>
		<div class="col-lg-7">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</div>
	</div>
	
</div>
</form>

<%@include file="../includes/footer.jsp" %>
<!-- <script type="text/javascript" src="/resources/js/member.js"></script> -->

<script type="text/javascript">
	$(document).ready(function() {
		//모달을 전역변수로 선언
		var modalContents = $(".modal-contents");
		var modal = $("#defaultModal");
		var registerForm = $("#registerForm");
		
		$('.onlyAlphabetAndNumber').keyup(function(event){
			if (!(event.keyCode >=37 && event.keyCode<=40)) {
				var inputVal = $(this).val();
				$(this).val($(this).val().replace(/[^_a-z0-9]/gi,'')); //_(underscore), 영어, 숫자만 가능
			}
		});
         
		$(".onlyHangul").keyup(function(event){
			if (!(event.keyCode >=37 && event.keyCode<=40)) {
				var inputVal = $(this).val();
				$(this).val(inputVal.replace(/[a-z0-9]/gi,''));
			}
		});
     
		$(".onlyNumber").keyup(function(event){
			if (!(event.keyCode >=37 && event.keyCode<=40)) {
				var inputVal = $(this).val();
				$(this).val(inputVal.replace(/[^0-9]/gi,''));
			}
		});
		
		if ($('#id').val() == "") {
			modalContents.text("아이디를 입력하여 주시기 바랍니다.");
			modal.modal('show');
             
			divId.removeClass("has-success");
			divId.addClass("has-error");
			$('#id').focus();
			return false;
		} else {
			divId.removeClass("has-error");
			divId.addClass("has-success");
		}
		
		if ($('#password').val() == "") {
			modalContents.text("패스워드를 입력하여 주시기 바랍니다.");
			modal.modal('show');
             
			divId.removeClass("has-success");
			divId.addClass("has-error");
			$('#password').focus();
			return false;
		} else {
			divId.removeClass("has-error");
			divId.addClass("has-success");
		}
		
		if ($('#passwordCheck').val() == "" || $('#password').val() != $('#passwordCheck').val()) {
			modalContents.text("패스워드를 확인하여 주시기 바랍니다.");
			modal.modal('show');
             
			divId.removeClass("has-success");
			divId.addClass("has-error");
			$('#passwordCheck').focus();
			return false;
		} else {
			divId.removeClass("has-error");
			divId.addClass("has-success");
		}
		
		
		$("button").on("click", function(e){
			e.preventDefault();
			
			
			registerForm.submit();
		});
		//regPost id를 가지는 요소에서 클릭이 발생하면 이 함수에서 처리합니다.
		/*
		$("#register").on("click", function(){
			console.log("Button Click....");
			var member = {
					id:$("#id").val(),
					password:$("#password").val(),
					height:$("#height").val(),
					grade:"0.f",
					address:$("#address").val(),
					nickname:$("#nickname").val(),
					position:$("#position").val(),
					gender:$("#gender").val()
			}
			memberService.add(
					member,
					function(result) {
						alret("Result : " + result);
					},
					function(er) {
						alret("Error : " + er)
					}
			);
		});
		*/
	});
</script>
