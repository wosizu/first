<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <style>
        .out{
            border: 1px solid red;
            width: 300px;
            height: 400px;
            margin: 0px auto;
        }

        .out img{
            width: 100%;
        }

        .button{
            width: 80px;
            height: 60px;
            margin: 0px auto;
        }
    </style>
</head>
<body>
<div class="out">
    <div><img src="http://localhost:8080/JavaWeb/img/before/${goods.picture}"/></div>
    <div class="button"><a href="http://localhost:8080/JavaWeb/before/order?goodsId=${goods.id}&userId=${user.id}"><button>立即购买</button></a> </div>
</div>


</body>
</html>

