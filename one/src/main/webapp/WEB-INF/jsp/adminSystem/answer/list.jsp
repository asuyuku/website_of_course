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
    <title>作业列表</title>
</head>
<body>
<div class="pd-20">

    <table class="table table-border table-bordered table-bg table-hover">
        <thead>
        <tr>
            <th>编号</th>
            <th>标题</th>
            <th>发布人</th>
<%--            <th>操作<button class="btn size-M radius" onclick="showLayer('添加','<%=ctxPath%>/addHomework/${type}')"> 添加</button></th>--%>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${answerList}" var="answer">
                <tr>
                    <td>${answer.id}</td>
                    <td>${answer.content}</td>
                    <td>${answer.userName}</td>
                    <td>
                        <button class="btn size-MINI radius" onclick="showLayer('详情','<%=ctxPath%>/answer/update/${answer.id}')">详情</button>
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
