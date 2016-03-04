
<%--@elvariable id="employer" type="com.test.exercise.hibernate.entity.Employer"--%><%--
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
    <title>Edit employer</title>
    <link rel="stylesheet" type="text/css" href="${context}/css/style.css"/>
    <script type="text/javascript" src="${context}/jquerylib/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="${context}/javascript/class.js"></script>
    <script type="text/javascript" src="${context}/javascript/validateClass.js"></script>
</head>
<body>
<h3>${error}</h3>

<form name="formEditEmployer" action='<c:url value="/hibernate-servlet?action=edit_employer"/>' method="POST">
    <input type="hidden" name="id" value="${employer.id}"/>
    <table cellspacing="3" cellpadding="3" border="1" width="60%">
        <tr class="alt">
            <td>Last name</td>
            <td><input type="text" name="lastName" value="${employer.lastName}"/>

                <div id="lastName"></div>
            </td>
            </td>

        </tr>
        <tr>
            <td>First name</td>
            <td><input type="text" name="firstName" value="${employer.firstName}"/>

                <div id="firstName"></div>
            </td>

        </tr>
        <tr>
            <td>Email address</td>
            <td><input type="text" name="emailAddress" value="${employer.emailAddress}"/>

                <div id="emailAddress"></div>
            </td>

        </tr>
        <tr>
            <td>Hire day</td>
            <td><input type="date" name="hireDay" value="${employer.hireDay}"/>

                <div id="hireDay"></div>
            </td>
            </td>

        </tr>
        <tr>
            <td>Age</td>
            <td><input type="text" name="age" value="${employer.age}"/>

                <div id="age"></div>
            </td>

        </tr>
        <tr>
            <td>Department id</td>
            <td><input type="text" name="idDepartment" value="${employer.department.idDepartment}"/>

                <div id="idDepartment"></div>
            </td>

        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Edit employer"></td>
        </tr>
    </table>
</form>
<a href="${context}/hibernate-servlet?action=list_employer&id=${employer.department.idDepartment}">Back</a>
</body>
</html>
