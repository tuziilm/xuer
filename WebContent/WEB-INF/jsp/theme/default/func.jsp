<%@ include file="../../include/common.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:choose>
	<c:when test="${_module=='article' }">
		<li class="${_underArticleType}"><a href="${basePath}article/type/list">文章类别</a></li>
		<li class="${_underArticle}"><a href="${basePath}article/article/list">文章</a></li>
	</c:when>
	<c:when test="${_module=='system' }">
		<c:if test="${xuer:isAdmin()}">
			<li class="${_underSysUser}"><a href="${basePath}sysuser/list">系统用户</a></li>
		</c:if>
		<li class="${_underUserInfo}"><a href="${basePath}sysuser/${isUnderUserInfo?'info_modify':'modify'}/${xuer:uid()}">信息修改</a></li>
		<c:if test="${xuer:isAdmin()}">
			<li class="${_underOperationLog}"><a href="${basePath}operation_log/list">操作日志</a></li>
		</c:if>
	</c:when>
</c:choose>
