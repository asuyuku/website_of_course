<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/header.jsp" %>

<title>修改自己的密码</title>
</head>
<body>
<div class="pd-20">
    <form action="<%=ctxPath%>/adminUser/updatePassword.do" method="post" class="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-2">旧密码</label>
            <div class="formControls col-5">
                <input type="password" class="input-text" name="password" />
            </div>
            <div class="col-5"></div>
        </div>

        <div class="row cl">
            <label class="form-label col-2">新密码</label>
            <div class="formControls col-5">
                <input type="password" class="input-text" name="newpassword" id="newpassword" />
            </div>
            <div class="col-5"></div>
        </div>
        
        <div class="row cl">
            <label class="form-label col-2">重复新密码</label>
            <div class="formControls col-5">
                <input type="password" class="input-text" name="renewpassword" />
            </div>
            <div class="col-5"></div>
        </div>
        

        <div class="row cl">
            <div class="col-9 col-offset-2">
                <input class="btn btn-primary radius" type="submit" value="修改" />
                <input class="btn btn-default radius" type="button" value="关闭" onclick="parent.location.reload()" style="margin-left: 30px;" />
            </div>
        </div>
    </form>
    <script type="text/javascript">
        $(function(){
            $("form").validate({
                rules:{
                    password:{
                        required:true
                    },
                    newpassword:{
                        required:true
                    },
                    renewpassword:{
                        required:true,
                        equalTo:" #newpassword "
                    }
                },
                messages:{
                    password:{
                        required:"旧密码不能为空"
                    },
                    newpassword:{
                        required:"新密码不能为空"
                    },
                    renewpassword:{
                        required:"重复新密码不能为空",
                        equalTo:"两次输入新密码不同"
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