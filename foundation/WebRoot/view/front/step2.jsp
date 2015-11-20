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

<form action="${appPath}/step/step3" method="post">
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
                <th><img
                        src="<%=((GraphModel)pageContext.getAttribute("item")).getIconPath((String)pageContext.getAttribute("appPath"))%> "/>
                </th>
                <th>${item.category}</th>
                <th><input type="checkbox" name="modelIds" value="${item.id}"/></th>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="next"/>
</form>


</body>
</html>
