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
						<a data-toggle="modal" data-target=".form-add" class="btn btn-primary btn-md"><i class="glyphicon glyphicon-plus"></i></a>
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
							<th style="width:100px">ISBN</th>
							<th>Title</th>
							<th>Author</th>
							<th>Publisher</th>
							<th style="width:50px"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listBook}" var="book">
						<tr>
							<td>${book.isbn}</td>
							<td>${book.title}</td>
							<td>
								<c:forEach items="${book.authors}" var="author">
									${author.firstName} ${author.lastName}, 
								</c:forEach>
							</td>
							<td>${book.publisher.name}</td>
							<td>
								<a class="btn btn-danger btn-sm"><i class="glyphicon glyphicon-remove"></i></a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<nav class="text-center">
				  <ul class="pagination" style="margin-top:0px; margin-bottom:0px;">
				  	<c:if test="${hasPrev == true}">
					<li>
					  <a href='<spring:url value="/books/${curPages - 1}.htm" />' aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					  </a>
					</li>
					</c:if>
					<c:forEach begin="1" end="${totalPages}" step="1" var="x">
					<li><a href='<spring:url value="/books/${x}.htm" />'>${x}</a></li>
					</c:forEach>
					<c:if test="${hasNext == true}">
					<li>
					  <a href='<spring:url value="/books/${curPages + 1}.htm" />' aria-label="Next">
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