<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Department list</title>
    <link rel="stylesheet" type="text/css" href="${context}/css/style.css" media="all"/>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
</head>
<body>
<h1>${message}</h1>
<p>Department list</p>
<div id="departments"></div>
<table id="entity" cellspacing="3" cellpadding="3" border="1" width="500">
    <tr class="alt">
        <td><b>Id</b></td>
        <td><b>Name department</b></td>
        <td><b>Edit</b></td>
        <td><b>Remove</b></td>
        <td><b>Employee list</b></td>
    </tr>
    <c:forEach var="department" items="${departments}" varStatus="num">
        <c:choose>
            <c:when test="${(num.index mod 2) eq 0}">
                <c:set var="cssClassName" value="yellow"/>
            </c:when>
            <c:otherwise>
                <c:set var="cssClassName" value="blue"/>
            </c:otherwise>
        </c:choose>

        <tr class="${cssClassName}">
            <td>${department.idDepartment}</td>
            <td>${department.nameDepartment}</td>
            <td>
                <a href="${context}/hibernate-servlet?action=form_edit_department&id=${department.idDepartment}">Edit</a>
            </td>
            <td>
                <a href="${context}/hibernate-servlet?action=form_delete_department&id=${department.idDepartment}">Delete</a>
            </td>
            <td>
                <a href="${context}/hibernate-servlet?action=list_employer&id=${department.idDepartment}">Employee list</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="${context}/hibernate-servlet?action=form_add_department">Add new department</a>
</body>
</html>


