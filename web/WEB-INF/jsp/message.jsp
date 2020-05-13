<%--
  Created by IntelliJ IDEA.
  User: master
  Date: 2020/5/1
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>提示信息</title>
</head>
<body>
<c:if test="${not empty errMessage}">
    <script>
        alert("${errMessage}");
    </script>
</c:if>

<c:if test="${not empty message}">
    <script>
        alert("${message}");
    </script>
</c:if>

<c:choose>
    <c:when test="${message=='职务更新保存成功！'||errMessage=='职务设置参数格式错误！'||errMessage=='更新职务信息失败！'}">
        <script>
            location.replace("/duty");
        </script>
    </c:when>
    <c:when test="${message=='员工信息删除成功！'||message=='员工信息保存成功！'||errMessage=='员工设定参数格式错误！'||errMessage=='更新员工信息失败'||errMessage=='删除员工信息失败！'}">
        <script>
            location.replace("/staff");
        </script>
    </c:when>
    <c:otherwise>
        <script>
            location.replace("/status");
        </script>
    </c:otherwise>
</c:choose>

${sessionScope.remove("errMessage")}
${sessionScope.remove("message")}

</body>
</html>
