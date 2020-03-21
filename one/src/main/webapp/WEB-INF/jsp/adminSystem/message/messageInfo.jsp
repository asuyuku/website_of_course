<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <%@include file="/header.jsp" %>
    <c:if test="${type==1}"><title>留言列表</title></c:if>
</head>
<body>
<div class="pd-20">
    <form action="<%=ctxPath%>/updateMessage" method="post" class="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-2">标题</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="title" value="${message.title}" />
            </div>
            <div class="col-5"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-2">内容</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="content" value="${message.content}" />
            </div>
            <div class="col-5"></div>
        </div>
        <input type="hidden" class="input-text" name="type" value="${message.type}" />
        <div class="row cl">
            <div class="col-9 col-offset-2">
                <input class="btn btn-primary radius" type="submit" value="保存" />
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