<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@include file="common.jsp" %>

<html>
<head>
    <link href="${appPath}/view/resourse/css/bootstrap.min.css" rel="stylesheet">
    <link href="${appPath}/view/admin/css/index.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <c:forEach items="${itemList}" var="item" varStatus="status">

        <c:if test="${status.index%3==0}">

        </c:if>

    </c:forEach>
    <div class="row">
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img src="..." alt="...">
            </a>
        </div>
    </div>
</div>

</body>
<script src="${appPath}/view/resourse/js/jquery.min.js"></script>
<script src="${appPath}/view/resourse/js/bootstrap.min.js"></script>
</html>
