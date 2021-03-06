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
				<form role="form" action="insert.do" method="post">
					<div class="form-group">
						<label>제목 : </label><input class="form-control" type="text" name="title">
					</div>
					<div class="form-group">
						<label>작성자 : </label><input class="form-control" type="text" name="writer">
					</div>
					<div class="form-group">
						<label>내용 : </label><textarea class="form-control" name="content" rows="4" cols="50"></textarea>
					</div>
					<input class="btn btn-default" type="submit" value="등록">
					<input class="btn btn-default" type="reset" value="초기화">
				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="../includes/footer.jsp" %>
	