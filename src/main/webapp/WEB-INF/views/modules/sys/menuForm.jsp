<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>菜单管理</title>

<meta name="description" content="500 Error Page" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<meta name="menu" content="${ctx}/sys/menu/list" />
</head>

<body>
	<script type="text/javascript" >
	
	var setting = {
		 async: {
			 enable:true,  
		     type:"post",  
		     url:"${ctx}/sys/menu/treeview"
		}, 
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onDblClick: function(event,treeId, treeNode) {
				$("#parentName").val(String(treeNode.name));
				$("#parentId").val(String(treeNode.id));
				$("#treeDialog").dialog("close");
			},
			onClick:function(event, treeId, treeNode){
				$("#tempMenuId").val(String(treeNode.id));
				$("#tempMenuName").val(String(treeNode.name));
			}
		}
	};

	$(document).ready(function(){
		$.fn.zTree.init($("#tree"), setting);
		//$.fn.zTree.init(t, setting, zNodes);
		//zTree = $.fn.zTree.getZTreeObj("tree");
		$("#selectMenuBtn,#parentName").click(function(){
			$("#treeDialog").removeClass('hide').dialog({
				resizable: false,
				//modal: true,
				title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon fa fa-exclamation-triangle red'></i>菜单</h4></div>",
				title_html: true,
				buttons: [
					{
						html: "<i class='ace-icon fa fa-check bigger-110'></i>&nbsp; 确定",
						"class" : "btn btn-info btn-xs",
						click: function() {
							var tempMenuId = $("#tempMenuId").val();
							var tempMenuName = $("#tempMenuName").val();
							$("#parentName").val(tempMenuName);
							$("#parentId").val(tempMenuId);
							$(this).dialog("close");
						}
					}
					,
					{
						html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; 取消",
						"class" : "btn btn-xs",
						click: function() {
							$(this).dialog("close");
						}
					}
				]
			});
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


    //重新加载
/* 	function re(){
		var treeObj = $.fn.zTree.getZTreeObj("tree");
		treeObj.reAsyncChildNodes(null, "refresh");
	} */
  </script>
	<div class="tabbable">
		<ul class="nav nav-tabs">
			<li><a href="${ctx}/sys/menu/list"> 菜单列表 </a></li>

			<li class="active"><a href="${ctx}/sys/menu/form?parent.id=${menu.parent.id}&id=${menu.id}"> 菜单添加 </a></li>

		</ul>
	</div>
	<div class="widget-box" style="margin:0px 0px 6px 0px;">
		<div class="widget-body">
			<div class="widget-main">
				<form:form id="inputForm" modelAttribute="menu" action="${ctx}/sys/menu/save" method="post" class="form-horizontal">
					<!-- ID -->
					<form:hidden path="id"/>
					<div class="hr hr-24"></div>
					<div class="form-group">
						<label class="col-xs-12 col-sm-3 control-label no-padding-right">父菜单:</label>
						<div class="col-xs-12 col-sm-5">
							<div class="input-group">
								<input type="text" class="form-control " readonly="readonly" placeholder="请选择菜单" id="parentName" name="parent.name" value="${menu.parent.name}">
								<input type="hidden" readonly="readonly" id="parentId" name="parent.id" value="${menu.parent.id}">
								<input type="hidden" id="tempMenuId">
								<input type="hidden" id="tempMenuName">
								<span class="input-group-btn">
									<button type="button" class="btn btn-purple btn-sm" id="selectMenuBtn">
										选择
										<i class="ace-icon fa fa-search icon-on-right bigger-110"></i>
									</button>
								</span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-12 col-sm-3 control-label no-padding-right">菜单名称:</label>
						<div class="col-xs-12 col-sm-5">
							<span class="block input-icon input-icon-right">
								<form:input path="name" class="form-control width-100" placeholder="请输入菜单名称" />
							</span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-12 col-sm-3 control-label no-padding-right">链接:</label>
						<div class="col-xs-12 col-sm-5">
							<span class="block input-icon input-icon-right">
								<form:input path="href" class="form-control width-100" placeholder="请输入链接" />
							</span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-12 col-sm-3 control-label no-padding-right">排序:</label>
						<div class="col-xs-12 col-sm-5">
							<span class="block input-icon input-icon-right">
								<form:input path="sort" class="form-control width-100" placeholder="排序" />
							</span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-12 col-sm-3 control-label no-padding-right">是否隐藏:</label>
						<div class="col-xs-12 col-sm-5">
							<span class="block input-icon input-icon-right">
								<c:forEach items="${fns:getDictList('show_hide')}" var="dict">
									<div class="radio">
										<label>
											<input onclick="retainRadioInput(this)" type="radio" class="ace" name="isShow" value="${dict.value }" ${menu.isShow eq dict.value?"checked='checked'":""}>
											<span class="lbl"> ${dict.label }</span>
										</label>
									</div>
								</c:forEach>
							</span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-12 col-sm-3 control-label no-padding-right">权限:</label>
						<div class="col-xs-12 col-sm-5">
							<span class="block input-icon input-icon-right">
								<form:input path="permission" class="form-control width-100" placeholder="请输入权限" />
							</span>
						</div>
					</div>
					<div class="hr"></div>
					<div class="clearfix form-actions">
						<div class="col-md-offset-3 col-md-9">
							<button class="btn btn-info" type="submit">
								<i class="ace-icon fa fa-check bigger-110"></i> 提交
							</button>

							&nbsp; &nbsp; &nbsp;
							<button class="btn" type="reset">
								<i class="ace-icon fa fa-undo bigger-110"></i> 重置
							</button>
							&nbsp; &nbsp; &nbsp; <a href="javascript:history.back()" class="btn btn-grey"> <i class="ace-icon fa fa-arrow-left"></i> 返回
							</a>
						</div>
					</div>
					<div class="hr hr-24"></div>
				</form:form>
			</div>
		</div>
	</div>
	<!-- 菜单对话框 -->
	<div id="treeDialog" class='hide'>
		<ul id="tree" class="ztree" ></ul>
	</div>
</body>
</html>
