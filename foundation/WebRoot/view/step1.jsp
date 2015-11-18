<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@include file="common.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>

<table style="border: solid red 1px;">
    <tr >
        <th>#id</th>
        <th>name</th>
        <th>info</th>
        <th>check</th>
    </tr>
    <c:forEach items="${itemList}" var="item">
        <tr>
            <th>${item.id}</th>
            <th>${item.name}</th>
            <th>${item.info}</th>
            <th><a href="${appPath}/step/step2?supplierId=${item.id}">Next</a></th>
        </tr>
    </c:forEach>
</table>


</body>
</html>
