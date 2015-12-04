<%@include file="../../include/common.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:set var="_pageTitle" value="文章类别管理" scope="request"/>
<c:set var="_underArticleType" value="active" scope="request"/>
<c:set var="_activeArticle" value="active" scope="request"/>
<c:set var="_module" value="article" scope="request"/>
<c:import url="../../theme/${_theme}/header.jsp"></c:import>
<!-- main content -->
	<div class="page-header"><h1>文章类别管理</h1></div>
	<c:import url="../../theme/${_theme}/name_search.jsp">
		<c:param name="action">${basePath}article/type/list</c:param>
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
							<th>名称</th>
							<th>备注</th>
						</tr>
						<c:forEach var="data" items="${datas}">
							<tr>
								<td class="checkbox_td"><input type="checkbox" name="ids" value="${data.id}"/></td>
								<td>${data.id}</td>
								<td>${data.name}</td>
								<td>${fn:escapeXml(data.remark)}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
		<div class="row-fluid">
			<div class="span4 toolbar">
				<c:import url="../../theme/${_theme}/toolbar.jsp">
					<c:param name="create">${basePath}article/type/create</c:param>
					<c:param name="delete">${basePath}article/type/delete</c:param>
					<c:param name="modify">${basePath}article/type/modify</c:param>
				</c:import>
			</div>
			<div class="span8 paginator">
				<c:import url="../../theme/${_theme}/paginator.jsp"></c:import>
			</div>
		</div>
<!-- end main content -->
<c:import url="../../theme/${_theme}/footer.jsp"></c:import>