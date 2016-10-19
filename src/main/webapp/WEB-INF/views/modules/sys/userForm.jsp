<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>菜单管理</title>

		<meta name="description" content="500 Error Page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<meta name="menu" content="${ctx}/sys/user/list" />
	</head>
	
	<body>
		<script type="text/javascript">
		$(document).ready(function() {
			$('#regisTime').datepicker({
				autoclose: true,
				todayHighlight: true,
                dateFormat: "yy-mm-dd"
			});
		});
		
		</script>
		<div class="tabbable">
			<ul class="nav nav-tabs">
				<li>
					<a href="${ctx}/sys/user">
						用户列表
					</a>
				</li>
				<li class="active">
					<a href="${ctx}/sys/user/form?id=${user.id}">
						用户添加
					</a>
				</li>
			</ul>
		</div>
		<div class="widget-box" style="margin:0px 0px 6px 0px;">
			<div class="widget-body">
				<div class="widget-main">
					<form:form id="inputForm" modelAttribute="user" action="${ctx}/sys/user/save" method="post" class="form-horizontal">
						<!-- ID -->
						<form:hidden path="id"/>
						<div class="hr hr-24"></div>
						
						<div class="form-group">
							<label class="col-xs-12 col-sm-3 control-label no-padding-right">用户名:</label>
							<div class="col-xs-12 col-sm-5">
								<span class="block input-icon input-icon-right">
									<form:input path="username" type="text" class="width-100"  placeholder="请输入用户名" />
								</span>
							</div>
							<div class="help-block col-xs-12 col-sm-reset inline">
								<font color="red">*</font>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-xs-12 col-sm-3 control-label no-padding-right">密码:</label>
							<div class="col-xs-12 col-sm-5">
								<span class="block input-icon input-icon-right">
									<form:input path="password" type="password" class="width-100"  placeholder="请输入密码" />
								</span>
							</div>
							<div class="help-block col-xs-12 col-sm-reset inline">
								<font color="red">*</font>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-xs-12 col-sm-3 control-label no-padding-right">确认密码:</label>
							<div class="col-xs-12 col-sm-5">
								<span class="block input-icon input-icon-right">
									<input type="password" class="width-100"  placeholder="请输入和上面相同密码"  />
								</span>
							</div>
							<div class="help-block col-xs-12 col-sm-reset inline">
								<font color="red">*</font>请输入和上面相同密码 
							</div>
						</div>
						
						<div class="form-group ">
							<label class="col-xs-12 col-sm-3 control-label no-padding-right">Email:</label>

							<div class="col-xs-12 col-sm-5">
								<span class="block input-icon input-icon-right">
									<form:input path="email" type="text" class="width-100"  placeholder="email@email.com" />
									<i class="ace-icon fa fa-envelope"></i>
								</span>
							</div>
							<div class="help-block col-xs-12 col-sm-reset inline"></div>
						</div>
						
						<div class="form-group ">
							<label class="col-xs-12 col-sm-3 control-label no-padding-right">电话:</label>
							<div class="col-xs-12 col-sm-5">
								<span class="block input-icon input-icon-right">
									<form:input path="mobileNumber" class="width-100" />
									<i class="ace-icon fa fa-phone fa-flip-horizontal"></i>
								</span>
							</div>
							<div class="help-block col-xs-12 col-sm-reset inline"></div>
						</div>
						
						<div class="form-group ">
							<label class="col-xs-12 col-sm-3 control-label no-padding-right">身份证:</label>
							<div class="col-xs-12 col-sm-5">
								<span class="block input-icon input-icon-right">
									<form:input path="idCard" type="text" class="width-100" />
								</span>
							</div>
							<div class="help-block col-xs-12 col-sm-reset inline"></div>
						</div>
						
						<div class="form-group ">
							<label class="col-xs-12 col-sm-3 control-label no-padding-right">昵称:</label>
							<div class="col-xs-12 col-sm-5">
								<span class="block input-icon input-icon-right">
									<form:input path="nickname" type="text" class="width-100" />
								</span>
							</div>
							<div class="help-block col-xs-12 col-sm-reset inline"></div>
						</div>
						
						<div class="form-group ">
							<label class="col-xs-12 col-sm-3 control-label no-padding-right">注册时间:</label>
							<div class="col-xs-12 col-sm-5">
								<span class="block input-icon input-icon-right">
								<!-- 	<input type="text" class="width-100"> -->
                                    <input class="form-control date-picker" id="regisTime" type="text" data-format="yyyy-MM-dd HH:mm:ss" name="regisTime" value="<fmt:formatDate value="${user.regisTime}" pattern="yyyy-MM-dd"/>"/>
									<%--<form:input path="regisTime" class="form-control date-picker" id="id-date-picker-1" type="text" data-format="yyyy-mm-dd" />--%>
									<i class="ace-icon fa fa-calendar"></i>
								</span>
							</div>
							<div class="help-block col-xs-12 col-sm-reset inline"></div>
						</div>

						<div class="form-group ">
							<label class="col-xs-12 col-sm-3 control-label no-padding-right">用户角色:</label>
							<div class="col-xs-12 col-sm-5">
								<span class="block input-icon input-icon-right">

                                        <c:forEach items="${roleList}" var="role">
                                            <label class="position-relative">
                                                <input type="checkbox" class="ace" name="roleIds" value="${role.id}" ${fn:contains(user.roleListIdsStr,role.id)?'checked=checked':''}><span class="lbl">${fn:contains(user.roleListIdsStr,role.id)}${role.name}</span>
                                            </label>
                                        </c:forEach>
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
