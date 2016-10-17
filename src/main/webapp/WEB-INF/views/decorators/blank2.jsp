<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%-- <%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %> --%>
<!DOCTYPE html>
<html style="overflow-x:auto;overflow-y:auto;">
<head>
<title><sitemesh:write property='title' /></title>
<!--  - Powered By angel -->
<%@include file="/WEB-INF/views/include/head.jsp"%>
<sitemesh:write property='head' />
<script type="text/javascript">
	/* 	function addactive(a){
			$("a").removeClass("active");
			$(a).addClass("active");
		} */
	</script>
<style type='text/css'>
#menu a.selected { color: #428ce7; }
</style>
</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12" style="border: 1px solid #555555;">
				头部信息：
				<sitemesh:write property='title' />
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3" style="border: 1px solid #555555;">
				<ul id="menu">
					<li>
						<a href="${ctx}/login">登录</a>
					</li>
					<li>
						<a href="${ctx}/logout">注销</a>
					</li>
					<li><sitemesh:write property='meta.menu' /></li>
				</ul>
			</div>
			<div class="col-xs-6" style="border: 1px solid #555555;">
				<sitemesh:write property='body'></sitemesh:write>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12" style="border: 1px solid #555555;">
				版权所有
			</div>
		</div>
	</div>
</body>
</html>