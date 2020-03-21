<%--
  Created by IntelliJ IDEA.
  User: tjzha
  Date: 2020/1/31
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <%@include file="/header.jsp" %>
    <c:if test="${type==1}"><title>留言列表</title></c:if>
</head>
<body>
<div class="pd-20">

    <table class="table table-border table-bordered table-bg table-hover">
        <thead>
        <tr>
            <th>编号</th>
            <th>标题</th>
            <th>发布人</th>
            <th>操作<button class="btn size-M radius" onclick="showLayer('添加','<%=ctxPath%>/addMessagePage/${type}')"> 添加</button></th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${messageList}" var="message">
                <tr>
                    <td>${message.id}</td>
                    <td>${message.title}</td>
                    <td>${message.userName}</td>
                    <td>
                        <button class="btn size-MINI radius" onclick="showLayer('详情','<%=ctxPath%>/messageInfo/${message.id}')">详情</button>
                        <button class="btn size-MINI radius" onclick="ajaxSubmit('<%=ctxPath%>/deleteMessage/${message.id}')">删除</button>
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
