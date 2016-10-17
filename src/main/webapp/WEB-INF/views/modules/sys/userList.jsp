<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>用户管理</title>

		<meta name="description" content="500 Error Page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<meta name="menu" content="${ctx}/sys/user/list" />
	</head>
	
	<body>
		<script type="text/javascript">
			$(document).ready(function() {
				$('#sample-table-2')
				//.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
				.dataTable( {
					/* "sDom":
						"<'row-fluid'<'span6'l><'span6'f>r>" +
						"<'row-fluid'<'span12't>>" +
						"<'row-fluid'<'span6'i>>"+
						"<'row-fluid'<'span6'p>>", */
					 "aLengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
					/* bAutoWidth: false,
					asDataSearch:true, */
					"oLanguage": {
				        "sProcessing": "处理中...",
				        "sLengthMenu": "显示 _MENU_ 项结果",
				        "sZeroRecords": "没有匹配结果",
				        "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
				        "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
				        "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
				        "sInfoPostFix": "",
				        "sSearch": "搜索:",
				        "sUrl": "",
				        "sEmptyTable": "表中数据为空",
				        "sLoadingRecords": "载入中...",
				        "sInfoThousands": ",",
				        "oPaginate": {
				            "sFirst": "首页",
				            "sPrevious": "上页",
				            "sNext": "下页",
				            "sLast": "末页"
				        },
				        "oAria": {
				            "sSortAscending": ": 以升序排列此列",
				            "sSortDescending": ": 以降序排列此列"
				        }
				    },
				   "bProcessing": true,//加载数据时显示正在加载信息 
				   "bServerSide" : true,//服务器分页
				   "sAjaxSource": "${ctx}/sys/user/datatables", //给服务器发请求的url
				   "aoColumns": [ //这个属性下的设置会应用到所有列，按顺序没有是空
				                    {"sDefaultContent": ''}, //mData 表示发请求时候本列的列明，返回的数据中相同下标名字的数据会填充到这一列
				                    {"mData": 'regisTime'}, // sDefaultContent 如果这一列不需要填充数据用这个属性，值可以不写，起占位作用
				                    {"mData": 'username'},
				                    {"mData": 'nickname'},
				                    {"mData": 'mobileNumber'},
				                    {"mData": 'status'},
				                    {"sDefaultContent": ''},//sClass 表示给本列加class
				                ],
				     "bPaginate": true,  //是否分页。
				     "bFilter": true,  //是否使用内置的过滤功能 
					//,
					//"sScrollY": "200px",
					//"bPaginate": false,
			
					//"sScrollX": "100%",
					//"sScrollXInner": "120%",
					//"bScrollCollapse": true,
					//Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
					//you may want to wrap the table inside a "div.dataTables_borderWrap" element
			
					//"iDisplayLength": 50    //每页显示8条数据   
			    } );
			});
			
		</script>
		<div class="tabbable">
			<ul class="nav nav-tabs" id="myTab">
				<li class="active">
					<a>
						用户列表
					</a>
				</li>
		
				<li>
					<a href="${ctx}/sys/user/form">
						用户添加
					</a>
				</li>
		
			</ul>
		</div>
		<div class="widget-box" style="margin:0px 0px 6px 0px;">
			<div class="widget-body">
				<div class="widget-main">
					<form class="form-search" id="searchForm" action="${ctx}/sys/user" method="post">
						
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
													<label style="font-size: 13px;">&nbsp;IDC性质:&nbsp;</label>
												</td>
												<td>
													<input class="input-sm" type="text">
												</td>
												<td>
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
												</td>
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
	<div>
		<!-- <div id="sample-table-2_wrapper" class="dataTables_wrapper form-inline" role="grid">
			<table id="sample-table-2" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info">
				<thead>
					<tr role="row">
						<th class="center sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="">
							<label class="position-relative"> 
								<input type="checkbox" class="ace"> <span class="lbl"></span>
							</label>
						</th>
						<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Domain: activate to sort column ascending">
							注册时间
						</th>
						<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Price: activate to sort column ascending">
							用户名
						</th>
						<th class="hidden-480 sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Clicks: activate to sort column ascending">
							昵称
						</th>
						<th class="sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Update: activate to sort column ascending">
							<i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
							 电话
						</th>
						<th class="hidden-480 sorting" role="columnheader" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending">
							状态
						</th>
						
						<th class="sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="">
							操作
						</th>
					</tr>
				</thead>
				<tbody role="alert" aria-live="polite" aria-relevant="all">
			
				</tbody>
			</table>
		</div>
	</div> -->
	<table id="treetable" class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th class="center">
	 					用户名
					</th>
					<th>用户昵称</th>
					<th>email</th>
					<th>手机</th>
					<th>注册时间</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
		
			<tbody>
				<c:forEach items="${list}" var="user">
					<tr>
						<td>
							<a href="${ctx}/sys/userform?id=${user.id}">${user.username}</a>
						</td>
						<td>${user.nickname}</td>
						<td>${user.username}</td>
						<td>
							${user.mobileNumber }
						</td>
						<td>
							${user.regisTime}
						</td>
						<td>
							${user.status}
						</td>
						<td>
							<a href="${ctx}/sys/user/form?id=${user.id}">修改</a>
							<a href="${ctx}/sys/user/delete?id=${user.id}" onclick="return confirmx('要删除该菜单及所有子菜单项吗？', this.href)">删除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<tagsys:page page="${page}" type="4"/>
	</body>
</html>
