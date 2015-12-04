<%@ include file="../include/common.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<link rel="stylesheet" href="${basePath}static/jquery/jquery-ui.css"/>
<div id="search">
    <form id="search_form" method="post" class="form-inline pull-right" action="/operation_log/list">
         <label>用户:</label>
        <select name="userId" id="userId_sel" class="input-small">
        <option value="">全部</option>
            <c:forEach items="${sysUserMap}" var="u">
                <option value="${u.key}">${u.value.username}</option>
            </c:forEach>
        </select>
        <script type="text/javascript">
            document.getElementById("userId_sel").value = '${xuer:defVal(param.userId,"")}';
        </script>
        <label>类型:</label>
        <select name="type" id="type_sel" class="input-small">
            <option value="">全部</option>
            <c:forEach items="${operationLogTypes}" var="olt">
                <option value="${olt.value}">${olt.name}</option>
            </c:forEach>
        </select>
        <script type="text/javascript">
            document.getElementById("type_sel").value = '${xuer:defVal(param.type,"")}';
        </script>
        <label>开始时间:</label>
        <input value="${xuer:defVal(param.startTime,xuer:nowDateString("yyyy/MM/dd"))}" type="text"
               name="startTime" class="input-small" id="startTime"/>
        <label>截止时间:</label>
        <input value="${xuer:defVal(param.endTime,xuer:nowDateString("yyyy/MM/dd"))}" type="text" name="endTime"
               class="input-small" id="endTime"/>
        <input type="submit" class="btn" value="查询"/>
    </form>
</div>
