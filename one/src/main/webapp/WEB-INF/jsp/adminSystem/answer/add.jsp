<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <%@include file="/header.jsp" %>
    <title>作业作答</title>
</head>
<body>
<div class="pd-20">
    <form id="form-answer" action="<%=ctxPath%>/answer/addAnswer" method="post" enctype="multipart/form-data" class="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-2">作业标题</label>
            <div class="formControls col-5">
                <input type="text" readonly class="input-text" name="content" value="${homework.title}" />
            </div>
            <div class="col-5"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-2">作业内容</label>
            <div class="formControls col-5">
                <input type="text" readonly class="input-text" value="${homework.content}" />
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
            <label class="form-label col-2">作答内容</label>
            <div class="formControls col-5">
                <input type="file"  name="file"/>
            </div>
            <div class="col-5"></div>
        </div>
<%--        <div class="row cl">--%>
<%--            <label class="form-label col-2">批改结果</label>--%>
<%--            <div class="formControls col-2">--%>
<%--                <span class="btn-upload form-group">--%>
<%--&lt;%&ndash;                  <input class="input-text upload-url radius" type="text" name="uploadfile" id="uploadfile" readonly><a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览文件</a>&ndash;%&gt;--%>
<%--                  <input type="file" name="fileNameTwo">--%>
<%--                </span>--%>
<%--            </div>--%>
<%--            <div class="col-5"></div>--%>
<%--        </div>--%>
        <input type="hidden" name="status" value="0">
        <input type="hidden" name="homeworkId" value="${homework.id}">


        <div class="row cl">
            <div class="col-9 col-offset-2">
                <input class="btn btn-primary radius" type="button" onclick="formSubmit()" value="添加" />
                <input class="btn btn-default radius" type="button" value="关闭" onclick="parent.location.reload()" style="margin-left: 30px;" />
        </div>
        </div>
    </form>
    <script type="text/javascript">
        // $(function(){
        //     $("form").validate({
        //         rules:{
        //             title:{
        //                 required:true
        //             },
        //             content:{
        //                 required:true
        //             }
        //         },
        //         messages:{
        //             title:{
        //                 required:"标题不能为空"
        //             },
        //             content:{
        //                 required:"内容不能为空"
        //             }
        //         },
        //         submitHandler:function(form)
        //         {
        //             ajaxSubmitForm(form,true);
        //         }
        //     });
        // });
        function formSubmit()
        {
            var data=new FormData($("#form-answer")[0]);
            $.ajax({
                url:'<%=ctxPath%>/answer/addAnswer',
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