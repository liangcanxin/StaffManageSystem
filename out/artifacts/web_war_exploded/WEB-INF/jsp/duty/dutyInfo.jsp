<%--
  Created by IntelliJ IDEA.
  User: master
  Date: 2020/5/1
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="pt-2"></div>
<div class="card w-75">
    <div class="card-header">职务</div>
    <div class="card-body">
        <p class="card-text">基本职务有：总经理、部门经理、基层员工。</p>
        <p class="card-text">所任职务不同，相应的基本工资也不同。</p>
        <p class="card-text">具体差异见下表。</p>
    </div>
</div>
<table class="table table-hover table-bordered w-75 text-center">
    <caption style="caption-side:top;">
        职务信息基本表&nbsp;&nbsp;&nbsp;&nbsp;
    </caption>
    <thead class="thead-light">
    <tr>
        <th scope="col">#</th>
        <th scope="col">职务编号</th>
        <th scope="col">职务名称</th>
        <th scope="col">对应基本工资</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${duties}" var="duty" varStatus="status">
        <tr>
            <th scope="row">${status.count}</th>
            <td>${duty.id}</td>
            <td>${duty.name}</td>
            <td>${duty.baseSalary}</td>
            <td>
                <a href="/duty/update?id=${duty.id}"><button type="button" class="btn btn-success btn-sm">编辑</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
