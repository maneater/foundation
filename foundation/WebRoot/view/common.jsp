<%@ page import="com.maneater.foundation.Config" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="appName" value="foundation"/>
<c:set var="appPath" value="${pageContext.request.contextPath}"/>
<%
    if (session != null) {
        request.setAttribute("sessionUser", session.getAttribute(Config.SESSION_KEY_USER));
    }
%>