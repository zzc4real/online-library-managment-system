
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">

<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/loginScript.js"></script>

<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<html>
<head>
    <title>图书馆登录</title>
</head>
<body>

<%-- <%
    request.setCharacterEncoding("utf-8");
    if(session.getAttribute("certiID") != null /* && session.getAttribute("logout") == null */)
    {
        response.sendRedirect("/Library/main.jsp");
    }
%> --%>

<div class="welcome">
    <img src="${pageContext.request.contextPath}/image/welcome.jpg" width="1440px" height="800px">
</div>

<div class="Chineseword">
      <span>
          书是人类进步的阶梯 -高尔基
      </span>
</div>

<div class="Englishword">
      <span>
          Books are the stepping stones to human progress. -Gorky
      </span>
</div>

<div class="loginform">
    <div class="col-md-4 column">
        <span id="labellogin">学生登录</span><br>
        <div class="form-group">
            <input type="text" class="form-control" id="certiIDinput" name="certiID" placeholder="借书证ID"/>		<!-- 借书账号 -->
        </div>
        
        <div class="form-group">
            <input type="password" class="form-control" id="stupasswordinput" name="password" placeholder="密码"/>	<!-- 密码 -->
        </div>
        
        <button id="stuloginbutton" class="btn btn-primary" onclick="stulogincheck()">登录</button>
        <button id="certification" class="btn btn-primary" onclick="stuRegister()">还没注册？</button> 
        <button id="administrators" class="btn btn-primary" onclick="rootModule()">管理员</button>
        <span class="errorsubmit" id="checkinfo"></span>
    </div>
</div>

</body>
</html>
