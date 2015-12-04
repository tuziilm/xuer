<%@include file="../include/common.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:set var="_pageTitle" value="操作日志" scope="request"/>
<c:set var="_underOperationLog" value="active" scope="request"/>
<c:set var="_activeSystem" value="active" scope="request"/>
<c:set var="_module" value="system" scope="request"/>
<c:import url="../theme/${_theme}/header.jsp"></c:import>
<!-- main content -->
	<div class="page-header"><h1>操作日志</h1></div>
	<c:import url="search.jsp">
	</c:import>
		<div id="list">
			<table class="table table-bordered table-striped">
				<c:choose>
					<c:when test="${not hasDatas}">
						<tr>
							<td>没有记录!</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<th>用户</th>
							<th>类型</th>
							<th>时间</th>
                            <th>信息</th>
                            <th>操作</th>
						</tr>
						<c:forEach var="data" items="${datas}" varStatus="it">
							<tr>
								<td>${sysUserMap[data.userId].username}</td>
								<td>${operationLogTypeMap[data.type].name}</td>
                                <td><fmt:formatDate value="${data.gmtCreate}" pattern="yyyy/MM/dd HH:mm:ss" var="gmtCreate"/>${gmtCreate}</td>
                                <td>${fn:substring(data.msg, 0, 100)}</td>
                                <td class="operation operand1">
                                    <a class="btn btn-small btn-info" onclick="javascript:showDetail(${it.count},this);return false;"><i class="icon-plus-sign icon-white"></i>详情</a>
                                </td>
							</tr>
                            <tr id="detail_${it.count }" style="display: none">
                                <td colspan="5">
                                    <ul>
                                        <li><strong>信息：</strong><pre>${fn:escapeXml(data.msg)}</pre></li>
                                    </ul>
                                </td>
                            </tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
		<div class="row-fluid">
            <div class="span4 toolbar"></div>
			<div class="span8 paginator">
				<c:import url="../theme/${_theme}/paginator.jsp"></c:import>
			</div>
		</div>
<!-- end main content -->
<c:import url="../theme/${_theme}/footer.jsp">
</c:import>
<script src="${basePath}static/jquery/jquery-ui.js"></script>
<script src="${basePath}static/jquery/jquery.ui.datepicker-zh-TW.js"></script>
<script>
    $(function() {
        $( "#startTime" ).datepicker( $.datepicker.regional[ "zh-TW" ] );
        $( "#endTime" ).datepicker( $.datepicker.regional[ "zh-TW" ] );
    });
</script>
