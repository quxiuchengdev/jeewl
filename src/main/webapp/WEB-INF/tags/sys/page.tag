<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ attribute name="page" type="com.qxcwl.jeewl.common.page.Page" required="true" description="分页器" %>
<%@ attribute name="cssfloat" type="java.lang.String" description="分页位置"%>
<%@ attribute name="type" type="java.lang.String" description="分页类型"%>
<script type="text/javascript">
    //系统翻页默认函数
    function page(n,s){
        $("#page").val(n);
        $("#pageSize").val(s);
        $("#searchForm").submit();
        return false;
    }
</script>
<c:if test="${not empty page}">
    <c:if test="${empty type or type eq '1'}">
        <div class="dataTables_paginate paging_bootstrap" style="${cssfloat eq 'left' ?'text-align:left':'' }" >
            <ul class="pagination" style="${cssfloat eq 'left' ?'margin:0px':'' }">
                <!-- 首页 -->
                <li class="prev ${page.firstPage?'disabled':''}">
                    <!-- 当不为第一页时 -->
                    <c:if test="${!page.firstPage}">
                        <a href="javascript:;" onclick="${page.pageFunctionName}('1','${page.pageSize}');">
                            <i class="fa fa-angle-double-left"></i>
                        </a>
                    </c:if>
                    <!-- 当为第一页时 -->
                    <c:if test="${page.firstPage}">
                        <a href="javascript:;">
                            <i class="fa fa-angle-double-left"></i>
                        </a>
                    </c:if>
                </li>
                <!-- 上一页 -->
                <li class="prev ${page.hasPrePage ?'':'disabled'}">
                    <!-- 上一页有数据 -->
                    <c:if test="${page.hasPrePage}">
                        <a href="javascript:;" onclick="${page.pageFunctionName}('${page.prePage}','${page.pageSize}');">
                            <i class="fa fa-angle-left"></i>
                        </a>
                    </c:if>
                    <!-- 上一页无数据 -->
                    <c:if test="${!page.hasPrePage}">
                        <a href="javascript:;">
                            <i class="fa fa-angle-left"></i>
                        </a>
                    </c:if>
                </li>
                <c:forEach  items="${page.slider}" var="slider">
                    <c:if test="${fns:isDisabledPage(page.totalPages,page.pageNo,slider)}">
                        <li class="active">
                            <a href="javascript:;">
                                    ${slider}
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${!fns:isDisabledPage(page.totalPages,page.pageNo,slider)}">
                        <li>
                            <a href="javascript:;"  onclick="${page.pageFunctionName}('${slider}','${page.pageSize}');">
                                    ${slider}
                            </a>
                        </li>
                    </c:if>
                </c:forEach>
                <!-- 下一页 -->
                <li class="next ${page.hasNextPage?'':'disabled'}">
                    <!-- 下一页无数据 -->
                    <c:if test="${!page.hasNextPage}">
                        <a href="javascript:;">
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </c:if>
                    <!-- 下一页有数据 -->
                    <c:if test="${page.hasNextPage}">
                        <a href="javascript:;" onclick="${page.pageFunctionName}('${page.nextPage}','${page.pageSize}');">
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </c:if>
                </li>
                <!-- 尾页 -->
                <li class="next ${page.lastPage?'disabled':''}">
                    <!-- 最后一页为尾页时 -->
                    <c:if test="${page.lastPage}">
                        <a href="javascript:;">
                            <i class="fa fa-angle-double-right"></i>
                        </a>
                    </c:if>
                    <!-- 最后一页不为尾页时 -->
                    <c:if test="${!page.lastPage}">
                        <a href="javascript:;" onclick="${page.pageFunctionName}('${page.totalPages}','${page.pageSize}');">
                            <i class="fa fa-angle-double-right"></i>
                        </a>
                    </c:if>
                </li>
            </ul>
        </div>
    </c:if>

    <!-- 类型2 -->
    <c:if test="${type eq '2'}">
        <div class="dataTables_wrapper form-inline">
            <div class="row">
                <div class="col-xs-6">
                    <div class="dataTables_info" style="font-size: 13px;">
                        当前第${page.pageNo}页,显示第${page.nowFirstCount}条到第${page.nowLastCount}条,共${page.count}条
                    </div>
                    <!-- 设置左面CSS -->
                    <c:if test="${(!cssfloat eq 'left') or (empty cssfloat)}">
                </div>
                <div class="col-xs-6">
                    </c:if>
                    <!-- 设置左面CSS -->

                    <div class="dataTables_paginate paging_bootstrap" style="${cssfloat eq 'left' ?'text-align:left':'' }" >
                        <ul class="pagination" style="${cssfloat eq 'left' ?'margin:0px':'' }">
                            <!-- 首页 -->
                            <li class="prev ${page.firstPage?'disabled':''}">
                                <!-- 当不为第一页时 -->
                                <c:if test="${!page.firstPage}">
                                    <a href="javascript:;" onclick="${page.pageFunctionName}('1','${page.pageSize}');">
                                        <i class="fa fa-angle-double-left"></i>
                                    </a>
                                </c:if>
                                <!-- 当为第一页时 -->
                                <c:if test="${page.firstPage}">
                                    <a href="javascript:;">
                                        <i class="fa fa-angle-double-left"></i>
                                    </a>
                                </c:if>
                            </li>
                            <!-- 上一页 -->
                            <li class="prev ${page.hasPrePage ?'':'disabled'}">
                                <!-- 上一页有数据 -->
                                <c:if test="${page.hasPrePage}">
                                    <a href="javascript:;" onclick="${page.pageFunctionName}('${page.prePage}','${page.pageSize}');">
                                        <i class="fa fa-angle-left"></i>
                                    </a>
                                </c:if>
                                <!-- 上一页无数据 -->
                                <c:if test="${!page.hasPrePage}">
                                    <a href="javascript:;">
                                        <i class="fa fa-angle-left"></i>
                                    </a>
                                </c:if>
                            </li>
                            <c:forEach  items="${page.slider}" var="slider">
                                <c:if test="${fns:isDisabledPage(page.totalPages,page.pageNo,slider)}">
                                    <li class="active">
                                        <a href="javascript:;">
                                                ${slider}
                                        </a>
                                    </li>
                                </c:if>
                                <c:if test="${!fns:isDisabledPage(page.totalPages,page.pageNo,slider)}">
                                    <li>
                                        <a href="javascript:;"  onclick="${page.pageFunctionName}('${slider}','${page.pageSize}');">
                                                ${slider}
                                        </a>
                                    </li>
                                </c:if>
                            </c:forEach>
                            <!-- 下一页 -->
                            <li class="next ${page.hasNextPage?'':'disabled'}">
                                <!-- 下一页无数据 -->
                                <c:if test="${!page.hasNextPage}">
                                    <a href="javascript:;">
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </c:if>
                                <!-- 下一页有数据 -->
                                <c:if test="${page.hasNextPage}">
                                    <a href="javascript:;" onclick="${page.pageFunctionName}('${page.nextPage}','${page.pageSize}');">
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </c:if>
                            </li>
                            <!-- 尾页 -->
                            <li class="next ${page.lastPage?'disabled':''}">
                                <!-- 最后一页为尾页时 -->
                                <c:if test="${page.lastPage}">
                                    <a href="javascript:;">
                                        <i class="fa fa-angle-double-right"></i>
                                    </a>
                                </c:if>
                                <!-- 最后一页不为尾页时 -->
                                <c:if test="${!page.lastPage}">
                                    <a href="javascript:;" onclick="${page.pageFunctionName}('${page.totalPages}','${page.pageSize}');">
                                        <i class="fa fa-angle-double-right"></i>
                                    </a>
                                </c:if>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
    <!-- 类型3 -->
    <c:if test="${type eq '3'}">
        <div class="dataTables_paginate paging_bootstrap" style="${cssfloat eq 'left' ?'text-align:left':'' }" >
            <ul class="pagination" style="${cssfloat eq 'left' ?'margin:0px':'' }">
                <!-- 首页 -->
                <li class="prev ${page.firstPage?'disabled':''}">
                    <!-- 当不为第一页时 -->
                    <c:if test="${!page.firstPage}">
                        <a href="javascript:;" onclick="${page.pageFunctionName}('1','${page.pageSize}');">
                            <i class="fa fa-angle-double-left"></i>
                        </a>
                    </c:if>
                    <!-- 当为第一页时 -->
                    <c:if test="${page.firstPage}">
                        <a href="javascript:;">
                            <i class="fa fa-angle-double-left"></i>
                        </a>
                    </c:if>
                </li>
                <!-- 上一页 -->
                <li class="prev ${page.hasPrePage ?'':'disabled'}">
                    <!-- 上一页有数据 -->
                    <c:if test="${page.hasPrePage}">
                        <a href="javascript:;" onclick="${page.pageFunctionName}('${page.prePage}','${page.pageSize}');">
                            <i class="fa fa-angle-left"></i>
                        </a>
                    </c:if>
                    <!-- 上一页无数据 -->
                    <c:if test="${!page.hasPrePage}">
                        <a href="javascript:;">
                            <i class="fa fa-angle-left"></i>
                        </a>
                    </c:if>
                </li>
                <!-- 页码标识 -->
                <c:forEach  items="${page.slider}" var="slider">
                    <c:if test="${fns:isDisabledPage(page.totalPages,page.pageNo,slider)}">
                        <li class="active">
                            <a href="javascript:;">
                                    ${slider}
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${!fns:isDisabledPage(page.totalPages,page.pageNo,slider)}">
                        <li>
                            <a href="javascript:;"  onclick="${page.pageFunctionName}('${slider}','${page.pageSize}');">
                                    ${slider}
                            </a>
                        </li>
                    </c:if>
                </c:forEach>
                <!-- 下一页 -->
                <li class="next ${page.hasNextPage?'':'disabled'}">
                    <!-- 下一页无数据 -->
                    <c:if test="${!page.hasNextPage}">
                        <a href="javascript:;">
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </c:if>
                    <!-- 下一页有数据 -->
                    <c:if test="${page.hasNextPage}">
                        <a href="javascript:;" onclick="${page.pageFunctionName}('${page.nextPage}','${page.pageSize}');">
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </c:if>
                </li>
                <!-- 尾页 -->
                <li class="next ${page.lastPage?'disabled':''}">
                    <!-- 最后一页为尾页时 -->
                    <c:if test="${page.lastPage}">
                        <a href="javascript:;">
                            <i class="fa fa-angle-double-right"></i>
                        </a>
                    </c:if>
                    <!-- 最后一页不为尾页时 -->
                    <c:if test="${!page.lastPage}">
                        <a href="javascript:;" onclick="${page.pageFunctionName}('${page.totalPages}','${page.pageSize}');">
                            <i class="fa fa-angle-double-right"></i>
                        </a>
                    </c:if>
                </li>
                <li class="disabled">
                    <a href="javascript:;" style="padding:4px 12px 4px 12px;">
                        当前第
                        <input type="text" value="${page.pageNo}" onclick="this.select();" style="width:30px;margin:0;padding:0;text-align:center;" onkeypress="var e=window.event||event||this;var c=e.keyCode||e.which;if(c==13)${page.pageFunctionName}(this.value,'${page.pageSize}');">
                        页
                        /
                        每页显示
                        <input type="text" value="${page.pageSize}" onclick="this.select();" style="width:30px;margin:0;padding:0;text-align:center;" onkeypress="var e=window.event||event||this;var c=e.keyCode||e.which;if(c==13)${page.pageFunctionName}('${page.pageSize}',this.value);">
                        条,
                        共${page.count}条

                    </a>
                </li>
            </ul>
        </div>
    </c:if>
    <!-- 类型4 -->
    <c:if test="${type eq '4'}">
        <div class="dataTables_wrapper form-inline">
            <div class="row">
                <div class="col-xs-6">
                    <div class="dataTables_info" style="font-size: 13px;">
                        当前第${page.pageNo}页,显示第${page.nowFirstCount}条到第${page.nowLastCount}条,共${page.count}条
                    </div>
                    <!-- 设置左面CSS -->
                    <c:if test="${(!cssfloat eq 'left') or (empty cssfloat)}">
                </div>
                <div class="col-xs-6">
                    </c:if>
                    <!-- 设置左面CSS -->
                    <div class="dataTables_paginate paging_bootstrap" style="${cssfloat eq 'left' ?'text-align:left':'' }" >
                        <ul class="pagination" style="${cssfloat eq 'left' ?'margin:0px':'' }">
                            <!-- 首页 -->
                            <li class="prev ${page.firstPage?'disabled':''}">
                                <!-- 当不为第一页时 -->
                                <c:if test="${!page.firstPage}">
                                    <a href="javascript:;" onclick="${page.pageFunctionName}('1','${page.pageSize}');">
                                        <i class="fa fa-angle-double-left"></i>
                                    </a>
                                </c:if>
                                <!-- 当为第一页时 -->
                                <c:if test="${page.firstPage}">
                                    <a href="javascript:;">
                                        <i class="fa fa-angle-double-left"></i>
                                    </a>
                                </c:if>
                            </li>
                            <!-- 上一页 -->
                            <li class="prev ${page.hasPrePage ?'':'disabled'}">
                                <!-- 上一页有数据 -->
                                <c:if test="${page.hasPrePage}">
                                    <a href="javascript:;" onclick="${page.pageFunctionName}('${page.prePage}','${page.pageSize}');">
                                        <i class="fa fa-angle-left"></i>
                                    </a>
                                </c:if>
                                <!-- 上一页无数据 -->
                                <c:if test="${!page.hasPrePage}">
                                    <a href="javascript:;">
                                        <i class="fa fa-angle-left"></i>
                                    </a>
                                </c:if>
                            </li>
                            <c:forEach  items="${page.slider}" var="slider">
                                <c:if test="${fns:isDisabledPage(page.totalPages,page.pageNo,slider)}">
                                    <li class="active">
                                        <a href="javascript:;">
                                                ${slider}
                                        </a>
                                    </li>
                                </c:if>
                                <c:if test="${!fns:isDisabledPage(page.totalPages,page.pageNo,slider)}">
                                    <li>
                                        <a href="javascript:;"  onclick="${page.pageFunctionName}('${slider}','${page.pageSize}');">
                                                ${slider}
                                        </a>
                                    </li>
                                </c:if>
                            </c:forEach>
                            <!-- 下一页 -->
                            <li class="next ${page.hasNextPage?'':'disabled'}">
                                <!-- 下一页无数据 -->
                                <c:if test="${!page.hasNextPage}">
                                    <a href="javascript:;">
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </c:if>
                                <!-- 下一页有数据 -->
                                <c:if test="${page.hasNextPage}">
                                    <a href="javascript:;" onclick="${page.pageFunctionName}('${page.nextPage}','${page.pageSize}');">
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </c:if>
                            </li>
                            <!-- 尾页 -->
                            <li class="disabled">
                                <a href="javascript:;" style="padding:4px 12px 4px 12px;">
                                    当前第
                                    <input type="text" value="${page.pageNo}" onclick="this.select();" style="width:30px;margin:0;padding:0;text-align:center;" onkeypress="var e=window.event||event||this;var c=e.keyCode||e.which;if(c==13)${page.pageFunctionName}(this.value,'${page.pageSize}');">
                                    页
                                    /
                                    每页显示
                                    <input type="text" value="${page.pageSize}" onclick="this.select();" style="width:30px;margin:0;padding:0;text-align:center;" onkeypress="var e=window.event||event||this;var c=e.keyCode||e.which;if(c==13)${page.pageFunctionName}('${page.pageSize}',this.value);">
                                    条,
                                    共${page.count}条

                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</c:if>