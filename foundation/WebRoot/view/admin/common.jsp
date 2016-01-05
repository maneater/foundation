<%@ page import="com.maneater.foundation.Config" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://foundation/filepath" prefix="fd" %>
<%
    request.setAttribute("appName", Config.APP_NAME);

    //图片目录
    request.setAttribute("dirUpload", Config.FILE_UPLOAD_DIR_NAME);

    //房屋主图
    request.setAttribute("dirRoom", Config.FILE_PATH_ROOM);
    //房屋效果底图
    request.setAttribute("dirRoomEffect", Config.FILE_PATH_ROOM_EFFECT);
    //房屋分类图
    request.setAttribute("dirRoomCatePic", Config.FILE_PATH_ROOM_CATE_PIC);

    //分类
    request.setAttribute("dirFurnitureCatePic", Config.FILE_PATH_FURNITURE_CATE_PIC);
    //详情
    request.setAttribute("dirFurnitureDetail", Config.FILE_PATH_FURNITURE_DETAIL);
    //缩略
    request.setAttribute("dirFurnitureThumbnail", Config.FILE_PATH_FURNITURE_THUMBNAIL);
    //效果
    request.setAttribute("dirFurnitureEffect", Config.FILE_PATH_FURNITURE_EFFECT);
    //属性图
    request.setAttribute("dirFurnitureProperty", Config.FILE_PATH_FURNITURE_PROPERTY_PIC);
%>
<c:set var="appPath" value="${pageContext.request.contextPath}"/>
<c:set var="pathSplit" value="/"/>

<c:set var="appName" value="${appName}"/>
<c:set var="dirUpload" value="${dirUpload}"/>

<c:set var="dirRoom" value="${dirRoom}"/>
<c:set var="dirRoomEffect" value="${dirRoomEffect}"/>
<c:set var="dirRoomCatePic" value="${dirRoomCatePic}"/>

<c:set var="dirFurnitureCatePic" value="${dirFurnitureCatePic}"/>
<c:set var="dirFurnitureDetail" value="${dirFurnitureDetail}"/>
<c:set var="dirFurnitureThumbnail" value="${dirFurnitureThumbnail}"/>
<c:set var="dirFurnitureEffect" value="${dirFurnitureEffect}"/>
<c:set var="dirFurnitureProperty" value="${dirFurnitureProperty}"/>
