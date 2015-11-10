<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="col-sm-3 col-md-2 sidebar">

    <ul class="nav nav-sidebar">
        <li class="${act eq 'index' ? "active":""}"><a href="${appPath}/admin/index">Overview</a></li>
        <li class="${act eq 'users' ? "active":""}"><a href="${appPath}/admin/users/index">Users</a></li>
        <li class="${act eq 'product' ? "active":""}"><a href="#">Products</a></li>
        <li class="${act eq 'category' ? "active":""}"><a href="#">Categories</a></li>
        <li class="${act eq 'ad' ? "active":""}"><a href="#">Ads</a></li>
    </ul>
    <ul class="nav nav-sidebar">
        <li class="${act eq 'setting' ? "active":""}"><a href="#">Settings</a></li>
        <li><a href="">Exit</a></li>
    </ul>
</div>