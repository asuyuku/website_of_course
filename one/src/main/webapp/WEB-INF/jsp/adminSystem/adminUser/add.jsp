<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@include file="/header.jsp" %>

<title>添加管理员账号</title>
</head>
<body>
<div class="pd-20">
    <form action="<%=ctxPath%>/adminUser/add.do" method="post" class="form form-horizontal">
        <div class="row cl">
            <label class="form-label col-2">姓名</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="userName" />
            </div>
            <div class="col-5"></div>
        </div>
        <div class="row cl">
            <label class="form-label col-2">管理员账号</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="adminName" />
            </div>
            <div class="col-5"></div>
        </div>

        <div class="row cl">
            <label class="form-label col-2">电话</label>
            <div class="formControls col-5">
                <input type="text" class="input-text" name="adminPhone" />
            </div>
            <div class="col-5"></div>
        </div>

        <div class="row cl">
            <label class="form-label col-2">密码</label>
            <div class="formControls col-5">
                <input type="password" class="input-text" name="password" />
            </div>
            <div class="col-5"></div>
        </div>

        <div class="row cl">
            <label class="form-label col-2">类型</label>
            <div class="formControls col-5">
                <select id="type-select" onchange="selectChange()">
                    <option value="1">老师</option>
                    <option value="2" selected>学生</option>
                </select>
            </div>
            <div class="col-5"></div>
            <input type="hidden" id="type" name="type" value="2">
        </div>
        <script>
           function selectChange() {
                var type=$("#type-select").find("option:selected").val();
                $("#type").val(type);
                if(type==2)
                {
                    $("#teacher-div").show();
                }
                else {
                    $("#teacher-div").hide();
                }
            }
        </script>
        <div id="teacher-div">
        <div class="row cl">
            <label class="form-label col-2">教师</label>
            <div class="formControls col-5">
                <select id="teacher-select" onchange="teacherSelectChange()">
                    <c:forEach items="${teacherList}" var="teacher">
                        <option value="${teacher.adminId}">${teacher.userName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-5"></div>
            <input type="hidden" id="teacherId" name="teacherId" value="0">
        </div>
        </div>
        <script>
            function teacherSelectChange() {
                var teacherId=$("#teacher-select").find("option:selected").val();
                $("#teacherId").val(teacherId);
            }
        </script>
        <div class="row cl">
            <div class="col-9 col-offset-2">
                <input class="btn btn-primary radius" type="submit" value="添加" />
                <input class="btn btn-default radius" type="button" value="关闭" onclick="parent.location.reload()" style="margin-left: 30px;" />
            </div>
        </div>
    </form>
    <script type="text/javascript">
        $(function(){
            $("form").validate({
                rules:{
                    account:{
                        required:true
                    },
                    password:{
                        required:true
                    }
                },
                messages:{
                    account:{
                        required:"账号不能为空"
                    },
                    password:{
                        required:"密码不能为空"
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