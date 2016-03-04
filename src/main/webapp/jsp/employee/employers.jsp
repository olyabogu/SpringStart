<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Employer list</title>
    <link rel="stylesheet" type="text/css" href="${context}/css/style.css" />
</head>
<body>
<h3>${message}</h3>
<p>Employee list</p>
<table id="entity" cellspacing="3" cellpadding="3" border="1" width="500">
    <tr class="alt">
        <td><b>Id</b></td>
        <td><b>Last name</b></td>
        <td><b>First name</b></td>
        <td><b>Email address</b></td>
        <td><b>Hire day</b></td>
        <td><b>Age</b></td>
        <td><b>Department id</b></td>
        <td><b>Edit</b></td>
        <td><b>Delete</b></td>
    </tr>
    <c:forEach var="employer" items="${employers}">
        <tr>
            <td>${employer.id}</td>
            <td>${employer.lastName}</td>
            <td>${employer.firstName}</td>
            <td>${employer.emailAddress}</td>
            <td>${employer.hireDay}</td>
            <td>${employer.age}</td>
            <td>${employer.department.idDepartment}</td>
            <td>
                <a href="${context}/hibernate-servlet?action=form_edit_employer&id=${employer.id}">Edit</a>
            </td>
            <td>
                <a href="${context}/hibernate-servlet?action=form_delete_employer&id=${employer.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="${context}/hibernate-servlet?action=form_add_employer&id=${idDepartment}">Add new employer</a>
<br>
<a href="${context}/hibernate-servlet?action=list_department">Back</a>
</body>
</html>


