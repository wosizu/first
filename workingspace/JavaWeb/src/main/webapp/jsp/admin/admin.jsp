<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page isELIgnored ="false" %>
<!DOCTYPE html>
<html>
<head>
<link href="http://localhost:8080/JavaWeb/css/admin/admin.css" rel="stylesheet" type="text/css" />

<meta charset="utf-8">
<script src="http://localhost:8080/JavaWeb/js/admin/jquery.min.js"></script>
<script src="http://localhost:8080/JavaWeb/js/admin/admin.js"></script>
</head>

		
		
	</head>
	<body>
		<div id="body">
			<div id="header">
				<h1>欢迎来到后台管理系统</h1>
			</div>
			<div id="navigator">
				<ul>
					<li>
						<a>商品管理</a>	
						<ul class="test">
							<li>查询商品</li>
							<li>添加商品</li>
							<li>删除商品</li>
							<li>修改商品</li>
						</ul>
						
					</li>
					
					<li>
						<a>类型管理</a>
						<ul class="test">
							<li>查询商品</li>
							<li>增加类型</li>
							<li>删除类型</li>
							<li>修改类型</li>
						</ul>
					</li>
					
					<li>
						<a>用户管理</a>
						<ul class="test">
							<li>查询用户</li>
							<li>删除用户</li>
							<li>修改用户</li>
							<li>增加用户</li>
						</ul>
					</li>
					
					<li>
						<a>订单管理</a>
						<ul class="test">
							<li>查询订单</li>
							<li>增加订单</li>
							<li>修改订单</li>
							<li>删除订单</li>
						</ul>
					</li>
				
					<li>
						<a>公告管理</a>
						<ul class="test">
							<li>查询公告</li>
							<li>删除公告</li>
							<li>修改公告</li>
							<li>怎加公告</li>
						</ul>
					</li>
				
					<li>
						<a>功能菜单</a>
						<ul class="test">
							<li>退出</li>
							<li>退出</li>
							<li>退出</li>
						</ul>
					</li>
				
					
				</ul>
				</br>
				<table id="table" border="1px"  class="none">

					<tr id="notice">
						<td>
							<form action="http://localhost:8080/JavaWeb/admin/CRUD" method="post">
								<div>
									<input type="text" placeholder="id" name="id"/>
									<input type="text" placeholder="title" name="title"/>									
									<div>
										<textarea rows="5" cols="45" name="content" placeholder="content"></textarea>
									</div>
								</div>
								
								<input type="hidden" name="type" value="notice">
								
								<div>
									add:<input type="radio" value="add" name="method"/>
									delete:<input type="radio" value="delete" name="method"/>
									update:<input type="radio" value="update" name="method"/>
									query:<input type="radio" value="query" name="method"/>
								</div>

								<input type="submit" value="提交" />
								
							</form>
						</td>
					</tr>	
					
					<tr id="goods">
						<td>
							<form action="http://localhost:8080/JavaWeb/admin/CRUD" method="post" enctype="multipart/form-data">
								<div>
									<input type="text" placeholder="id" name="id"/>
									<input type="text" placeholder="name" name="name"/>
									<input type="text" placeholder="price" name="price"/>
									<input type="text" placeholder="store" name="store"/>
									<input type="file" placeholder="picture" name="picture" >
									<input type="text" placeholder="goodstype_id" name="goodstype_id">
								</div>
								
								<input type="hidden" name="type" value="goods"/> 
								
								<div>
									add:<input type="radio" value="add" name="method"/>
									delete:<input type="radio" value="delete" name="method"/>
									update:<input type="radio" value="update" name="method"/>
									query:<input type="radio" value="query" name="method"/>
								</div>
								
								
								<input type="submit" value="提交"/>
							</form>
						</td>
					</tr>
					
					
					<tr id="order">
						
						<td>
							<form action="http://localhost:8080/JavaWeb/admin/CRUD" method="post">
								<div>
									<input type="text" placeholder="id" name="id"/>
									<input type="text" placeholder="usertable_id" name="usertable_id" />
									<input type="text" placeholder="amount" name="amount"/>
									<input type="text" placeholder="status" name="status" />
									
								</div>
								
								<input type="hidden" name="type" value="order">
								
								<div>
									add:<input type="radio" value="add" name="method"/>
									delete:<input type="radio" value="delete" name="method"/>
									update:<input type="radio" value="update" name="method"/>
									query:<input type="radio" value="query" name="method"/>
								</div>
								
								
								<input type="submit" value="提交"/>
							</form>
						</td>
					</tr>	
					
					<tr id="user">
						<td>
							<form action="http://localhost:8080/JavaWeb/admin/CRUD" method="post">
								<div>
									<input type="text" placeholder="id" name="id"/>
									<input type="text" placeholder="name" name="name"/>
									<input type="text" placeholder="password" name="password"/>
									
								</div>
								
								<input type="hidden" name="type" value="user">
								
								<div>
									add:<input type="radio" value="add" name="method"/>
									delete:<input type="radio" value="delete" name="method"/>
									update:<input type="radio" value="update" name="method"/>
									query:<input type="radio" value="query" name="method"/>
								</div>
								
								<input type="submit" value="提交"/>
							</form>
						</td>
					</tr>	
					
					<tr id="type">
						
						<td>
							<form action="http://localhost:8080/JavaWeb/admin/CRUD" method="post">
								<div>
									<input type="text" placeholder="id" name="id" />
									<input type="text" placeholder="typename" name="typename"/>
								</div>
								
								<input type="hidden" name="type" value="type">
								
								<div>
									add:<input type="radio" value="add" name="method"/>
									delete:<input type="radio" value="delete" name="method"/>
									update:<input type="radio" value="update" name="method"/>
									query:<input type="radio" value="query" name="method"/>
								</div>
								
								
								<input type="submit" value="提交"/>
							</form>
						</td>
					</tr>	
					
					<tr  id="out">
						<td>
							<form action="http://localhost:8080/JavaWeb/admin" method="post">
								
								<input type="hidden" name="out" value="true">
								
								
								
								<input type="submit" value="确认"/>
							</form>
						</td>
					</tr>
						
					
				</table>
				
				
			</div>
		</div>
	</body>
	
	
	
	
	
</html>

</html>