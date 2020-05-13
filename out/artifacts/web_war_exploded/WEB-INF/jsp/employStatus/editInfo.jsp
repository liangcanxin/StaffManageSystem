<%--
  Created by IntelliJ IDEA.
  User: master
  Date: 2020/5/12
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<c:choose>
    <c:when test="${status.month!=0}">
        <div class="pt-2"></div>
        <form action="/status/save" method="post" class="w-75">
            <div class="form-group row">
                <label for="inputMonth" class="col-sm-2 col-form-label">月份</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputMonth" name="month" value="${status.month}" style="padding: 0;" required readonly>
                </div>
            </div>
            <div class="form-group row">
                <label for="inputName" class="col-sm-2 col-form-label">员工姓名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputName" name="name" value="${status.name}" style="padding: 0;" required readonly>
                </div>
            </div>
            <div class="form-group row">
                <label for="inputAttend" class="col-sm-2 col-form-label">本月出勤情况</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="inputAttend" name="attendDay" value="${status.attendDay}" style="padding: 0;" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="inputSubsidy" class="col-sm-2 col-form-label">本月加班情况</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="inputSubsidy" name="subsidyDay" value="${status.subsidyDay}" style="padding: 0;" required>
                </div>
            </div>
            <button type="submit" class="btn btn-primary mb-2">保存</button>
        </form>
    </c:when>
    <c:otherwise>
        <div class="pt-2"></div>
        <form action="/status/create/save" method="post" class="w-75">
            <div class="form-group row">
                <label for="inputCreateMonth" class="col-sm-2 col-form-label">月份</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="inputCreateMonth" name="month" value="${status.month}" style="padding: 0;" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="inputCreateName" class="col-sm-2 col-form-label">员工姓名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputCreateName" name="name" value="${status.name}" style="padding: 0;" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="inputCreateAttend" class="col-sm-2 col-form-label">本月出勤情况</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="inputCreateAttend" name="attendDay" value="${status.attendDay}" style="padding: 0;" required>
                </div>
            </div>
            <div class="form-group row">
                <label for="inputCreateSubsidy" class="col-sm-2 col-form-label">本月加班情况</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="inputCreateSubsidy" name="subsidyDay" value="${status.subsidyDay}" style="padding: 0;" required>
                </div>
            </div>
            <button type="submit" class="btn btn-primary mb-2">保存</button>
        </form>
    </c:otherwise>
</c:choose>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
