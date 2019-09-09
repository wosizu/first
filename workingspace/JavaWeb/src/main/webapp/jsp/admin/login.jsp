<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<style>
			#container{
				background-color: aqua;
				width: 170px;
				height: 180px;
				border: 1px solid red;
				margin: 0px auto;
				margin-top: 100px;
				border-radius: 30px;
				box-shadow: 2px 4px 5px #333333;
			}
			
			#submit{
				width: 44px;
				height: 24px;
				border: 1px solid black;
				margin: 0px auto;
			}
			
			
			
			
		</style>
	</head>
	<body>
		<div id="container">
			<form action="/JavaWeb/admin" method="post">
				</br>
				<label>&nbsp;用户名:</label>
				<input type="text" style="background-color: aquamarine;" name="auser"/></br>
				<label>&nbsp;密码:</label>
				<input type="password" style="background-color: aquamarine;" name="password"/></br></br>
				<div id="submit">
					<input type="submit" />
				</div>
				
			</form>
		</div>
	</body>
	
	
</html>
