<%@include file="../../include/common.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:set var="_pageTitle" value="文章管理" scope="request"/>
<c:set var="_underArticle" value="active" scope="request"/>
<c:set var="_activeArticle" value="active" scope="request"/>
<c:set var="_module" value="article" scope="request"/>
<c:import url="../../theme/${_theme}/header.jsp"></c:import>
<!-- main content -->
	<div class="page-header"><h1>文章管理</h1></div>
	<c:import url="../../theme/${_theme}/name_search.jsp">
		<c:param name="action">${basePath}article/article/list</c:param>
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
							<th></th>
							<th>ID</th>
							<th>标题</th>
							<th>类别</th>
							<th>操作</th>
						</tr>
						<c:forEach var="data" items="${datas}" varStatus="it">
							<tr>
								<td class="checkbox_td"><input type="checkbox" name="ids" value="${data.id}"/></td>
								<td>${data.id}</td>
								<td>${data.title}</td>
								<td>${typeMap[data.type].name}</td>
								<td class="operation operand2">
									<a class="btn btn-small btn-info" onclick="javascript:showDetail(${it.count},this);return false;"><i class="icon-plus-sign icon-white"></i>详情</a>
								</td>
							</tr>
							<tr id="detail_${it.count }" style="display: none">
								<td></td>
								<td colspan="9">
									<ul>
										<li><strong>创建时间：</strong><fmt:formatDate value="${data.gmtCreate}" pattern="yyyy/MM/dd HH:mm:ss" var="gmtCreate"/>${gmtCreate}</li>
										<li><strong>更新时间：</strong><fmt:formatDate value="${data.gmtModified}" pattern="yyyy/MM/dd HH:mm:ss" var="gmtModified"/>${gmtModified}</li>
										<li><strong>备注：</strong>${fn:escapeXml(data.remark )}</li>
										<li><strong>文章内容：</strong>${fn:escapeXml(data.content )}</li>
									</ul>
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
		<div class="row-fluid">
			<div class="span4 toolbar">
				<c:import url="../../theme/${_theme}/toolbar.jsp">
					<c:param name="create">${basePath}article/article/create</c:param>
					<c:param name="delete">${basePath}article/article/delete</c:param>
					<c:param name="modify">${basePath}article/article/modify</c:param>
				</c:import>
			</div>
			<div class="span8 paginator">
				<c:import url="../../theme/${_theme}/paginator.jsp"></c:import>
			</div>
		</div>
<!-- end main content -->
<c:import url="../../theme/${_theme}/footer.jsp"></c:import>