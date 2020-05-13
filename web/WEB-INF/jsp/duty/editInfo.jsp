<%--
  Created by IntelliJ IDEA.
  User: master
  Date: 2020/5/11
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<div class="pt-2"></div>
<form action="/duty/save" method="post" class="w-75">
    <input type="hidden" name="id" value="${duty.id}">
    <div class="form-group row">
        <label for="inputName" class="col-sm-2 col-form-label">职务名称</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputName" name="name" value="${duty.name}" style="padding: 0;" required readonly>
        </div>
    </div>
    <div class="form-group row">
        <label for="inputSalary" class="col-sm-2 col-form-label">对应的基本工资</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputSalary" name="baseSalary" value="${duty.baseSalary}" style="padding: 0;" required>
        </div>
    </div>
    <button type="submit" class="btn btn-primary mb-2">保存</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>