<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form commandName="category" cssClass="form-horizontal">
  <form:hidden path="id"/>
  <div class="form-group">
	<label for="inputEmail3" class="col-sm-3 control-label">Nama Kategori</label>
	<div class="col-sm-9">
	  <form:input path="name" cssClass="form-control" />
	</div>
  </div>
  <div class="form-group">
	<div class="col-sm-offset-3 col-sm-9">
	  <button type="submit" class="btn btn-default">Simpan</button>
	</div>
  </div>
</form:form>