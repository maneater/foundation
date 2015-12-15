<!-- 顶部导航条 -->
<div class="mainHeadDiv">
	<div class="loginTitleDiv">
		<span>${title}</span>
	</div>
	<div class="topNavDiv">
		<ul>
			<c:choose>
				<c:when test="${channelId==1}">
					<li class="current">
						<span>1</span> Login
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<a href="javascript:void(0);"> <span>1</span> Login</a>
					</li>
				</c:otherwise>
			</c:choose>


			<c:choose>
				<c:when test="${channelId==2}">
					<li class="current">
						<span>2</span> Room
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<a href="javascript:void(0);"> <span>2</span> Room</a>
					</li>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${channelId==3}">
					<li class="current">
						<span>3</span> Furniture
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<a href="javascript:void(0);"> <span>3</span> Furniture</a>
					</li>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${channelId==4}">
					<li class="current">
						<span>4</span> View
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<a href="javascript:void(0);"> <span>4</span> View</a>
					</li>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${channelId==5}">
					<li class="current">
						<span>5</span> Done!
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<a href="javascript:void(0);"> <span>5</span> Done!</a>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
		<div class="topNavLine">
		</div>
	</div>
</div>
