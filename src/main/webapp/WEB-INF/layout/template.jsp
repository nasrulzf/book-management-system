<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>

<tilesx:useAttribute name="current"/>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Navbar Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href='<spring:url value="/style/css/bootstrap.min.css" />' rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href='<spring:url value="/style/css/navbar.css" />' rel="stylesheet">

    <script src='<spring:url value="/style/js/ie-emulation-modes-warning.js" />'></script>

  </head>

  <body>

    <div class="container" style="width:800px;">

      <!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand text-center" href="#" style="font-size:.9em; padding:3px 10px; font-weight:bold;">{ BMS } <br><small>Book Management System</small></a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="${current == 'index' ? 'active' : ''}"><a href='<spring:url value="/index.htm" />'>Home</a></li>
			  <li class="dropdown ${current == 'master' ? 'active' : ''}">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Master <span class="caret"></span></a>
                <ul class="dropdown-menu">
				  <li><a href='<spring:url value="/categories.htm" />'>Category</a></li>
                  <li><a href="#">Book</a></li>
                  <li><a href="<spring:url value="/publishers.htm" />">Publisher</a></li>
                  <li><a href="<spring:url value="/author.htm" />">Author</a></li>
                </ul>
              </li>
              <li class="${current == 'read' ? 'active' : ''}"><a href="#">Read</a></li>
              <li class="${current == 'report' ? 'active' : ''}"><a href="#">Report</a></li>
              
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="./">About</a></li>
			  <li><a href="./">Help</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>

      <!-- Main component for a primary marketing message or call to action -->
      
      <tiles:insertAttribute name="body" />

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src='<spring:url value="/style/js/jquery.min.js" />'></script>
    <script src='<spring:url value="/style/js/bootstrap.min.js" />'></script>
    <script type="text/javascript">
	  	$(document).ready(function(){
	  		$('#add').on('click', function(e){
	  			e.preventDefault;
	  			$('#form.c').html("<h4 class='text-center'>Loading</h4>");
	  
	  	  		$.ajax({
	  	  			url : '<spring:url value="/categories/form.htm" />',
	  	  			type : 'GET',
	  	  			dataType : 'html'
	  	  		}).done(function(e){
	  	  			$('#form-c').html(e);
	  	  		});
	  	  		
	  	  	});
	  		$('.link-c').on('click', function(e){
	  			e.preventDefault;
	  			$('#form.c').html("<h4 class='text-center'>Loading</h4>");
	  			
	  	  		var id = $(this).data("id");
	  	  		$.ajax({
	  	  			url : '<spring:url value="/categories/form/" />' + id + '.htm',
	  	  			type : 'GET',
	  	  			dataType : 'html'
	  	  		}).done(function(e){
	  	  			$('#form-c').html(e);
	  	  		});
	  	  		
	  	  	});
	  		$('#add-author').on('click', function(e){
	  	  		e.preventDefault;
	  	  		$('#form.c').html("<h4 class='text-center'>Loading</h4>");
	  	  	
	  	  		$.ajax({
	  	  			url : '<spring:url value="/author/form.htm" />',
	  	  			type : 'GET',
	  	  			dataType : 'html'
	  	  		}).done(function(e){
	  	  			$('#form-c').html(e);
	  	  		});
	  	  		
	  	  	});
	  		$('.link-a').on('click', function(e){
	  	  		e.preventDefault;
	  	  		$('#form.c').html("<h4 class='text-center'>Loading</h4>");
	  	  	
	  	  		var id = $(this).data("id");
	  	  		$.ajax({
	  	  			url : '<spring:url value="/author/form/" />' + id + '.htm',
	  	  			type : 'GET',
	  	  			dataType : 'html'
	  	  		}).done(function(e){
	  	  			$('#form-c').html(e);
	  	  		});
	  	  		
	  	  	});
	  		$('#add-publisher').on('click', function(e){
	  	  		e.preventDefault;
		  	  	$('#form.c').html("<h4 class='text-center'>Loading</h4>");
	  	  		
	  	  		$.ajax({
	  	  			url : '<spring:url value="/publisher/form.htm" />',
	  	  			type : 'GET',
	  	  			dataType : 'html'
	  	  		}).done(function(e){
	  	  			$('#form-c').html(e);
	  	  		});
	  	  		
	  	  	});
	  		$('.link-p').on('click', function(e){
	  	  		e.preventDefault;
		  	  	$('#form.c').html("<h4 class='text-center'>Loading</h4>");
	  	  		
	  	  		var id = $(this).data("id");
	  	  		$.ajax({
	  	  			url : '<spring:url value="/publisher/form/" />' + id + '.htm',
	  	  			type : 'GET',
	  	  			dataType : 'html'
	  	  		}).done(function(e){
	  	  			$('#form-c').html(e);
	  	  		});
	  	  		
	  	  	});
	  	});
	  	
	  </script>
  </body>
</html>
