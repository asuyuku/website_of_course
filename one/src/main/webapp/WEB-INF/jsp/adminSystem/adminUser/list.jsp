<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/header.jsp" %>

<title>管理员用户列表</title>
</head>
<body>
<div class="pd-20">
    <%--<table class="table table-border table-bordered table-bg table-hover">
        <thead>
            <tr>
                <th>管理员账号</th>
                <th>状态</th>
                <th>操作 <button class="btn size-M radius" onclick="showLayer('添加管理员','<%=ctxPath%>/adminUser/add')"> 添加</button></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${adminUserList}" var="adminUser">
                <tr>
                    <td>${adminUser.account}</td>
                    <c:if test="${adminUser.isDisabled==false}"><td><span class="label label-success radius">已启用</span></td></c:if>
                    <c:if test="${adminUser.isDisabled==true}"><td><span class="label label-danger radius">已停用</span></td></c:if>
                    <td>
                        <button class="btn size-MINI radius" onclick="ajaxDelete('<%=ctxPath%>/adminUser/delete.do','id=${adminUser.id}')">删除</button>
                        <button class="btn size-MINI radius" onclick="showLayer('重置密码','<%=ctxPath%>/adminUser/resetPW.do?id=${adminUser.id}')">重置密码</button>
                        <button class="btn size-MINI radius" onclick="ajaxSubmit('<%=ctxPath%>/adminUser/disable.do','adminUserId=${adminUser.id}')" id="disable-switch">禁用/启用</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>--%>
    <table class="table table-border table-bordered table-bg table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>用户名</th>
                <th>昵称</th>
                <th>电话</th>
                <th>状态</th>
                <th>操作<button class="btn size-M radius" onclick="showLayer('添加管理员','<%=ctxPath%>/adminUser/add')"> 添加</button></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${adminUserList}" var="adminUser">
                <tr>
                    <td>${adminUser.adminId}</td>
                    <td>${adminUser.userName}</td>
                    <td>${adminUser.adminName}</td>
                    <td>${adminUser.adminPhone}</td>
                    <c:if test="${adminUser.dataState==1}"><td><span class="label label-success radius">已启用</span></td></c:if>
                    <c:if test="${adminUser.dataState==2}"><td><span class="label label-danger radius">已停用</span></td></c:if>
                    <td>
                        <%--<button class="btn size-MINI radius" onclick="ajaxDelete('<%=ctxPath%>/adminUser/delete.do','id=${adminUser.id}')">删除</button>--%>
                        <%--<button class="btn size-MINI radius" onclick="showLayer('重置密码','<%=ctxPath%>/adminUser/resetPW.do?id=${adminUser.id}')">重置密码</button>--%>
                        <%--<button class="btn size-MINI radius" onclick="ajaxSubmit('<%=ctxPath%>/adminUser/disable.do','adminUserId=${adminUser.id}')" id="disable-switch">禁用/启用</button>--%>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <script type="text/javascript">
        $('#disable-switch').bootstrapSwitch('isActive');
        $('#disable-switch').bootstrapSwitch('toggleActivation');
        $('#disable-switch').bootstrapSwitch('setActive', false);
    </script>
</div>
</body>
</html>