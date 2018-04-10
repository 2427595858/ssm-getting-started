<%--
  Created by IntelliJ IDEA.
  User: 光玉
  Date: 2018/4/3
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<head>
    <title>查询商品列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="<%= request.getContextPath()%>/plugin/layui/layui.all.js"></script>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/plugin/layui/css/layui.css">
</head>
<body>
    <form class="layui-form" action="${pageContext.request.contextPath}/items/queryItems.action" method="post">
        <label class="layui-form-label">查询条件</label>
        <button class="layui-btn" type="submit" value="查询">查询</button>
    </form>

    <table class="layui-table" lay-size="sm">
        <thead>
            <th>商品名称</th>
            <th>商品价格</th>
            <th>商品详情</th>
            <th>生产日期</th>
            <th>操作</th>
        </thead>
        <tbody>
            <c:forEach items="${itemsList}" var="item">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td>${item.detail}</td>
                    <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                    <td>
                        <a class="layui-btn layui-btn-sm" href="${pageContext.request.contextPath}/items/editItems.action?id=${item.id}">修改</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <script>
        layui.use('form', function () {
            var form = layui.form;
            form.render();
        })
    </script>
</body>
</html>
