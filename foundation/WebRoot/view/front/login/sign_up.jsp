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

		<title>Sign Up</title>
		<meta name="description" content="" />
		<meta name="author" content="yifan" />
		
		<%@include file="../include/head.jsp" %>
		<meta name="viewport" content="width=device-width; initial-scale=1.0" />

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
							<li>
								<a href="${appPath}/user/login">Login</a>
							</li>
							<li class="current">
								<a href="javascript:void(0);">Sign Up</a>
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
							<form action="${appPath}/user/register" method="post">
								<p>
									<label>Name:</label>
									<input type="text" name="name" id="name" placeholder="Email Address" />
								</p>
								<p>
									<label>Email Address:</label>
									<input type="text" name="email" id="email" placeholder="Email Address" />
								</p>
								<p>
									<label>Password:</label>
									<input type="password" name="password" id="password" placeholder="Password" />
								</p>
								<p>
									<label>Confirm Password:</label>
									<input type="password" name="password2" id="password2" placeholder="Password" />
								</p>
								<p>
									<label>Company name:</label>
									<input type="text" name="companyName" id="companyName" placeholder="Company name" />
								</p>
								<p>
									<label>Position:</label>
									<input type="text" name="address" placeholder="Position in the company" />
								</p>
								<p>
									<label>Phone number:</label>
									<input type="text" name="phone" placeholder="Phone contact number" />
								</p>
								<p class="txtr"><input type="submit" value="Sign Up" /></p>
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
