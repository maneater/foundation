<%@ page import="com.maneater.foundation.uitl.ZipPropertiesUtil" %>
<%@ page import="com.maneater.foundation.entity.Product" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@include file="common.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>
select room
<table>
    <tr>
        <th>#id</th>
        <th>name</th>
        <th>icon</th>
        <th>category</th>
        <th>action</th>
    </tr>
    <c:forEach items="${rooList}" var="item">
        <tr>
            <th>${item.id}</th>
            <th>${item.name}</th>
            <th><img src="<fd:path path="${item.picUrl}" basePath="${appPath}/${dirUpload}"></fd:path>"/></th>
            <th>${item.categoryName}</th>
            <td><a href="${appPath}/step/step3?roomId=${item.id}">Next</a></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
