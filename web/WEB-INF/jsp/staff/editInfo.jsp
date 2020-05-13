<%--
  Created by IntelliJ IDEA.
  User: master
  Date: 2020/5/1
  Time: 19:36
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
    <form action="/staff/save" method="post" class="w-75">
        <input type="hidden" name="id" value="${staff.id}">
        <div class="form-group row">
            <label for="inputName" class="col-sm-2 col-form-label">姓名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputName" name="name" value="${staff.name}" style="padding: 0;" required>
            </div>
        </div>
        <div class="form-group row">
            <label for="inputApartment" class="col-sm-2 col-form-label">入职部门</label>
            <select id="inputApartment" class="form-control col-sm-10" name="staffDepartment" value="${staff.staffDepartment}">
                <option disabled>--请选择入职部门--</option>
                <option>人事行政部</option>
                <option>质管部</option>
                <option>采购部</option>
                <option>财务部</option>
                <option>市场营销部</option>
            </select>
        </div>
        <div class="form-group row">
            <label for="inputDuty" class="col-sm-2 col-form-label">入职岗位</label>
            <select id="inputDuty" class="form-control col-sm-10" name="staffDuty" value="${staff.staffDuty}">
                <option disabled>--请选择入职岗位--</option>
                <option>总经理</option>
                <option>副总经理</option>
                <option>部门经理</option>
                <option>部门副经理</option>
                <option>基层员工</option>
                <option>实习生</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary mb-2">保存</button>
    </form>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>
