<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
  <style>
    body {
      height: 100vh;
      display: flex;
      margin: 0;
    }
    aside {
      flex: none;
      width: 200px;
      display: block;
    }
    .content {
      flex: auto;
      display: flex;
      flex-direction: column;
      overflow-y: auto;
    }
    .content article {
      flex: auto;
    }
    header, footer, article, aside {
      min-height: 60px;
      text-align: center;
      display: flex;
      align-items: center;
      justify-content: center;
    }
    .bg{background-color: #4a4d50;color: #6C756F;}
    .bg:hover{background-color: #4c5256;color: #6c757d;}
  </style>
</head>
<body>
<aside class="fixed-top">
  <div class="text-left list-group list-group-flush text-body border-0 bg-secondary" style="width: 200px;">
    <div class="navbar-brand text-muted bg-dark" style="height: 54px;line-height: 46px; width: 200px;">&nbsp;&nbsp;&nbsp;XX公司管理系统</div>
    <div id="accordion-1" class="card border-0">
      <div class="bg card-header list-group-item list-group-item-action" id="head" data-toggle="collapse" data-target="#collapse-worker" aria-expanded="false" aria-controls="collapse">
        <i class="fa fa-user" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;&nbsp;员工管理
      </div>
      <div id="collapse-worker" class="collapse card-body" aria-labelledby="head" data-parent="#accordion-1" style="padding: 0;">
        <a href="/staff" class="list-group-item-dark bg list-group-item list-group-item-action border-0" target="main"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;&nbsp;基本信息</a>
        <a href="/status" class="list-group-item-dark bg list-group-item list-group-item-action border-0" target="main"><i class="fa fa-circle-o" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;&nbsp;工作情况</a>
      </div>
    </div>
    <a href="/duty" class="list-group-item-dark bg list-group-item list-group-item-action" target="main"><i class="fa fa-briefcase" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;&nbsp;职务信息</a>
    <a href="/salary" class="list-group-item-dark bg list-group-item list-group-item-action" target="main"><i class="fa fa-bars" aria-hidden="true"></i>&nbsp;&nbsp;&nbsp;&nbsp;工资报表</a>
  </div>
</aside>
<div class="content" style="padding-left: 200px; background-color: #4a4d50;">
  <nav class="navbar navbar-light bg-dark">
    <form action="/staff/retrieve" method="get" class="form-inline" target="main" style="margin-bottom: 0;">
      <div class="form-group row">
        <select id="inputApartment" class="form-control text-secondary border-0" style="background-color: #4a4d50;margin-right: 24px;" name="staffDepartment">
          <option disabled>--请选择入职部门--</option>
          <option>所有部门</option>
          <option>人事行政部</option>
          <option>质管部</option>
          <option>采购部</option>
          <option>财务部</option>
          <option>市场营销部</option>
        </select>
      </div>
      <input class="form-control mr-sm-2 text-secondary border-0" type="search" placeholder="请输入“所有员工”或具体员工的部分或完整姓名" aria-label="Search" style="background-color: #4a4d50;width: 375px" name="name" type="text" required>
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </nav>
  <article style="padding-left:20px; background-color: white;">
    <iframe name="main" frameborder="0" scrolling="auto" width="100%" height="100%" style="overflow: visible;"></iframe>
  </article>
  <footer class="bg-secondary"><a class="text-secondary" href="https://github.com/liangcanxin/StaffManageSystem" target="_blank">数据库课程设计 @ 软工双学位</a></footer>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>