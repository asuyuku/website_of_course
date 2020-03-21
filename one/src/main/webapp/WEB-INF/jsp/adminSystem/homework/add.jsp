<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <%@include file="/header.jsp" %>
    <title>添加作业</title>
</head>
<body>
<div class="pd-20">
    <form id="form-homework" action="<%=ctxPath%>/homework/addHomework" method="post" enctype="multipart/form-data" class="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-2">标题</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="title" />
            </div>
            <div class="col-5"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-2">内容</label>
            <div class="formControls col-5">
                <input type="text"  class="input-text" name="content" />
            </div>

            <div class="col-5"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-2">附件</label>
            <div class="formControls col-2">
                <span class="btn-upload form-group">
<%--                  <input class="input-text upload-url radius" type="text" name="uploadfile" id="uploadfile" readonly><a href="javascript:void();" class="btn btn-primary radius"><i class="iconfont">&#xf0020;</i> 浏览文件</a>--%>
                  <input type="file" name="file">
                </span>
            </div>
            <div class="col-5"></div>
        </div>
        <div class="row cl">
            <div class="col-9 col-offset-2">
                <input class="btn btn-primary radius" type="button" onclick="formSubmit()" value="添加" />
                <input class="btn btn-default radius" type="button" value="关闭" onclick="parent.location.reload()" style="margin-left: 30px;" />
        </div>
        </div>
    </form>
    <script type="text/javascript">
        function formSubmit()
        {
            var data=new FormData($("#form-homework")[0]);
            $.ajax({
                url:'<%=ctxPath%>/homework/addHomework',
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