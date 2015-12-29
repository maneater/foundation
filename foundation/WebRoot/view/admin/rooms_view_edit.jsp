<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@include file="common.jsp" %>

<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <title>${appName}</title>
	    <!-- Bootstrap core CSS -->
	    <link href="${appPath}/view/resourse/css/bootstrap.min.css" rel="stylesheet">
	    <!-- Custom styles for this template -->
	    <link href="${appPath}/view/admin/css/index.css" rel="stylesheet">
	    <style type="text/css">
	        td {
	            vertical-align: middle;
	        }
	        .hostListDiv {
				width: 180px;
				position: absolute;
				min-height: 600px;
				top: 57px;
				right: 0px;
				background: rgba(0,0,0,0.5);
				margin-top: 0px;
			}
			.hostListDiv .hostListItemDiv {
				width: 140px;
				margin: 15px auto;
				background-color: #fafafa;
				padding: 5px;
			}
			
			.hostListDiv .hostListItemDiv p {
				line-height: 20px;
				padding: 5px;
				color: #999
			}
			
			.hostListItemDiv table {
				margin-bottom: 5px;
			}
			
			.hostListItemDiv table td {
				font-size: 12px;
			}
			#safetyInfoListDiv .safetyInfoItem {
				text-align: center;
				width: auto;
				height: auto;
				margin: 0px;
				padding: 0px;
			}
			
			#safetyInfoListDiv .safetyInfoItem img {
				width: auto;
			}
			
			.popover td {
				font-size: 15px;
			}
			
			.safetyMapItemRight {
				text-align: center;
				position: absolute;
				top: 10px;
				left: 1000px;
				float: left;
			}	
			.clearfix:after {
				content: "\200B";
				display: block;
				height: 0;
				clear: both;
				overflow: hidden;
				visibility: hidden;
			}		
	    </style>
		<script src="${appPath}/view/resourse/js/jquery.min.js"></script>
		<script src="${appPath}/view/resourse/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${appPath}/view/resourse/js/jquery-ui-1.10.3.custom.min.js" ></script>
		<script src="${appPath}/view/admin/js/submit.js"></script>
		<script src="${appPath}/view/admin/js/room_view_edit.js"></script>
		<script type="text/javascript" charset="utf-8">
			$(function(){
				roomViewFurnitureList = new Array();
				$("#safetyMapsIsGrid").change(function(){
					if($(this).prop("checked")) {
						$("#safety_maps_grid").show();
					} else {
						$("#safety_maps_grid").hide();
					}
				});
				$("#safetyMapShowHostBtn").click(function(){
					if($("#safetyMapHostListDiv").css("display") != "none") {
						$("#safetyMapShowHostBtn").val("Show Furniture");
						$("#safetyMapHostListDiv").hide("slide", {direction: "right"}, 500);
					} else {
						$("#safetyMapShowHostBtn").val("Hidden Furniture");
						$("#safetyMapHostListDiv").show("slide", {direction: "right"}, 500);
					}
				});
				$("#containment_wrapper_bg_img").attr("src", "${appPath}/upload/room/empty room.jpg");
				$("#containment_wrapper_bg_img").load(function(){
					$("#viewContentDiv").width($("#containment_wrapper_bg_img").width());
					$("#safety_maps_grid").attr("height", $("#containment_wrapper_bg_img").height());
					$("#safety_maps_grid").attr("width", $("#containment_wrapper_bg_img").width());
					
					$("#safetyMapHostListDiv").height($("#containment_wrapper_bg_img").height());
					
					$("#containment-wrapper").width($("#containment_wrapper_bg_img").width());
					$("#containment-wrapper").height($("#containment_wrapper_bg_img").height());
					canvasMapsUpdate();
				});
				
				$( "#safetyInfoListDiv").find(".draggable").draggable({ containment: "#containment-wrapper", scroll: false });

				$("#btnChooseModel").bind("click", function () {
		            choosePicUrl = false;
		            $("#chooseTitle").html("Choose Model File");
		            $("#iframe").attr("src", '${appPath}/admin/upload?fileType=sh3d&filePath=${dirRoomModel}');
		            $("#chooseModal").modal('show');
		            <%--$("#chooseContent").load("${appPath}/admin/upload", function () {--%>
		            <%--});--%>
		        });
		        $("#btnChoosePicture").bind("click", function () {
		            $("#chooseTitle").html("Choose Model Picture");
		            choosePicUrl = true;
		            $("#iframe").attr("src", '${appPath}/admin/upload?fileType=img&filePath=${dirRoom}');
		            $("#chooseModal").modal('show');
		            <%--$("#chooseContent").load("${appPath}/admin/upload", function () {--%>
		            <%--});--%>
		        });
			});
			/*
				更新网格
			*/
			function canvasMapsUpdate() {
				var c_canvas=document.getElementById("safety_maps_grid");
				var c_canvas_width = $("#containment_wrapper_bg").width();
				var c_canvas_height = $("#containment_wrapper_bg").height();
				var context=c_canvas.getContext("2d");
				for(var x=0.5;x<c_canvas_width;x+=50){                     
					context.moveTo(x,0);                            
					context.lineTo(x, c_canvas_height);
				}
				for (var y=0.5;y<c_canvas_height;y+=50){
					context.moveTo(0,y);
					context.lineTo(c_canvas_width, y);
				}
				context.strokeStyle="#dedede";                        
				context.stroke();
			}

			function roomViewEditBackFun() {
				window.location.href="index";
			}	

		    var appPath = '${appPath}';
		    var choosePicUrl = false;
		    function useUpload(filePath) {
		        $("#chooseModal").modal('hide');
		        if (choosePicUrl) {
		        	$("#containment_wrapper_bg_img").attr("src", appPath + "/upload/" + filePath);
		            $("#itemPicUrl").val(filePath);
		            $("#choosePictureModal").modal('hide');
		        } else {
		            $("#itemModelPath").val(filePath);
		        }
		    }
		</script>
		<link rel="shortcut icon" href="/favicon.ico" />
		<link rel="apple-touch-icon" href="/apple-touch-icon.png" />
	</head>
	<%@include file="topnavi.jsp" %>
	<body>
		<div class="container-fluid">
		    <div class="row">
		        <%@include file="leftmenu.jsp" %>
		    </div>
		    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            	<h1 class="page-header">Room View</h1>
            	<!-- 内容区域 -->
				<div class="mainBodyDiv clearfix">
					<!-- 内容区域 -->
					<div class="bodyContentDiv" style="width: 1000px;">
						<div class="viewContentDiv" style="background: #999999; padding-top: 10px; width: 1000px; position: relative;">
							<form id="jvSafetyMapAddForm" class=" mt10" action="safety_map/o_save.do">
								<input type="hidden" name="roomId" id="roomViewEditId" value="${graphRoom.id }" />
								<div style="position: relative">
									<span style="margin-left: 20px">
										<input class="btn btn-primary" style="margin-bottom: 10px;" type="button" id="btnChoosePicture" value="Update Room Image" />
									</span>
									<!-- 是否显示网格 -->
									<span style="margin-left: 20px">
										<label><input id="safetyMapsIsGrid" type="checkbox" checked="checked" /> 显示网格</label>
									</span>
									<span style="margin-left: 220px">
										<input class="btn btn-primary" style="margin-bottom: 10px;" type="button" onclick="roomViewEditBackFun()" value="Back" />
										&nbsp;
										<input class="btn btn-primary" style="margin-bottom: 10px;" type="button" onclick="saveViewFurnitureFun()" value="Save" />
									</span>
									<!-- 隐藏主机 -->
									<input class="btn btn-primary" style="margin-bottom: 10px; position: absolute; right: 10px;" id="safetyMapShowHostBtn" type="button" value="Hidden Furniture" />
								</div>
								<div style="position: relative; width: 1000px; overflow-x: auto; ">
									<div id="containment-wrapper" style="position: relative; height: auto; width: auto; border: 2px solid #ccc; min-height: 600px;">
										<div id="containment_wrapper_bg" style="width: 100%; background-size: 100%, 100%; position: relative">
											<img id="containment_wrapper_bg_img" src="${appPath}/upload/room/empty room.jpg" style="position: relative;" />
											<!-- 绘制网格 -->
											<canvas id="safety_maps_grid" height="600" width="1000" style="position: absolute; top: 0px; left: 0px"></canvas>  
											<script type="text/javascript">
												var c_canvas=document.getElementById("safety_maps_grid");
												var c_canvas_width = $("#containment_wrapper_bg").width();
												var c_canvas_height = $("#containment_wrapper_bg").height();
												var context=c_canvas.getContext("2d");
												for(var x=0.5;x<c_canvas_width;x+=50){                     
												 context.moveTo(x,0);                            
												 context.lineTo(x, c_canvas_height);
												}
												for (var y=0.5;y<c_canvas_height;y+=50){
												context.moveTo(0,y);
												 context.lineTo(c_canvas_width, y);
												}
												context.strokeStyle="#dedede";                        
												context.stroke();
											</script>
										</div>
										<!-- 防区列表 -->
										<div id="safetyInfoListDiv" style="top: 0px; position: absolute;">
											<!-- 冰箱 -->
											<div id="safetyInfo12102" class="draggable ui-draggable safetyInfoItem safetyInfoItemDefault" style="position: absolute; left: 280px; top: 918px;">
												<img src="../res/style/images/test/room/minibar.png">
												<span id="safetyInfo12101span" data-rel="popover" style="position: absolute;" class="icon icon-color icon-comment"></span>
											</div>
										</div>
									</div>
								</div>
								<!-- 家具列表 -->
										<div id="safetyMapHostListDiv" class="hostListDiv box">
											<c:forEach var="item" items="${productCategories}">
												<div class='hostListItemDiv clearfix' id='mapHostItemPanel${item.id }' res_id="${item.id }" res_name="${item.name }" res_icon="${appPath}/${dirUpload}/${item.picUrl }">
													<table class='table table-striped table-bordered'>
													<input type='hidden' id='mapHostItemId${item.id }' value='${item.id }' />
													<tr><td>Name:</td><td><font color="green">${item.name }</font></td></tr>
													<tr><td>Icon:</td><td><img src="${appPath}/${dirUpload}/${item.picUrl }" height="70" width="50" /></td></tr>
													</table>
													<div><a href='javascript:void(0);' class='btn btn-info' onclick="addViewFurnitureFun('mapHostItemPanel${item.id }')">
													<i class='icon-globe icon-blue icon'></i>Add</a>
													<a style='margin-left: 8px;' href='javascript:void(0);' class='btn btn-warning' onclick="deleteViewFurnitureFun('mapHostItemPanel${item.id }')">
													<i class='icon icon-red icon-cross'></i>Delete</a></div>
												</div>
											</c:forEach>
										</div>
							</form>
						</div>
				</div>
			</div>
            <!-- end -->
            </div>
		</div>
		<!-- .modal -->
		<div class="modal fade" id="chooseModal" tabindex="-1" role="dialog" aria-hidden="true">
		    <div class="modal-dialog" style="width: 80%;height: 80%;">
		        <div class="modal-content" id="chooseContent" style="height: 100%;">
		            <div class="modal-body" style="height: 90%;">
		                <h3 id="chooseTitle">Choose Model Picture</h3>
		                <iframe id="iframe" width="100%" height=100%" frameborder="0"></iframe>
		            </div>
		        </div>
		    </div>
		</div>
		<!-- /.modal -->
	</body>
</html>
