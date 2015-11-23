<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@include file="common.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>
room category
<table style="border: solid red 1px;">
    <tr>
        <th>#id</th>
        <th>name</th>
        <th>info</th>
        <th>pic</th>
        <th>check</th>
    </tr>
    <c:forEach items="${roomCategoryList}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.info}</td>
            <td><img src="<fd:path basePath="${appPath}/${dirUpload}" path="${item.picUrl}"></fd:path>" alt=""/></td>
            <td><a href="${appPath}/step/step2?roomCategoryId=${item.id}">Next</a></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
