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
		<title>Login</title>
		<meta name="description" content="" />
		<meta name="author" content="yifan" />
		
		<meta name="viewport" content="width=device-width; initial-scale=1.0" />
		<!-- 引入 Bootstrap -->
		<link href="${appPath}/view/front/res/plugin/css/bootstrap.css"
			rel="stylesheet">
		<%@include file="../include/head.jsp" %>
		<script src="${appPath}/view/front/res/plugin/js/bootstrap.min.js"></script>
		<link rel="shortcut icon" href="/favicon.ico" />
		<link rel="apple-touch-icon" href="/apple-touch-icon.png" />
	</head>
	<c:set var="title" value="Login"/>
	<c:set var="channelId" value="1"/>
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
							<li class="current">
								<a href="javascript:void(0);">Login</a>
							</li>
							<li>
								<a href="${appPath}/user/register" data-transition="slideup">Sign Up</a>
							</li>
							<li>
								<a href="javascript:void(0);">Contact Us</a>
							</li>
							<li>
								<a href="javascript:void(0);">Terms & Conditions</a>
							</li>
						</ul>
					</div>
					<div class="rightContent">
						<div class="loginDiv">
							<c:if test="${!empty result}">
						        ${result.msg}
						    </c:if>
							<form action="${appPath}/user/login" method="post" style="width: 80%; margin-top: 30px; margin-right: 30px; float: right;">
								<p>
									<label>User Name:</label>
									<input type="text" name="userName" id="userName" placeholder="Email Address" />
								</p>
								<p>
									<label>Password:</label>
									<input type="password" id="password" name="password" placeholder="Password" />
								</p>
								<p class="txtr"><input type="submit" value="Login" /></p>
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
