<%--@elvariable id="department" type="com.test.exercise.hibernate.entity.Department"--%>
<%--
  Created by IntelliJ IDEA.
  User: olga
  Date: 9/19/12
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Edit department</title>
    <link rel="stylesheet" type="text/css" href="${context}/css/style.css"/>
    <script type="text/javascript" src="${context}/jquerylib/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="${context}/javascript/validate.js"></script>
</head>
<body>
<h2 style="color:red">${error}</h2>
<form action='<c:url value="/hibernate-servlet?action=edit_department"/>' method="POST">
    <input type="hidden" name="id" value="${department.idDepartment}"/>
    <table cellspacing="3" cellpadding="3" border="1" width="60%">
        <tr>
            <td>Enter new department name</td>
            <td><input type="text" name="nameDepartment" value="${department.nameDepartment}" onchange="validate(nameDepartment,imageDepartment)"/>
                <img class="image" name="imageDepartment" align="right"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Edit department"></td>
        </tr>
    </table>
</form>
<a href="${context}/hibernate-servlet?action=list_department">Back</a>
</body>
</html>
