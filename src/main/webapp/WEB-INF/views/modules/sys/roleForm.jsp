<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>角色管理</title>

		<meta name="description" content="500 Error Page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<meta name="menu" content="${ctx}/sys/role/list" />
	</head>
	
	<body>
		<script type="text/javascript">
		$(document).ready(function() {
			$('.date-picker').datepicker({
				autoclose: true,
				todayHighlight: true
			});
		});
        //定制列选择input信息
        function retainRadioInput(radio){
            var radioName = $(radio).attr("name");
            $("input[name="+radioName+"]").each(function(){
                if(this == radio){
                    //alert('aaa');
                    $(this).attr("checked",true);
                }else{
                    $(this).attr("checked",false);
                }
            });
        }
		</script>
		<div class="tabbable">
			<ul class="nav nav-tabs">
				<li>
					<a href="${ctx}/sys/role">
						角色列表
					</a>
				</li>
				<li class="active">
					<a href="${ctx}/sys/role/form?id=${role.id}">
						角色添加
					</a>
				</li>
			</ul>
		</div>
		<div class="widget-box" style="margin:0px 0px 6px 0px;">
			<div class="widget-body">
				<div class="widget-main">
					<form:form id="inputForm" modelAttribute="role" action="${ctx}/sys/role/save" method="post" class="form-horizontal">
						<!-- ID -->
						<form:hidden path="id"/>
						<div class="hr hr-24"></div>
						
						<div class="form-group">
							<label class="col-xs-12 col-sm-3 control-label no-padding-right">角色名称:</label>
							<div class="col-xs-12 col-sm-5">
								<span class="block input-icon input-icon-right">
									<form:input path="name" type="text" class="width-100"  placeholder="请输入角色名称" />
								</span>
							</div>
							<div class="help-block col-xs-12 col-sm-reset inline">
								<font color="red">*</font>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-xs-12 col-sm-3 control-label no-padding-right">角色英文名:</label>
							<div class="col-xs-12 col-sm-5">
								<span class="block input-icon input-icon-right">
									<form:input path="enname" type="text" class="width-100"  placeholder="请输入角色英文名" />
								</span>
							</div>
							<div class="help-block col-xs-12 col-sm-reset inline">
								<font color="red">*</font>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-xs-12 col-sm-3 control-label no-padding-right">角色类型:</label>
							<div class="col-xs-12 col-sm-5">
								<span class="block input-icon input-icon-right">
									<form:input path="roleType" type="text" class="width-100" placeholder="请输入字典类型" />
								</span>
							</div>
							<div class="help-block col-xs-12 col-sm-reset inline">
								<font color="red">*</font>
							</div>
						</div>
                        <div class="form-group">
                            <label class="col-xs-12 col-sm-3 control-label no-padding-right">是否隐藏:</label>
                            <div class="col-xs-12 col-sm-5">
							<span class="block input-icon input-icon-right">
								<c:forEach items="${fns:getDictList('sys_is_able')}" var="dict">
                                    <div class="radio">
                                        <label>
                                            <input onclick="retainRadioInput(this)" type="radio" class="ace" name="useable" value="${dict.value }" ${role.useable eq dict.value?"checked='checked'":""}>
                                            <span class="lbl"> ${dict.label }</span>
                                        </label>
                                    </div>
                                </c:forEach>
							</span>
                            </div>
                        </div>
						<div class="form-group ">
							<label class="col-xs-12 col-sm-3 control-label no-padding-right">备注:</label>
							<div class="col-xs-12 col-sm-5">
								<span class="block input-icon input-icon-right">
									<form:textarea path="remarks" class="width-100" placeholder="请输入描述" />
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
