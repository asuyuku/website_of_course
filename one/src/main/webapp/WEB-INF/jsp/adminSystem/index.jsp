<!DOCTYPE HTML>
<html>
<head>
	<%@include file="/header.jsp" %>
	<link href="<%=ctxPath%>/static/skin/blue/skin.css" rel="stylesheet" type="text/css" id="skin" />
<title>《数据结构》网络作业提交与批改系统</title>
</head>
<body>
<header class="Hui-header cl"> 
    <a class="Hui-logo l" title="《数据结构》网络作业提交与批改系统">《数据结构》网络作业提交与批改系统</a>
	<ul class="Hui-userbar">
		<li class="dropDown dropDown_hover"><a class="dropDown_A">${sessionScope.adminUser.userName } <i class="Hui-iconfont">&#xe6d5;</i></a>
			<ul class="dropDown-menu radius box-shadow">
				<li><a onclick="showLayer('修改密码','<%=ctxPath%>/adminUser/updatePassword',600,371)">修改密码</a></li>
				<li><a href="<%=ctxPath%>/adminUser/logout">退出</a></li>
			</ul>
		</li>
		<li id="Hui-skin" class="dropDown right dropDown_hover"><a href="javascript:;" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
			<ul class="dropDown-menu radius box-shadow">
				<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
				<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
				<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
				<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
				<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
				<li><a href="javascript:;" data-val="orange" title="绿色">橙色</a></li>
			</ul>
		</li>
	</ul>
	<a aria-hidden="false" class="Hui-nav-toggle" href="#"></a> </header>
    <aside class="Hui-aside">
    	<input runat="server" id="divScrollValue" type="hidden" value="" />
    	<div class="menu_dropdown bk_2">
    		<%--<dl id="menu-picture">
    			<dt><i class="Hui-iconfont">&#xe613;</i> 教学管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
    			<dd>
    				<ul>
                        <li><a _href="<%=ctxPath %>/subject/list.do" href="javascript:;">学科管理</a></li>
    					<li><a _href="<%=ctxPath %>/user/list.do" href="javascript:void(0)">教师管理</a></li>
						&lt;%&ndash;<li><a _href="<%=ctxPath %>/userJob/listAll.do" href="javascript:void(0)">兼职工作查看</a></li>&ndash;%&gt;
    				</ul>
    			</dd>
    		</dl>--%>

			<%--<dl id="menu-workload">
				<dt><i class="Hui-iconfont">&#xe627;</i> 工作量管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
				<dd>
					<ul>
						<li><a _href="<%=ctxPath %>/workload/allWorkload.do" href="javascript:;">总工作量</a></li>
						<li><a _href="<%=ctxPath %>/workload/parttimeJob.do" href="javascript:;">兼职工作量</a></li>
						<li><a _href="<%=ctxPath %>/workload/userStuManage.do" href="javascript:;">学生管理工作量</a></li>
						<li><a _href="<%=ctxPath %>/workload/practiceTeaching.do" href="javascript:;">实践教学工作量</a></li>
						<li><a _href="<%=ctxPath %>/workload/classroomTheory.do" href="javascript:;">课堂理论教学工作量</a></li>
						<li><a _href="<%=ctxPath %>/workload/classroomExperiment.do" href="javascript:;">课堂实验教学工作量</a></li>
						<li><a _href="<%=ctxPath %>/workload/guidance.do" href="javascript:;">学业、社团指导工作量</a></li>

					</ul>
				</dd>
			</dl>--%>
			<dl id="menu-workload">
				<dt><i class="Hui-iconfont">&#xe627;</i> 用户管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
				<dd>
					<ul>
						<li><a _href="<%=ctxPath %>/adminUser/add" href="javascript:;">添加用户</a></li>
						<li><a _href="<%=ctxPath %>/adminUser/list" href="javascript:;">用户列表</a></li>

					</ul>
				</dd>
			</dl>
			<dl id="menu-workload">
				<dt><i class="Hui-iconfont">&#xe627;</i> 作业管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
				<dd>
					<ul>
						<li><a _href="<%=ctxPath %>/homework/add" href="javascript:;">发布作业</a></li>
						<li><a _href="<%=ctxPath %>/homework/list" href="javascript:;">作业列表</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-workload">
				<dt><i class="Hui-iconfont">&#xe627;</i>留言管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
				<dd>
					<ul>
						<li><a _href="<%=ctxPath %>/message/list/1" href="javascript:;">留言列表</a></li>

					</ul>
				</dd>
			</dl>

    		<%--<dl id="menu-comments">--%>
    			<%--<dt><i class="Hui-iconfont">&#xe62e;</i>系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>--%>
    			<%--<dd>--%>
    				<%--<ul>--%>
                        <%--<li><a _href="<%=ctxPath %>/adminUser/list.do" href="javascript:void(0)">管理员用户管理</a></li>--%>
                        <%--<li><a _href="<%=ctxPath %>/role/list.do" href="javascript:void(0)">角色管理</a></li>--%>
                        <%--<li><a _href="<%=ctxPath %>/permission/list.do" href="javascript:void(0)">权限管理</a></li>    					--%>
    				<%--</ul>--%>
    			<%--</dd>--%>
    		<%--</dl>--%>
    	</div>
    </aside>
<div class="dislpayArrow"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active"><span title="我的桌面" data-href="welcome.html">我的桌面</span><em></em></li>
			</ul>
		</div>
		<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
	</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="<%=ctxPath %>/welcome.do"></iframe>
		</div>
	</div>
</section>

</body>

</html>