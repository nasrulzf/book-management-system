<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
	<div class="col-md-8">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Read Recently</h3>
			</div>
			<div class="panel-body">
				<table class="table table-bordered table-hovered table-striped">
					<thead>
						<tr>
							<th>Date</th>
							<th>Title</th>
							<th>Page</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>27 Aug 2015</td>
							<td>Cara Mudah Belajar</td>
							<td>15</td>
						</tr>
					</tbody>
				</table>
			</div>
		  </div>
	  </div>
	  
	  <div class="col-md-4">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Latest Author</h3>
			</div>
			<div class="panel-body">
				<table class="table table-bordered table-hovered table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listAuthor}" var="author">
						<tr>
							<td>${author.id}</td>
							<td>${author.firstName} ${author.lastName}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	  </div>
  </div>
  
  <div class="row">
	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Latest Book</h3>
			</div>
			<div class="panel-body">
				<table class="table table-bordered table-hovered table-striped">
					<thead>
						<tr>
							<th>ISBN</th>
							<th>Title</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listBook}" var="book">
						<tr>
							<td>${book.isbn}</td>
							<td>${book.title}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		  </div>
	  </div>
	  
	  <div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Latest Publisher</h3>
			</div>
			<div class="panel-body">
				<table class="table table-bordered table-hovered table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Publisher</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listPublisher}" var="publisher">
						<tr>
							<td>${publisher.id}</td>
							<td>${publisher.name}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	  </div>
  </div>