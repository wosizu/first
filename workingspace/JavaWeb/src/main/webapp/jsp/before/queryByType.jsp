<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page isELIgnored ="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>一锋网</title>
	<link href="http://localhost:8080/JavaWeb/css/before/bootstrap.css"  rel="stylesheet"/>
	<link href="http://localhost:8080/JavaWeb/font/iconfont.css" rel="stylesheet"/>
	
	
	<script src="http://localhost:8080/JavaWeb/js/before/jquery.min.js"></script>
	<script src="http://localhost:8080/JavaWeb/js/before/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<a href="">下一页</a>
			</div>
		</div>
		<div class="row">
			<c:forEach  var="goods" items="${goodsList}" >
				<div class="col-md-3">
					<img class="img-fluid"  src="http://localhost:8080/JavaWeb/img/before/${goods.picture}" />
				</div>
			</c:forEach>
			
		</div>
	</div>
	

</body>
</html>