<%--
  Created by IntelliJ IDEA.
  User: master
  Date: 2020/5/13
  Time: 16:47
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
<form action="/salary/retrieve" method="get" class="form-inline" target="main" style="margin-bottom: 5px;margin-top: 5px">
    <div class="form-group row">
        <select id="inputMonth" class="form-control" style="margin-left:20px;margin-right: 40px;" name="month">
            <option disabled>--请选择月份--</option>
            <option>所有月份</option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
            <option>10</option>
            <option>11</option>
            <option>12</option>
        </select>
    </div>
    <div class="form-group row">
        <select id="inputApartment" class="form-control" style="margin-right: 24px;" name="department">
            <option disabled>--请选择入职部门--</option>
            <option>所有部门</option>
            <option>人事行政部</option>
            <option>质管部</option>
            <option>采购部</option>
            <option>财务部</option>
            <option>市场营销部</option>
        </select>
    </div>
    <input class="form-control mr-sm-2" type="search" placeholder="请输入“所有员工”或具体员工的部分或完整姓名" aria-label="Search" style="width: 375px" name="name" type="text" required>
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
</form>
<table class="table table-hover table-bordered w-75 text-center">
    <caption style="caption-side:top;">
        员工工资表
    </caption>
    <thead class="thead-light">
    <tr>
        <th scope="col">#</th>
        <th scope="col">月份</th>
        <th scope="col">员工号</th>
        <th scope="col">员工姓名</th>
        <th scope="col">所属部门</th>
        <th scope="col">考勤奖金</th>
        <th scope="col">加班津贴</th>
        <th scope="col">基本工资</th>
        <th scope="col">总工资</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${salaries==null && salary.month!=0}">
            <tr>
                <th scope="row">1</th>
                <td>${salary.month}</td>
                <td>${salary.id}</td>
                <td>${salary.name}</td>
                <td>${salary.department}</td>
                <td>${salary.attendSubsidy}</td>
                <td>${salary.overtimeSubsidy}</td>
                <td>${salary.baseSalary}</td>
                <td>${salary.totalSalary}</td>
            </tr>
            <tr>
                <td colspan="9" align="right" class="border-top-0">
                    &nbsp;&nbsp;&nbsp;当前的查询结果，共 1 条员工工作记录信息
                </td>
            </tr>
        </c:when>
        <c:otherwise>
            <c:forEach items="${salaries}" var="salary" varStatus="varStatus">
                <tr>
                    <th scope="row">${varStatus.count}</th>
                    <td>${salary.month}</td>
                    <td>${salary.id}</td>
                    <td>${salary.name}</td>
                    <td>${salary.department}</td>
                    <td>${salary.attendSubsidy}</td>
                    <td>${salary.overtimeSubsidy}</td>
                    <td>${salary.baseSalary}</td>
                    <td>${salary.totalSalary}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="9" align="right" class="border-top-0">
                    &nbsp;&nbsp;&nbsp;当前的查询结果，共 ${fn:length(salaries)} 条员工工作记录信息
                </td>
            </tr>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
