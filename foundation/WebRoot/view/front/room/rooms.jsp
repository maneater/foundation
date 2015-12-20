<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@include file="../common.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />

		<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
		Remove this if you use the .htaccess -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<!-- 样板房 -->
		<title>Sample Room</title>
		<meta name="description" content="" />
		<meta name="author" content="yifan" />
		
		<%@include file="../include/head.jsp" %>

		<link rel="shortcut icon" href="/favicon.ico" />
		<link rel="apple-touch-icon" href="/apple-touch-icon.png" />
	</head>
	<c:set var="title" value="Room"/>
	<c:set var="channelId" value="2"/>
	<body>
		<div class="contentDiv">
			<!-- head -->
			<%@include file="../include/top.jsp" %>
			<!-- body -->
			<div class="mainBodyDiv clearfix">
				<!-- 内容区域的导航条 -->
				<div class="bodyNavDiv">
					<ul>
						<li class="current">
							<a href="javascript:void(0);">Home</a>
						</li>
						<li>
							<a href="javascript:void(0);">New Arrival</a>
						</li>
						<li>
							<a href="javascript:void(0);">Catalog</a>
						</li>
						<li>
							<a href="javascript:void(0);">Contact Us</a>
						</li>
					</ul>
				</div>
				<!-- 内容区域 -->
				<div class="bodyContentDiv">
					<div class="leftMenu">
						<ul>
							<li <c:if test="${empty categoryId}"> class="current" </c:if> >
								<a href="${appPath}/front/room/index">Rooms</a>
							</li>
							<c:forEach var="item" items="${categories}">
							<li <c:if test="${item.id==categoryId}"> class="current" </c:if> >
								<a href="${appPath}/front/room/index?categoryId=${item.id}">${item.name }</a>
							</li>
							</c:forEach>
						</ul>
					</div>
					<div class="rightContent">
						<div class="imageListDiv ml30">
							<ul>
							<c:forEach var="item" items="${itemList}">
								<li>
									<a href="${appPath}/front/room/detail?id=${item.id}" res_id="${item.id}" title="${item.name}">
									<img src="${appPath}/${dirUpload}/${item.picUrl}" />
									</a>
								</li>
							</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- foot -->
			<div class="mainFootDiv clearfix">
				&nbsp;
			</div>
		</div>
	</body>
</html>
