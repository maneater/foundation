<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@include file="common.jsp" %>
<html>
<head>
    <title>Login</title>
    <link href="${appPath}/view/resourse/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <c:if test="${!empty result}">
        ${result.msg}
    </c:if>
    <form action="${appPath}/user/login" method="post">
        <div class="form-group">
            <label for="userName" class="control-label">UserName</label>
            <input type="text" name="userName" id="userName" class="form-control">
        </div>
        <div class="form-group">
            <label for="password" class="control-label">Password</label>
            <input type="password" name="password" id="password" class="form-control">
        </div>

        <button type="submit" class="form-control btn btn-default ">Submit</button>

    </form>
    <a href="${appPath}/user/register">register</a>
</div>

</body>
</html>
