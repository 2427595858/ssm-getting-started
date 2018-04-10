<%--
  Created by IntelliJ IDEA.
  User: 光玉
  Date: 2018/4/7
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>修改商品信息</title>
    <script type="text/javascript" src="<%= request.getContextPath()%>/plugin/layui/layui.all.js"></script>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/plugin/layui/css/layui.css">
</head>

<body>
<form class="layui-form" action="${pageContext.request.contextPath}/items/editItemsSubmit.action" method="post">
    <input type="hidden" name="id" value="${itemCustom.id}">
    <div class="layui-form-item">
        <label class="layui-form-label">商品名称</label>
        <div class="layui-input-inline">
            <input class="layui-input" type="text" name="name" value="${itemCustom.name}"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">商品价格</label>
        <div class="layui-input-inline">
           <input class="layui-input" type="text" name="price" value="${itemCustom.price}"/>
        </div>
    </div>

    <%--<div class="layui-form-item">
        <label class="layui-form-label">商品图片</label>
        <div class="layui-input-inline">
            <input class="layui-input" type="text" name="pic" value="${itemCustom.pic}"/>
        </div>
    </div>--%>

    <div class="layui-form-item">
        <label class="layui-form-label">生产日期</label>
        <div class="layui-input-inline">
            <input class="layui-input" type="text" name="createtime" value="<fmt:formatDate value="${itemCustom.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" />
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">商品详情</label>
        <div class="layui-input-block">
            <textarea class="layui-textarea" name="detail">${itemCustom.detail}</textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" type="submit">提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script>
    layui.use('form', function () {
        var form = layui.form;
        form.render();
    });
</script>

</body>
</html>
