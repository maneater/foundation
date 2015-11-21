<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@include file="common.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>
    <link href="${appPath}/view/resourse/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container">

    <c:forEach items="${itemList}" var="item">
        ${item.filePath} ---- ${item.fileName}
        <br/>
    </c:forEach>
</div>
<script src="${appPath}/view/resourse/js/jquery.min.js"></script>
</body>
</html>