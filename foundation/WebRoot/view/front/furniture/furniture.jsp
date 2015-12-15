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
		<!-- 家具-->
		<title>Furniture</title>
		<meta name="description" content="" />
		<meta name="author" content="yifan" />
		<%@include file="../include/head.jsp" %>
		<meta name="viewport" content="width=device-width; initial-scale=1.0" />

		<link rel="shortcut icon" href="/favicon.ico" />
		<link rel="apple-touch-icon" href="/apple-touch-icon.png" />
	</head>
	<c:set var="title" value="Furniture"/>
	<c:set var="channelId" value="3"/>
	<body>
		<div class="contentDiv">
			<!-- head -->
			<%@include file="../include/top.jsp" %>
			<!-- body -->
			<div class="mainBodyDiv clearfix">
				<!-- 内容区域的导航条 -->
				<div class="bodyNavDiv">
					<ul>
						<li>
							<a href="javascript:void(0);">Home</a>
						</li>
						<li>
							<a href="javascript:void(0);">New Arrival</a>
						</li>
						<li class="current">
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
							<c:forEach var="item" items="${categories}">
							<li <c:if test="${item.id==categoryId}"> class="current" </c:if> >
								<a href="${appPath}/front/furniture/index?categoryId=${item.id}">${item.name }</a>
							</li>
							</c:forEach>
						</ul>
					</div>
					<div class="rightContent">
						<div class="furnitureListDiv">
							<form>
								<c:forEach var="item" items="${itemList}">
								<div class="item" res_id="${item.id}" title="${item.name}">
									<img src="${appPath}/${dirUpload}/${item.thumbnailPicture}" style="margin: 0px 20px 0px 20px; width: 120px;" />
									<div class="content clearfix">
										<h2>${item.code }</h2>
										<label>${item.name }</label>
										<span>${item.info }</span>
										<span class="hr fr"></span>
									</div>
									<div class="moreRight">
										<h2>US$${item.price }</h2>
										<a href="${appPath}/front/furniture/detail?id=${item.id}" res_id="${item.id}">
											<span>See More</span>
										</a>
									</div>
								</div>
								</c:forEach>
							</form>
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
