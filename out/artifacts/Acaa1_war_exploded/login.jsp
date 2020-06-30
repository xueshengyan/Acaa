<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/25
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        #jz{
            width: 400px;
            height: 200px;
            margin: 0 auto;
            background-color: aqua;
        }
    </style>
</head>
<body>
    <div id="jz">
        <table>
            <tr><td width="10%"></td></tr>
            <form method="post" action="/login.do">
                <label>用户名：</label>
                <input type="text" name="userName"><br/>
                <label>密码：</label>
                <input type="password" name="password"><br/>
                <input type="submit" value="提交">
            </form>
        </table>

    </div>
    <ul>
        <li><a href="${pageContext.request.contextPath }/user/add">添加用户</a></li>
    </ul>
</body>
</html>
