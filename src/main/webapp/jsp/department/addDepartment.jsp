<%--@elvariable id="department" type="com.test.exercise.hibernate.entity.Department"--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Add new department</title>
    <link rel="stylesheet" type="text/css" href="${context}/css/style.css" />
    <script type="text/javascript" src="${context}/jquerylib/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="${context}/javascript/class.js"></script>
    <script type="text/javascript" src="${context}/javascript/validateClass.js"></script>
</head>
<body>
<h3>${error}</h3>
<form name="formAddDepartment" action='<c:url value="/hibernate-servlet?action=add_department"/>' method="POST">
    <table id="entity" cellspacing="3" cellpadding="3" border="1" width="60%">
        <tr class="alt">
            <td>Name department</td>
            <td><input  id='input' type="text" name="nameDepartment" value="${department.nameDepartment}"/>
            <div id="nameDepartment"></div></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Add new department"></td>
        </tr>
    </table>
</form>
<br>
<a href="${context}/hibernate-servlet?action=list_department">Back</a>
</body>
</html>
