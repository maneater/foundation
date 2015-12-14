<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="col-sm-3 col-md-2 sidebar">

    <ul class="nav nav-sidebar">
        <li class="${act eq 'index' ? "active":""}"><a href="${appPath}/admin/index">Overview</a></li>
        <li class="${act eq 'users' ? "active":""}"><a href="${appPath}/admin/users/index">Users</a></li>
    </ul>

    <ul class="nav nav-sidebar">
        <li class="${act eq 'room' ? "active":""}"><a href="${appPath}/admin/room/index">Room</a></li>
        <li class="${act eq 'roomcate' ? "active":""}"><a href="${appPath}/admin/room/cate">Room Category</a></li>
    </ul>

    <ul class="nav nav-sidebar">
        <li class="${act eq 'furniture' ? "active":""}"><a href="${appPath}/admin/furniture/index">Furniture</a></li>
        <li class="${act eq 'furnitureCate' ? "active":""}"><a href="${appPath}/admin/furniture/cate">Furniture Category</a></li>
    </ul>


    <ul class="nav nav-sidebar">
        <li class="${act eq 'order' ? "active":""}"><a href="${appPath}/admin/order/">Order List</a></li>
    </ul>

    <ul class="nav nav-sidebar">
        <li><a href="">Exit</a></li>
    </ul>
</div>