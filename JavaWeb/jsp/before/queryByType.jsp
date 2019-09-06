<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<form action="http://localhost:8080/JavaWeb/before" method="get">
						第<select name="pages">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
						</select>页
						<input type="submit" value="确定"/>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">1</div>
				<div class="col-md-2">2</div>
				<div class="col-md-2">3</div>
				<div class="col-md-2">4</div>
				<div class="col-md-2">5</div>
				<div class="col-md-2">6</div>
			</div>
		</div>

</body>
</html>