<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>用户管理</title>

		<meta name="description" content="500 Error Page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<meta name="menu" content="${ctx}/sys/dict/list" />
	</head>
	
	<body>
		<script type="text/javascript">
		$(document).ready(function() {
			$('.date-picker').datepicker({
				autoclose: true,
				todayHighlight: true
			});
		});
		
		</script>
		<div class="tabbable">
			<ul class="nav nav-tabs">
				<li>
					<a href="${ctx}/sys/dict">
						字典列表
					</a>
				</li>
				<li class="active">
					<a href="${ctx}/sys/dict/form?id=${user.id}">
						字典添加
					</a>
				</li>
			</ul>
		</div>
		<div class="widget-box" style="margin:0px 0px 6px 0px;">
			<div class="widget-body">
				<div class="widget-main">
					<form:form id="inputForm" modelAttribute="dict" action="${ctx}/sys/dict/save" method="post" class="form-horizontal">
						<!-- ID -->
						<form:hidden path="id"/>
						<div class="hr hr-24"></div>
						
						<div class="form-group">
							<label class="col-xs-12 col-sm-3 control-label no-padding-right">字典值:</label>
							<div class="col-xs-12 col-sm-5">
								<span class="block input-icon input-icon-right">
									<form:input path="value" type="text" class="width-100"  placeholder="请输入字典值" />
								</span>
							</div>
							<div class="help-block col-xs-12 col-sm-reset inline">
								<font color="red">*</font>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-xs-12 col-sm-3 control-label no-padding-right">字典标签:</label>
							<div class="col-xs-12 col-sm-5">
								<span class="block input-icon input-icon-right">
									<form:input path="label" type="text" class="width-100"  placeholder="请输入字典标签" />
								</span>
							</div>
							<div class="help-block col-xs-12 col-sm-reset inline">
								<font color="red">*</font>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-xs-12 col-sm-3 control-label no-padding-right">字典类型:</label>
							<div class="col-xs-12 col-sm-5">
								<span class="block input-icon input-icon-right">
									<form:input path="type" type="text" class="width-100" placeholder="请输入字典类型" />
								</span>
							</div>
							<div class="help-block col-xs-12 col-sm-reset inline">
								<font color="red">*</font>
							</div>
						</div>
						
						<div class="form-group ">
							<label class="col-xs-12 col-sm-3 control-label no-padding-right">排序:</label>

							<div class="col-xs-12 col-sm-5">
								<span class="block input-icon input-icon-right">
									<form:input path="sort" type="number" class="width-100" placeholder="请输入排序值" />
									<!-- <i class="ace-icon fa fa-envelope"></i> -->
								</span>
							</div>
							<div class="help-block col-xs-12 col-sm-reset inline">
								<font color="red">*</font>
							</div>
						</div>
						
						<div class="form-group ">
							<label class="col-xs-12 col-sm-3 control-label no-padding-right">描述:</label>
							<div class="col-xs-12 col-sm-5">
								<span class="block input-icon input-icon-right">
									<%-- <form:input path="description" type="text" class="width-100" placeholder="请输入描述" /> --%>
									<form:textarea path="description" class="width-100" placeholder="请输入描述" />
									<!-- <i class="ace-icon fa fa-phone fa-flip-horizontal"></i> -->
								</span>
							</div>
							<div class="help-block col-xs-12 col-sm-reset inline"></div>
						</div>
						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								
								<button class="btn btn-info" type="submit">
									<i class="ace-icon fa fa-check bigger-110"></i>
									提交
								</button>

								&nbsp; &nbsp; &nbsp;
								<button class="btn" type="reset">
									<i class="ace-icon fa fa-undo bigger-110"></i>
									重置
								</button>
								&nbsp; &nbsp; &nbsp;
								<a href="javascript:history.back()" class="btn btn-grey">
									<i class="ace-icon fa fa-arrow-left"></i>
									返回
								</a>
							</div>
						</div>
						<div class="hr hr-24"></div>
					</form:form>
				</div>
			</div>
		</div>
		
	</body>
</html>
