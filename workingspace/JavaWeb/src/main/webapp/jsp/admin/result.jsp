<%@ page language="java" contentType="text/html; charset=UTF-8" import="com.entity.Goods" import="com.entity.User"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page isELIgnored ="false" %>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<script src="http://localhost:8080/JavaWeb/js/admin/jquery.min.js"></script>
		
		<style>
			#header{
				margin: 0px auto;
				width: 600px;
				height: 100px;
				text-align: center;
				line-height: 100px;
				background-color: lightblue;
				border: 1px solid black;
			}
			#header h1{
				padding: 0px;
				margin: 0px;
			}
			
			#body{
				margin: 0px auto;
				width: 800px;
				height: 500px;
				border: 1px solid red;
			}
			
			table{
				width: 800px;
			}
			
			table tr td{
				width: 160px;
				height: 30px;
			}
		</style>
		
		
		
		<script>
		
			function hide(){
				$("#goods").hide();
				$("#user").hide();
				$("#order").hide();
				$("#notice").hide();
				$("#type").hide();
				$("#changed").hide();
			}
			
			
			$(function(){
				hide();
				
				<c:if test="${type.getClass().getSimpleName().equals('Goods')}">
					$("#goods").show();
					var id=<c:out value="${type.getId()}"/> ;
					var store=<c:out value="${type.getStore()}"/>;
					var price=<c:out value="${type.getPrice()}"/>;
					var name="<c:out value="${type.getName()}"/>" ;
					var picture="<c:out value="${type.getPicture()}"/>" ;
					var goodstype_id="<c:out value="${type.getGoodstype_id()}"/>";
					$("#goods tr:eq(2)").append("<td>"+id);
					$("#goods tr:eq(2)").append("<td>"+name);
					$("#goods tr:eq(2)").append("<td>"+price);
					$("#goods tr:eq(2)").append("<td>"+store);
					$("#goods tr:eq(2)").append("<td>"+picture);
					$("#goods tr:eq(2)").append("<td>"+goodstype_id);
				</c:if>
				
				<c:if test="${type.getClass().getSimpleName().equals('User')}">
					$("#user").show();
					var id=<c:out value="${type.getId()}"/> ;
					var name="<c:out value="${type.getName()}"/>";
					var pwd="<c:out value="${type.getPassword()}"/>";
					
					$("#user tr:eq(2)").append("<td>"+id);
					$("#user tr:eq(2)").append("<td>"+name);
					$("#user tr:eq(2)").append("<td>"+pwd);
				</c:if>
				
				
				<c:if test="${type.getClass().getSimpleName().equals('Order')}">
					$("#order").show();
					var id=<c:out value="${type.getId()}"/>;
					var usertable_id=<c:out value="${type.getUser_id()}"/>;
					
					var amount=<c:out value="${type.getAmount()}"/>;
					var status="<c:out value="${type.getStatus()}"/>";
					var orderDate="<c:out value="${type.getOrderdate()}"/>";
					
					$("#order tr:eq(2)").append("<td>"+id);
					$("#order tr:eq(2)").append("<td>"+usertable_id);
					$("#order tr:eq(2)").append("<td>"+amount);
					$("#order tr:eq(2)").append("<td>"+status);
					$("#order tr:eq(2)").append("<td>"+orderDate);
				</c:if>
				
				
				<c:if test="${type.getClass().getSimpleName().equals('Notice')}">
					$("#notice").show();
					var id=<c:out value="${type.getId()}"/>;
					
					var title="<c:out value="${type.getTitle()}"/>";
					var content="<c:out value="${type.getContent()}"/>";
					var time="<c:out value="${type.getTime()}"/>";
					
					$("#notice tr:eq(2)").append("<td>"+id);
					$("#notice tr:eq(2)").append("<td>"+title);
					$("#notice tr:eq(2)").append("<td>"+content);
					$("#notice tr:eq(2)").append("<td>"+time);
				</c:if>
				
				<c:if test="${type.getClass().getSimpleName().equals('GoodsType')}">
					$("#type").show();
					var id=<c:out value="${type.getId()}"/>;
					
					var typename="<c:out value="${type.getTypename()}"/>";
					
					$("#type tr:eq(2)").append("<td>"+id);
					$("#type tr:eq(2)").append("<td>"+typename);
					
				</c:if>
				
				<c:if test="${!empty changed}">
					hide();
					$("#changed").show();
					var changed=<c:out value="${changed}"/>;
					$("#changed tr:eq(1)").append("<td>受影响行数:"+changed);
				</c:if>
				
				
			})
			
		</script>
		
		
	</head>
	<body>
		
			<div id="header">
				<h1>操作执行结果</h1>
			</div>
			<div id="body">
				
				<table id="goods" border="1px solid black" >
					<tr>
						<td colspan="2"></td>
						<td colspan="2" style="text-align: center;">goods查询结果</td>
					</tr>
					<tr align="center">
						<td>id</td>
						<td>name</td>
						<td>price</td>
						<td>store</td>
						<td>picture</td>
						<td>goodstable_id</td>
					</tr>
					<tr>
						
					</tr>
					<tr>&nbsp;</tr>
				</table>
				
				<table id="order" border="1px solid black">
					<tr>
						<td colspan="2"></td>
						<td colspan="2" style="text-align: center;">order查询结果</td>
					</tr>
					<tr align="center">
						<td>id</td>
						<td>usertable_id</td>
						<td>amount</td>
						<td>status</td>
						<td>orderdate</td>
						<td></td>
					</tr>
					<tr></tr>
					<tr>&nbsp;</tr>
				</table>
				
				<table id="user" border="1px solid black">
					<tr>
						<td colspan="2"></td>
						<td colspan="2" style="text-align: center;">user查询结果</td>
					</tr>
					<tr align="center">
						<td>id</td>
						<td>name</td>
						<td>pwd</td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr></tr>
					<tr>&nbsp;</tr>
				</table>
				
				<table id="type" border="1px solid black">
					<tr>
						<td colspan="2"></td>
						<td colspan="2" style="text-align: center;">type查询结果</td>
					</tr>
					<tr align="center">
						<td>id</td>
						<td>typename</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr></tr>
					<tr>&nbsp;</tr>
				</table>
				
				<table id="notice" border="1px solid black">
					<tr>
						<td colspan="2"></td>
						<td colspan="2" style="text-align: center;">notice查询结果</td>
					</tr>
					<tr align="center">
						<td>id</td>
						<td>title</td>
						<td>content</td>
						<td>time</td>
						<td></td>
						<td></td>
					</tr>
					<tr></tr>
					<tr>&nbsp;</tr>
				</table>
				
				
				<table id="changed" border="1px solid black" >
					<tr>
						
						<td colspan="2" style="text-align: center;">结果</td>
					</tr>
					<tr>
						
					</tr>
				</table>
				
				
			</div>
	
	
</body>
</html>