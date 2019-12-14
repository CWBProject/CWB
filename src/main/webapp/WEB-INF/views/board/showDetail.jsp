<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp" %>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시글 등록</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">신규 게시글</div>
			<div class="panel-body">
					<div class="form-group">
						<label>Bno : </label>
						<input class="form-control" type="text" name="bno" 
						value='<c:out value="${board.bno}" />' readonly="readonly">
					</div>
					<div class="form-group">
						<label>제목 : </label>
						<input class="form-control" type="text" name="title" 
						value='<c:out value="${board.title}"/>' readonly="readonly">
					</div>
					<div class="form-group">
						<label>작성자 : </label>
						<input class="form-control" type="text" name="writer" 
						value='<c:out value="${board.writer}" />' readonly="readonly">
					</div>
					<div class="form-group">
						<label>내용 : </label>
						<textarea class="form-control" name="content" rows="4" cols="50">
							<c:out value="${board.content}"/>
						</textarea>
					</div>

					<button data-oper='modify' class="btn btn-default">수정</button>
					<button data-oper='list' class="btn btn-info">목록</button>
					
					<!-- 264쪽 : 나중에 다양한 상황처리 -->
					<form id="operForm" method="get">
						<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno}" />'>
						<input type="hidden" name='pageNum' value='${pageMaker.pageNum}'>
						<input type="hidden" name='amount' value='${pageMaker.amount}'>
						<input type="hidden" name="searchType" value='<c:out value="${pageMaker.searchType}" />'>
						<input type="hidden" name="keyword" value='<c:out value="${pageMaker.keyword}" />'>
					</form>
			</div>
		</div>
		<!-- 댓글 목록 -->
		<div class="panel panel-default">
			<div class="panel-heading">
			<i class="fa fa-comments fa-fw"></i>Reply
			</div>
			<div class="panel-body">
				<ul class="chat">
					<li class="left clearfix" data-rno='12'>
						<div>
							<div class="header">
								<strong class="primary-font"></strong>
							</div>
							
						</div>
				
				</ul>
					
			</div>
		</div>
	</div>
</div>

<%@include file="../includes/footer.jsp" %>
	
<script type="text/javascript">
$(document).ready(function(){
	var operForm = $("#operForm");

	$("button[data-oper='modify']").on("click", function(e){
		operForm.attr("action", "/board/modify");
		operForm.submit();
	});

	$("button[data-oper='list']").on("click", function(e){
		operForm.find("#bno").remove();
		operForm.attr("action", "/board/list");
		operForm.submit();
	});

});
</script>	
	
	
	
	
	
	
	
	
	
	
	