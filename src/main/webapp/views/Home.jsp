<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Home Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="" class="navbar-brand">Home</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="LoginController" class="nav-link"> ${checkLogin}</a></li>
				<li><a href="" class="nav-link"> ${sessionScope.fullname} </a></li>
				<li><a href="LogoutController" class="nav-link"> ${sessionScope.kt} </a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List Product</h3>
			<hr>
			<div class="container text-left">
				<c:if test="${sessionScope.login == 1}">
				<a href="HomeController?work=add" class="btn btn-success">Add New Product</a>
				</c:if>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<td>Name</td>
						<td>Price</td>
						<td>Classify</td>
						<td>Picture</td>
						<td colspan="2">#</td>
					</tr>
				</thead>
				<c:forEach items="${listProduct }" var="l" >
					<tr>
						<td>${l.name }</td>
						<td>${l.price }</td>
						<td>${l.classify }</td>
						<td>${l.picture }</td>
						<c:if test="${sessionScope.login == 1}">
							<td><a href="HomeController?work=edit&id=${l.id }" >Edit</a></td>
							<td><a href="HomeController?page=${page }&work=delete&id=${l.id }" >Delete</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
			
			<ul class="pagination">
			<c:if test="${page ==1 }">
				<li class="disabled"><a href=""> &lt;&lt; </a></li>
			    <li><a class="button" href="HomeController?page=1">1</a></li>
			    <li><a href="HomeController?page=2">2</a></li>
			    <li><a href="HomeController?page=3">3</a></li>
			    <li><a href="HomeController?page=${page +1 }"> &gt;&gt; </a></li>
			 </c:if>
			 <c:if test="${page == maxPage }">
				<li><a href="HomeController?page=${page -1 }">&lt;&lt; </a></li>
			    <li><a href="HomeController?page=1">1</a></li>
			    <li><a href="HomeController?page=2">2</a></li>
			    <li><a href="HomeController?page=3">3</a></li>
			    <li class="disabled"><a href=""> &gt;&gt; </a></li>
			 </c:if>
			 <c:if test="${page >1 && page< maxPage }">
				<li><a href="HomeController?page=${page -1 }">&lt;&lt; </a></li>
			    <li><a href="HomeController?page=1">1</a></li>
			    <li><a href="HomeController?page=2">2</a></li>
			    <li><a href="HomeController?page=3">3</a></li>
			    <li><a href="HomeController?page=${page +1 }"> &gt;&gt; </a></li>
			 </c:if>
			 <c:if test="${page > maxPage }">
				<li><a href="HomeController?page=${page -1 }">&lt;&lt; </a></li>
			 </c:if>
	  		</ul>
			
		</div>
	</div>
</body>
</html>