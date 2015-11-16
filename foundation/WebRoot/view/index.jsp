<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@include file="common.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Index</title>
    <link href="${appPath}/resourse/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="jumbotron">
    <div class="container">
        <h1>Hello, world!</h1>

        <p>${isOpen}</p>

        <c:choose>
            <c:when test="${empty sessionUser}">
                <p><a class="btn btn-primary btn-lg" href="${appPath}/user/login" role="button">Login</a></p>
            </c:when>
            <c:otherwise>
                <p><a class="btn btn-primary btn-lg" href="${appPath}/user/logout" role="button">Logout</a></p>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<!-- /container -->
</body>
</html>