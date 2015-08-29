<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="row">
					<div class="col-md-1">
						<a id="add" data-toggle="modal" data-target=".form-add" class="btn btn-primary btn-md"><i class="glyphicon glyphicon-plus"></i></a>
					</div>
					<div class="col-md-11">
						<input type="text" class="form-control" placeholder="Type to search" />
					</div>
				</div>
			</div>
			<div class="panel-body">
				<table class="table table-bordered table-hovered table-striped">
					<thead>
						<tr>
							<th style="width:100px">ID</th>
							<th>Category</th>
							<th style="width:50px"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listCategory}" var="category">
						<tr>
							<td>${category.id}</td>
							<td><a href="#" class="link-c" data-id="${category.id}" data-toggle="modal" data-target=".form-add">${category.name}</a></td>
							<td>
								<a class="btn btn-danger btn-sm" href='<spring:url value="/categories/delete/${category.id}.htm" />'><i class="glyphicon glyphicon-remove"></i></a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<nav class="text-center">
				  <ul class="pagination" style="margin-top:0px; margin-bottom:0px;">
					<c:if test="${hasPrev == true}">
					<li>
					  <a href="<spring:url value="/categories/${curPages - 1}.htm" />" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					  </a>
					</li>
					</c:if>
					<c:forEach begin="1" step="1" end="${totalPages}" var="x">
					<li class="${curPages == x ? 'active' : '' }"><a href='<spring:url value="/categories/${x}.htm" />'>${x}</a></li>
					</c:forEach>
					<c:if test="${hasNext == true}">
					<li>
					  <a href="<spring:url value="/categories/${curPages + 1}.htm" />" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					  </a>
					</li>
					</c:if>
				  </ul>
				</nav>
			</div>
		  </div>
	  </div>
	  
  </div>
  
  <div class="modal fade form-add" tabindex="-1" role="dialog" aria-labelledby="formAddModal">
	  <div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">Kategori</h4>
			</div>
			<div id="form-c" style="padding:10px;">
				
			</div>
		</div>
	  </div>
  </div>