<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <%@include file="/header.jsp" %>
    <title>基本信息</title>
</head>
<body>
<div class="pd-20">
    <form action="<%=ctxPath%>/homework/updateHomework" method="post" class="form form-horizontal">
        <input type="hidden" readonly name="id" value="${id}">
        <div class="row cl">
            <label class="form-label col-2">标题</label>
            <div class="formControls col-5">
                <input type="text" <c:if test="${user.type==2}">readonly</c:if> class="input-text" name="title" value="${homework.title}" />
            </div>
            <div class="col-5"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-2">内容</label>
            <div class="formControls col-5">
                <input type="text" <c:if test="${user.type==2}">readonly</c:if>  class="input-text" name="content" value="${homework.content}" />
            </div>
            <div class="col-5"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-2">附件</label>
            <div class="formControls col-5">
<%--                <input type="file" <c:if test="${user.type==2}">readonly</c:if>  class="input-file" name="file" value="${homework.fileName}" />--%>
                <a href="<%=ctxPath%>/${homework.fileName}" download="${homework.fileName}" >下载附件</a>
            </div>
            <div class="col-5"></div>
        </div>
        <div class="row cl">
            <div class="col-9 col-offset-2">
                <c:if test="${user.type==1}">
                <input class="btn btn-primary radius" type="submit" value="保存" />
                </c:if>
                <input class="btn btn-default radius" type="button" value="关闭" onclick="parent.location.reload()" style="margin-left: 30px;" />
            </div>
        </div>
    </form>
    <script type="text/javascript">
        $(function(){
            $("form").validate({
                rules:{
                    title:{
                        required:true
                    },
                    content:{
                        required:true
                    }
                },
                messages:{
                    title:{
                        required:"标题不能为空"
                    },
                    content:{
                        required:"内容不能为空"
                    }
                },
                submitHandler:function(form)
                {
                    ajaxSubmitForm(form,true);
                }
            });
        });
    </script>
</div>
</body>
</html>