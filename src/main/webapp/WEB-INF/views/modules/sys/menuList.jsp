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
		<script type="text/javascript">
			$(document).ready(function() {
				$("#treetable").treetable({ expandable: true });
				$("#treetable").treetable("expandAll");
			});
			
		</script>
		<div class="tabbable">
			<ul class="nav nav-tabs">
				<li class="active">
					<a href="${ctx}/sys/menu/list">
						菜单列表
					</a>
				</li>
		
				<li>
					<a href="${ctx}/sys/menu/form">
						菜单添加
					</a>
				</li>
		
			</ul>
		</div>
		<div class="widget-box" style="margin:0px 0px 6px 0px;">
			<div class="widget-body">
				<div class="widget-main">
					<form class="form-search" id="searchForm" action="${ctx}/sys/menu" method="post">
						
						<input id="page" name="paginator.page" type="hidden" value="${paginator.page}"/>
						<input id="limit" name="paginator.limit" type="hidden" value="${paginator.limit}"/>
						<input id="totalPages" name="paginator.totalPages" type="hidden" value="${paginator.totalPages}"/>
						<input id="totalCount" name="paginator.totalCount" type="hidden" value="${paginator.totalCount}"/>
						
						<div class="row">
							<div class="col-xs-12 col-sm-8">
								<div class="input-group">
									<table>
										<tbody>
											<tr>
												<td>
													<label style="font-size: 13px;">&nbsp;名称&nbsp;</label>
												</td>
												<td>
													<input class="input-sm" type="text">
												</td>
												<!-- <td>
													<label style="font-size: 13px;">&nbsp;线路类型:&nbsp;</label>
												</td>
												<td>
													<input class="input-sm" type="text">
												</td> 
												<td>
													<label style="font-size: 13px;">&nbsp;IDC区域:&nbsp;</label>
												</td>
												<td>
													<input class="input-sm" type="text">
												</td> -->
												<td>
													&nbsp;&nbsp;
													<button type="button" class="btn btn-purple btn-sm">
														搜索
														<i class="ace-icon fa fa-search icon-on-right bigger-110"></i>
													</button>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<table id="treetable" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th class="center">
	 					名称
					</th>
					<th>链接</th>
					<th>排序</th>
					<th>可见</th>
					<th>权限标识</th>
					<th>操作</th>
				</tr>
			</thead>
		
			<tbody>
				<c:forEach items="${list}" var="menu">
					<tr id="${menu.id}" data-tt-id="${menu.id }" data-tt-parent-id = "${menu.parent.id}" >
						<td>
							<i class="icon-${not empty menu.icon?menu.icon:' hide'}">
							</i><a href="${ctx}/sys/menu/form?id=${menu.id}">${menu.name}</a>
						</td>
						<td>${menu.href}</td>
						<td>${fns:getDictLabel(menu.isShow, 'show_hide', '')}</td>
						<td style="text-align:center;">
								<input type="hidden" name="ids" value="${menu.id}"/>
								<input name="sorts" type="text" value="${menu.sort}" style="width:50px;margin:0;padding:0;text-align:center;">
						</td>
						<td>
							${menu.permission}
						</td>
						<td>
							<a href="${ctx}/sys/menu/form?id=${menu.id}">修改</a>
							<a href="${ctx}/sys/menu/delete?id=${menu.id}" onclick="return confirmx('要删除该菜单及所有子菜单项吗？', this.href)">删除</a>
							<a href="${ctx}/sys/menu/form?parent.id=${menu.id}">添加下级菜单</a> 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%-- <tagsys:page paginator="${paginator}" type="4"/> --%>
	</body>
</html>
