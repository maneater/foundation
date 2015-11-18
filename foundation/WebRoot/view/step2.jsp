<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@include file="common.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="${appPath}/step/step3" METHOD="post">
    <table>
        <tr>
            <th>#id</th>
            <th>name</th>
            <th>icon</th>
            <th>category</th>
            <th>action</th>
        </tr>
        <c:forEach items="${itemList}" var="item">
            <tr>
                <th>${item.id}</th>
                <th>${item.name}</th>
                <th><img src="${item.icon}"/></th>
                <th>${item.category}</th>
                <th>${item.category}</th>
            </tr>
        </c:forEach>
    </table>
</form>


</body>
</html>
