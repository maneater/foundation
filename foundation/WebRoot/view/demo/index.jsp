<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Bootstrap 101 Template</title>
<!-- Bootstrap -->
<link href="../resourse/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<h1>你好，世界！</h1>

	<button type="button" class="btn btn-default btn-sm"
		aria-label="Left Align">
		<span class="glyphicon glyphicon-align-left" aria-hidden="true"></span>
	</button>

	<button type="button" class="btn btn-default btn-sm">
		<span class="glyphicon glyphicon-star" aria-hidden="true"></span> Star
	</button>


	<form>
		<div class="form-group">
			<label for="exampleInputEmail1">Email address</label> <input
				type="email" class="form-control" id="exampleInputEmail1"
				placeholder="Enter email">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Password</label> <input
				type="password" class="form-control" id="exampleInputPassword1"
				placeholder="Password">
		</div>
		<div class="form-group">
			<label for="exampleInputFile">File input</label> <input type="file"
				id="exampleInputFile">
			<p class="help-block">Example block-level help text here.</p>
		</div>
		<div class="checkbox">
			<label> <input type="checkbox"> Check me out
			</label>
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>

	<form class="form-inline">
		<div class="form-group">
			<label for="exampleInputName2">Name</label> <input type="text"
				class="form-control" id="exampleInputName2" placeholder="Jane Doe">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail2">Email</label> <input type="email"
				class="form-control" id="exampleInputEmail2"
				placeholder="jane.doe@example.com">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail2">Email</label> <input type="email"
				class="form-control" id="exampleInputEmail2"
				placeholder="jane.doe@example.com">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail2">Email</label> <input type="email"
				class="form-control" id="exampleInputEmail2"
				placeholder="jane.doe@example.com">
		</div>
		<button type="submit" class="btn btn-default">Send invitation</button>
	</form>


	<form class="form-horizontal">
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="inputEmail3"
					placeholder="Email">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="inputPassword3"
					placeholder="Password">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<div class="checkbox">
					<label> <input type="checkbox"> Remember me
					</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Sign in</button>
			</div>
		</div>
	</form>

	<div class="alert alert-warning alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<strong>Warning!</strong> Better check yourself, you're not looking
		too good.
	</div>

	<div class="progress">
		<div class="progress-bar progress-bar-striped active"
			role="progressbar" aria-valuenow="45" aria-valuemin="0"
			aria-valuemax="100" style="width: 45%">
			<span class="sr-only">45% Complete</span>
		</div>
	</div>

	<ul class="list-group">
		<li class="list-group-item">Cras justo odio</li>
		<li class="list-group-item">Dapibus ac facilisis in</li>
		<li class="list-group-item">Morbi leo risus</li>
		<li class="list-group-item">Porta ac consectetur ac</li>
		<li class="list-group-item">Vestibulum at eros</li>
	</ul>
	
	<input type="date" class="form-control" placeholder="Text input">

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../resourse/js/bootstrap.min.js"></script>
</body>
</html>