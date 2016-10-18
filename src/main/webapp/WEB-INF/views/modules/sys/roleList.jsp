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
        <script>
            $(document).ready(function(){
                var contentTable = $('#contentTabel')
                        .dataTable( {
                            "bAutoWidth": false,
                            "aLengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
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
                                },
                            },
                            "bProcessing": true,//加载数据时显示正在加载信息
                            "bServerSide" : true,//服务器分页
                            "sAjaxSource": "${ctx}/sys/role/datatables", //给服务器发请求的url
                            "sServerMethod": "POST"  ,//post请求发送
                            "fnServerParams": function ( aoData ) { //添加额外参数
                                var label = $("#label").val();
                                var type = $("#type").val();
                                var description = $("#description").val();
                                aoData.push( { "name": "label", "value": label } );
                                aoData.push( { "name": "type", "value": type } );
                                aoData.push( { "name": "description", "value": description } );
                            },
                            "aoColumns": [ //这个属性下的设置会应用到所有列，按顺序没有是空
                                {"mData": 'id',"sClass":'center',"bSortable":false}, //mData 表示发请求时候本列的列明，返回的数据中相同下标名字的数据会填充到这一列
                                {"mData": 'name',"bSortable":false}, // sDefaultContent 如果这一列不需要填充数据用这个属性，值可以不写，起占位作用
                                {"mData": 'enname'},
                                {"mData": 'roleType'},
                                {"mData": 'useable'},
                                {"mData": 'remarks'},
                                {"mData": 'id',"bSortable":false},//sClass 表示给本列加class

                            ],
                            "aoColumnDefs":[
                                {
                                    "sName":"id",
                                    "aTargets":[0],
                                    "bSortable":false,
                                    "mData": "id", // 数据列名
                                    "mRender": function(data, type, full) { // 返回自定义内容
                                        var html = "";
                                        html = "<label class='position-relative'>";
                                        html += "<input type='checkbox' name='ids' class='ace' value='" + data + "' >";
                                        html += "<span class='lbl'></span>";
                                        html += "</label>";
                                        return html;
                                    }
                                },
                                {
                                    "aTargets":[6],
                                    "bSortable":false,
                                    "mData": "id", // 数据列名
                                    "mRender": function(data, type, full) { // 返回自定义内容
                                        var html = "<div class='hidden-sm hidden-xs action-buttons'>";
                                        html += "<a title='修改' data-rel='tooltip' class='green' href='${ctx}/sys/role/form?id=" + data + "' ><i class='ace-icon fa fa-pencil-square-o bigger-130'></i></a>";
                                        html += "<a title='删除' data-rel='tooltip' class='red' href='${ctx}/sys/role/delete?id=" + data + "' onclick='return confirmx(\"删除吗?\",this.href)'><i class='ace-icon fa fa-trash-o bigger-130'></i></a>";
                                        html += "</div>";
                                        return html;
                                    }

                                }

                            ],
                            "bPaginate": true,  //是否分页。
                            "bFilter": true,  //是否使用内置的过滤功能
                            /* "fnCreatedRow":function ( row, data, index ) {
                             $('td', row).eq(0).addClass("center");
                             } */
                            //绘图回调函数
                            "fnDrawCallback": function(){
                                //增加提示框
                                $('[data-rel=tooltip]').tooltip();
                                $('[data-rel=popover]').popover({html:true});
                                var oTable = $("#contentTabel").dataTable();
                                $('#redirect').keypress(function(e){
                                    var c=e.keyCode||e.which;
                                    if(c==13){
                                        if($(this).val() && $(this).val()>0){
                                            var redirectpage = $(this).val()-1;
                                            oTable.fnPageChange( redirectpage );
                                        }else{
                                            var redirectpage = 0;
                                            oTable.fnPageChange( redirectpage );
                                        }
                                    }
                                });
                            },
                            "fnInfoCallback":function(oSettings, iStart, iEnd, iMax, iTotal, sPre){
                                //回调函数
                                var pageNum =  Math.ceil( oSettings._iDisplayStart / oSettings._iDisplayLength );
                                if(pageNum==null){
                                    pageNum = 0;
                                }
                                pageNum = pageNum + 1;
                                $("#redirect").val(pageNum);
                            }
                        } );

                $("#searchBtn").click(function(){
                    contentTable.fnDraw();
                });

                //延时搜索
                // contentTable.fnSetFilteringDelay();

                $('[data-rel=tooltip]').tooltip();
                $('[data-rel=popover]').popover({html:true});
            });

        </script>
        <div class="tabbable">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a>
                        角色列表
                    </a>
                </li>

                <li>
                    <a href="${ctx}/sys/role/form">
                        角色添加
                    </a>
                </li>
            </ul>
        </div>
        <div class="widget-box" style="margin:0px 0px 6px 0px;">
            <div class="widget-body">
                <div class="widget-main">
                    <form class="form-search" id="searchForm" action="${ctx}/sys/role/list" method="post">
                        <div class="row">
                            <div class="col-xs-12 col-sm-8">
                                <div class="input-group">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td>
                                                <label style="font-size: 13px;">&nbsp;标签:&nbsp;</label>
                                            </td>
                                            <td>
                                                <input class="input-sm" type="text" id="label">
                                            </td>
                                            <td>
                                                <label style="font-size: 13px;">&nbsp;类型:&nbsp;</label>
                                            </td>
                                            <td>
                                                <input class="input-sm" type="text" id="type">
                                            </td>
                                            <td>
                                                <label style="font-size: 13px;">&nbsp;描述:&nbsp;</label>
                                            </td>
                                            <td>
                                                <input class="input-sm" type="text" id="description">
                                            </td>
                                            <td>
                                                &nbsp;&nbsp;
                                                <button type="button" class="btn btn-purple btn-sm" id="searchBtn">
                                                    搜索
                                                    <i class="ace-icon fa fa-search icon-on-right bigger-110"></i>
                                                </button>
                                                &nbsp;&nbsp;
                                                <button type="button" class="btn btn-blue3 btn-sm">
                                                    删除一堆
                                                    <i class="ace-icon fa fa-trash-o icon-on-right bigger-110"></i>
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
            <div id="sample-table-2_wrapper" class="dataTables_wrapper form-inline" role="grid">
                <table id="contentTabel" class="table table-striped table-bordered table-hover dataTable" aria-describedby="sample-table-2_info">
                    <thead>
                    <tr role="row">
                        <th class="center sorting_disabled">
                            <label class="position-relative">
                                <input type="checkbox" class="ace"><span class="lbl"></span>
                            </label>
                        </th>
                        <th class="sorting">
                            角色名称
                        </th>
                        <th class="sorting" >
                            英文名称
                        </th>
                        <th class="sorting" >
                            角色类型
                        </th>
                        <th class="sorting" >
                            <!-- <i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i> -->
                            是否启用
                        </th>
                        <th class="sorting" >
                            描述
                        </th>

                        <th class="sorting_disabled" >
                            操作
                        </th>
                    </tr>
                    </thead>
                    <tbody role="alert" aria-live="polite" aria-relevant="all">
                    </tbody>
                </table>
            </div>
        </div>
	</body>
</html>
