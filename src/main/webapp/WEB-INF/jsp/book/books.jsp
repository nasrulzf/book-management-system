<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
						<tr>
							<td>1</td>
							<td>Cara Mudah Belajar</td>
							<td>Nasrul A Gifari</td>
							<td>ANDI Yogyakarta</td>
							<td>
								<a class="btn btn-danger btn-sm"><i class="glyphicon glyphicon-remove"></i></a>
							</td>
						</tr>
					</tbody>
				</table>
				<nav class="text-center">
				  <ul class="pagination" style="margin-top:0px; margin-bottom:0px;">
					<li>
					  <a href="#" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					  </a>
					</li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li>
					  <a href="#" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					  </a>
					</li>
				  </ul>
				</nav>
			</div>
		  </div>
	  </div>
	  
  </div>