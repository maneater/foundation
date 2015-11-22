<%@ page import="com.maneater.foundation.Config" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    request.setAttribute("appName", Config.APP_NAME);
    request.setAttribute("dirUpload", Config.FILE_UPLOAD_DIR_NAME);

    request.setAttribute("dirRoom", Config.FILE_PATH_ROOM);
    request.setAttribute("dirRoomModel", Config.FILE_PATH_ROOM + "/" + Config.FILE_PATH_ROOM_MODEL);
    request.setAttribute("dirRoomCatePic", Config.FILE_PATH_ROOM + "/" + Config.FILE_PATH_ROOM_CATE_PIC);

    request.setAttribute("dirFurniture", Config.FILE_PATH_FURNITURE);
    request.setAttribute("dirFurnitureModel", Config.FILE_PATH_FURNITURE + "/" + Config.FILE_PATH_FURNITURE_MODEL);
    request.setAttribute("dirFurnitureCatePic", Config.FILE_PATH_FURNITURE + "/" + Config.FILE_PATH_FURNITURE_CATE_PIC);
%>
<c:set var="appPath" value="${pageContext.request.contextPath}"/>

<c:set var="appName" value="${appName}"/>
<c:set var="dirUpload" value="${dirUpload}"/>

<c:set var="dirRoom" value="${dirRoom}"/>
<c:set var="dirRoomModel" value="${dirRoomModel}"/>
<c:set var="dirRoomCatePic" value="${dirRoomCatePic}"/>

<c:set var="dirFurniture" value="${dirFurniture}"/>
<c:set var="dirFurnitureModel" value="${dirFurnitureModel}"/>
<c:set var="dirFurnitureCatePic" value="${dirFurnitureCatePic}"/>
