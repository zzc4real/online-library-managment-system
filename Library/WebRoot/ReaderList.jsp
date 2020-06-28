<%@ page import="java.util.ArrayList" %>
<%@ page import="Entity.Reader" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<html>
<%
    request.setCharacterEncoding("utf-8");
    if(session.getAttribute("adminname") == null){
        response.sendRedirect("/Library/index.jsp");
    }
    ArrayList<Reader> readerlist = (ArrayList<Reader>)session.getAttribute("readerlist");
%>
<head>
    <title>读者列表</title>
</head>
<body>
<h1 align="center">欢迎进入图书馆管理系统</h1>
<jsp:include page="nav.html"/>

<table class="table">
    <thead>
    <tr>
<!-- 姓名 学号 证件号（0:未办理） 密码（0:未办理）证件状态(0未办 1在 2挂失) 性别 年龄 专业 黑名单(1正0非) -->
        <th>姓名</th>
        <th>学号</th>
        <th>借书证ID</th>
        <th>密码</th>
        <th>证件状态</th>
        <th>性别</th>
        <th>年龄</th>
        <th>专业</th>
        <th>是否为黑名单</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <%
        String status = null;
        String edit = null;
        String state = null;
        if(readerlist!=null && readerlist.size() > 0)
        {
            for (int i = 0; i < readerlist.size(); i++)
            {
                Reader reader = readerlist.get(i);
    %>
    <tr>
<!-- 姓名 学号 证件号（0:未办理） 密码（0:未办理）证件状态(0未办 1在 2挂失) 性别 年龄 专业 黑名单(1正0非) -->
        <td><%=reader.getreadername()%></td>
        <td><%=reader.getStuID()%></td>
        <td><%=reader.getCertiID()%></td>
        <td><%=reader.getPassword()%></td>
        <%
        	if(reader.getState() == 0) state = "未办";
        	else if(reader.getState() == 1) state = "在";
        	else if(reader.getState() == 2) state = "挂失";
        	else state = "错误";
         %>
        <td><%=state%></td>
        <%
            status = (reader.getStatus() == 1)?"正常":"黑名单";
            edit = (reader.getStatus() == 1)?"设置成黑名单":"设置为正常";
        %>
        <td><%=reader.getSex()%></td>
        <td><%=reader.getAge()%></td>
        <td><%=reader.getMajor()%></td>
        <td><%=status%></td>
        <td><a href="ReaderAction?action=SetBlackList&id=<%=reader.getreadername()%>&edit=<%=edit%>"><%=edit%></a></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
