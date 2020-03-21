<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <%@include file="/header.jsp" %>
    <title>基本信息</title>
</head>
<body>
<div class="pd-20">
    <form id="form-answer-update" action="<%=ctxPath%>/answer/updateAnswer" method="post" enctype="multipart/form-data" class="form form-horizontal">
        <input type="hidden" readonly name="id" value="${answer.id}">
        <div class="row cl">
            <label class="form-label col-2">标题</label>
            <div class="formControls col-5">
                <input type="text" readonly class="input-text" name="title" value="${answer.content}" />
            </div>
            <div class="col-5"></div>
        </div>

        <div class="row cl">
            <label class="form-label col-2">作答内容</label>
            <div class="formControls col-5">
<%--                <input type="file" <c:if test="${user.type==2}">readonly</c:if>  class="input-file" name="file" value="${homework.fileName}" />--%>
            <a href="<%=ctxPath%>/${answer.fileName}" download="${answer.fileName}" >下载文件</a>
            </div>
            <div class="col-5"></div>
        </div>

        <div class="row cl">
            <label class="form-label col-2">批改内容</label>
            <div class="formControls col-5">
                <c:if test="${user.type==1}">
                    <input type="file"  name="file" />
                </c:if>
                <c:if test="${user.type==2 && answer.status==1}">
                    <a href="<%=ctxPath%>/${answer.fileNameTwo}" download="${answer.fileNameTwo}" >下载文件</a>
                </c:if>
            </div>
            <div class="col-5"></div>
            <input type="hidden" name="status" value="1">
        </div>
        <div class="row cl">
            <div class="col-9 col-offset-2">
                <c:if test="${user.type==1}">
                <input class="btn btn-primary radius" type="button" onclick="formSubmit()" value="保存" />
                </c:if>
                <input class="btn btn-default radius" type="button" value="关闭" onclick="parent.location.reload()" style="margin-left: 30px;" />
            </div>
        </div>
    </form>
    <script type="text/javascript">
        function formSubmit()
        {
            var data=new FormData($("#form-answer-update")[0]);
            $.ajax({
                url:'<%=ctxPath%>/answer/updateAnswer',
                data:data,
                type:'post',
                cache: false,
                processData:false,
                //告诉jQuery不要去设置Content-Type请求头,因为表单已经设置了multipart/form-data
                contentType:false,
                success:function(ajaxResult) {
                    alert(ajaxResult.data);
                    if (ajaxResult.status == 'success') {
                        if (isReloadParent) {
                            parent.location.reload();
                        } else {
                            location.reload();
                        }
                    }
                },error(){
                    alert("error");
                }
            })
        }
    </script>
</div>
</body>
</html>