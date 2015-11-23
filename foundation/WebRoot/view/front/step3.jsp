<%@ page import="com.maneater.foundation.uitl.ZipPropertiesUtil" %>
<%@ page import="com.maneater.foundation.entity.GraphModel" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@include file="common.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>
select furniture
<form action="${appPath}/step/step4" method="post">
    <input type="hidden" value="${roomId}" name="roomId"/>
    <table>
        <tr>
            <th>#id</th>
            <th>name</th>
            <th>icon</th>
            <th>category</th>
            <th>action</th>
        </tr>
        <c:forEach items="${furinitureList}" var="item">
            <tr>
                <th>${item.id}</th>
                <th>${item.name}</th>
                <th><img src="<fd:path path="${item.icon}" basePath="${appPath}/${dirUpload}"></fd:path>"/></th>
                <th>${item.categoryName}</th>
                <td><input type="checkbox" name="modelIds" value="${item.id}"></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Next">
</form>

</body>
</html>
