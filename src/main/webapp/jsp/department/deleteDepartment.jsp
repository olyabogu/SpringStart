<%--@elvariable id="department" type="com.test.exercise.hibernate.entity.Department"--%>
<%--
  Created by IntelliJ IDEA.
  User: olga
  Date: 9/18/12
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Delete department</title>
    <link rel="stylesheet" type="text/css" href="${context}/css/style.css" />

</head>
<body>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<p>${error}</p>
<form action='<c:url value="/hibernate-servlet?action=delete_department"/>' method="POST">
    <input type="hidden" name="id" value="${department.idDepartment}"/>
    <table cellspacing="3" cellpadding="3" border="1" width="30%">
        <tr>
            <td>Name department</td>
            <td>${department.nameDepartment}</td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Delete department"></td>
        </tr>
    </table>
</form>
<a href="${context}/hibernate-servlet?action=list_department">Back</a>
</body>
</html>
