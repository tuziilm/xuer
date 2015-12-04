<%@include file="../../include/common.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:set var="_pageTitle" value="创建文章" scope="request"/>
<c:set var="_underArticle" value="active" scope="request"/>
<c:set var="_activeArticle" value="active" scope="request"/>
<c:set var="_module" value="article" scope="request"/>
<c:import url="../../theme/${_theme}/header.jsp"></c:import>
<!-- main content -->
		<div class="page-header"><h1>创建/修改文章</h1></div>
		<div id="pageContent">
			<c:import url="../../theme/${_theme}/errors.jsp"></c:import>
			<form action="${basePath}article/article/save" method="post" class="form-horizontal">
				<input name="id" type="hidden" value="${form.id}">
				<input name="_queryString" type="hidden" value="${param.queryString}">
				<div class="control-group required-field">
				  <label class="control-label">标题:</label>
				  <div class="controls">
				    <input name="title" value="${fn:escapeXml(form.title)}" type="text" class="input-large">
				  </div>
				</div>
				<div class="control-group required-field">
					<label class="control-label">类别:</label>
					<div class="controls">
						<select id="type_sel" name="type" class="input-large">
							<option value="0">未知</option>
							<c:forEach var="type" items="${types}">
								<option value="${type.id}">${type.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<script type="text/javascript">
					document.getElementById("type_sel").value='${xuer:defVal(form.type,0)}';
				</script>
				<div class="control-group required-field">
					<label class="control-label">内容:</label>
					<div class="controls">
						<textarea rows="15" class="input-xxlarge" name="content">${fn:escapeXml(form.content)}</textarea>
					</div>
				</div>
				<div class="control-group required-field">
				  <label class="control-label">备注:</label>
				  <div class="controls">
				    <input name="remark" value="${fn:escapeXml(form.remark)}" type="text" class="input-large">
				  </div>
				</div>
				<div class="form-actions">
				  <input class="btn btn-primary" type="submit" value="保存">
				  <button type="button" class="btn" onclick="javascript:history.go(-1)">取消</button>
				</div>
			</form>
        </div>
<!-- end main content -->
<c:import url="../../theme/${_theme}/footer.jsp"></c:import>
