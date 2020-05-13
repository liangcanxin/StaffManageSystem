<%--
  Created by IntelliJ IDEA.
  User: master
  Date: 2020/5/1
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<table class="table table-hover table-bordered w-75 text-center">
    <caption style="caption-side:top;">
        员工基本信息一览表&nbsp;&nbsp;&nbsp;&nbsp;
         <a href="/staff/create" target="main"><button type="button" class="btn btn-info btn-sm">添加新的员工</button></a>
    </caption>
    <thead class="thead-light">
    <tr>
        <th scope="col">#</th>
        <th scope="col">员工号</th>
        <th scope="col">员工姓名</th>
        <th scope="col">所属部门</th>
        <th scope="col">当前职务</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${staffs}" var="staff" varStatus="status">
        <tr>
            <th scope="row">${status.count}</th>
            <td>${staff.id}</td>
            <td>${staff.name}</td>
            <td>${staff.staffDepartment}</td>
            <td>${staff.staffDuty}</td>
            <td>
                <a href="/staff/delete?id=${staff.id}" onclick="return confirm('确认删除？')"><button type="button" class="btn btn-danger btn-sm">删除</button></a>
                <a href="/staff/update?id=${staff.id}"><button type="button" class="btn btn-success btn-sm">编辑</button></a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6" align="right" class="border-top-0">
            &nbsp;&nbsp;&nbsp;当前的查询结果，共 ${fn:length(staffs)} 条员工信息
        </td>
    </tr>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
