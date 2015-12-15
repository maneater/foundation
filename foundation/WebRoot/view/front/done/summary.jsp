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

		<title>Summary</title>
		<meta name="description" content="" />
		<meta name="author" content="yifan" />
		<!-- 引入 Bootstrap -->
		<link href="${appPath}/view/front/res/plugin/css/bootstrap.css" rel="stylesheet">
		<%@include file="../include/head.jsp" %>
		<script src="${appPath}/view/front/res/plugin/js/bootstrap.min.js"></script>
		<link rel="shortcut icon" href="/favicon.ico" />
		<link rel="apple-touch-icon" href="/apple-touch-icon.png" />
		<style type="text/css">
			.table-bordered > thead > tr > th, 
			.table-bordered > tbody > tr > th, 
			.table-bordered > tfoot > tr > th, 
			.table-bordered > thead > tr > td, 
			.table-bordered > tbody > tr > td, 
			.table-bordered > tfoot > tr > td{
				border-color: #656576;
			}
		</style>
		<script type="text/javascript">
			$(function() {
				$("#summaryTable").find("input[type='checkbox']").click(function(){
					var checkList = $("#summaryTable").find("input[type='checkbox']");
					var totalSum = 0;
					for(var i=0; i<checkList.length; i++) {
						var checkObj = $(checkList.get(i));
						var checked = checkObj.attr("checked");
						if(checked) {
							var total1 = checkObj.attr("res");
							totalSum += parseFloat(total1);
						}
					}
					$("#grandTotalTh").html("$"+totalSum.toFixed(2));
				});
			});
			function summaryCancel() {
				$("#summaryForm").attr("action", "${appPath}/front/furniture/index");
				$("#summaryForm").submit();
			}
			function summarySubmit() {
				$("#summaryForm").attr("action", "${appPath}/front/product/orderSubmit");
				$("#summaryForm").submit();
			}
		</script>
	</head>

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
							<li class="current">
								<a href="javascript:void(0);">Summary</a>
							</li>
						</ul>
					</div>
					<div class="rightContent">
						<div class="summarySumbitDiv">
							<form id="summaryForm" style="background-color: rgba(255,255,255,0.7);">
							<table id="summaryTable" class="table table-striped table-bordered bootstrap-datatable datatable responsive dataTable">
								<thead>
									<th width="80">No.</th>
									<th width="200" colspan="2">Product</th>
									<th width="120">Code</th>
									<th width="150" colspan="2">Qty/Stock</th>
									<th width="150">Sub Total</th>
								</thead>
								<tbody role="alert" aria-live="polite" aria-relevant="all">
								<c:forEach var="item" items="${order.orderItemList}">
								<tr>
									<td>1</td>
									<td width="120" style="border-right: none;">Bed</td>
									<td width="80" style="border-left: none;"><img src="../res/style/images/test/catalog2.jpg" style="width: 60px;" /></td>
									<td>${item.productCode }</td>
									<td>${item.qyt }</td>
									<td align="center"><input id="summary_check1" res="${item.price }" type="checkbox" checked="checked" /></td>
									<td>$${item.price }</td>
								</tr>
								</c:forEach>
								</tbody>
								<tfoot>
									<th style="text-align: right;" colspan="6">Grand Total</th>
									<th id="grandTotalTh">$${order.totalPrice }</th>
								</tfoot>
							</table>
							<div class="summaryDescDiv">
								<h2>Contact Information (Compulsary to complete this section)</h2>
								<p>
									<label>Name</label>
									<input type="text" />
								</p>
								<p>
									<label>Designation</label>
									<input type="text" />
								</p>
								<p>
									<label>Company</label>
									<input type="text" />
								</p>
								<p>
									<label>Company Address</label>
									<input type="text" />
								</p>
								<p>
									<label>Delivery Address</label>
									<input type="text" />
								</p>
								<p>
									<label>Contact Number</label>
									<input type="text" />
								</p>
								<p>
									<label>Email</label>
									<input type="text" />
								</p>
								<span>Terms and Conditions</span>
								<div class="summaryProtocolTxt">
									Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras nec mattis nisi, et blandit nibh. Morbi eleifend tellus
									non ultrices tempor. Maecenas euismod, magna vel vulputate sodales, dui felis pretium nibh, quis laoreet nibh
									massa sed massa. Maecenas volutpat facilisis sapien, in lobortis dui efficitur a. Ut non interdum elit. Etiam eget
									tellus tempor, cursus libero eget, euismod justo. Etiam vitae dolor quam. Duis lacinia euismod velit sed auctor. Sed
									mattis quam ipsum, eget semper augue facilisis sed. Morbi ornare volutpat nunc eu luctus. Etiam porttitor, metus
									non posuere lacinia, tortor neque mollis lorem, nec consequat nibh dolor in lectus. Ut eget tortor elementum, consequat nunc nec, varius neque. Vestibulum dignissim fringilla sem, vel rutrum elit euismod quis. Etiam mauris orci,
									semper vel consectetur at, cursus quis arcu.
									Mauris fringilla est posuere, feugiat risus vitae, condimentum nunc. Donec mattis tellus justo, ut malesuada massa
									imperdiet ac. Nunc sapien dolor, feugiat id imperdiet in, ullamcorper sit amet sapien. Curabitur at nibh et mauris
									placerat sollicitudin nec rutrum metus. Nunc non blandit arcu, a placerat nulla. Aenean luctus quis odio sit amet lobortis. Nulla auctor consequat sodales. Donec nec sem risus. Interdum et malesuada fames ac ante ipsum primis in
									faucibus.
									Fusce tempor tortor a odio tincidunt consequat. Maecenas pretium porttitor tincidunt. Donec vitae nulla tempus,
									dapibus nisi ac, mollis nisi. Pellentesque rhoncus purus ut augue commodo facilisis. Pellentesque iaculis interdum
									magna a tempor. Nullam sit amet rutrum urna. Phasellus quis accumsan risus, sodales rutrum sem. Vivamus aliquam
									eget enim nec sollicitudin. Interdum et malesuada fames ac ante ipsum primis in faucibus. Curabitur eget dictum
									orci. Nullam nec lorem condimentum, tempor elit eu, facilisis erat. Morbi ac justo a lorem fringilla venenatis.
									Quisque libero magna, placerat a leo ultricies, porta rhoncus leo. Vestibulum nec tincidunt felis, nec suscipit elit.
									Fusce a dictum neque. Curabitur sit amet convallis nisl, at euismod odio.
								</div>
							</div>
							<p style="color: #000000; padding-left: 20px;">
								<label><input type="checkbox" /> I accept the above terms and conditions</label>
							</p>
							<p style="text-align: right; padding-bottom: 20px;">
								<input type="button" value="Cancel" onclick="summaryCancel()" style="width: 120px" />
								&nbsp;&nbsp;
								<input type="button" value="Submit" onclick="summarySubmit()" style="width: 120px" />
							</p>
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
