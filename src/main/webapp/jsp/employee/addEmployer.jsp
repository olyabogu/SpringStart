<%--@elvariable id="employer" type="com.test.exercise.hibernate.entity.Employer"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Add new employer</title>
    <link rel="stylesheet" type="text/css" href="${context}/css/style.css"/>
    <script type="text/javascript" src="${context}/jquerylib/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="${context}/javascript/validate.js"></script>

</head>
<body>
<h3>${error}</h3>

<form action='<c:url value="/hibernate-servlet?action=add_employer"/>' method="POST">
    <input type="hidden" name="idDepartment" value="${idDepartment}"/>
    <table cellspacing="3" cellpadding="3" border="1" width="60%">
        <td>Last name</td>
        <td><input type="text" name="lastName" value="${employer.lastName}"
                   onchange="validate(lastName,imageLastName)"/>
            <img class="image" name="imageLastName" align="right"></td>

        </tr>
        <tr>
            <td>First name</td>
            <td><input type="text" name="firstName" value="${employer.firstName}"
                       onchange="validate(firstName,imageFirstName)"/>
                <img class="image" name="imageFirstName" align="right"></td>

        </tr>
        <tr>
            <td>Email address</td>
            <td><input type="text" name="emailAddress" value="${employer.emailAddress}"
                       onchange="validateEmail(emailAddress,image)"/>
                <img class="image" name="image" align="right"></td>

        </tr>
        <tr>
            <td>Hire day</td>
            <td><input type="date" name="hireDay" value="${employer.hireDay}"
                       onchange="validate(hireDay,imageHireDay)"/>
                <img class="image" name="imageHireDay" align="right"></td>

        </tr>
        <tr>
            <td>Age</td>
            <td><input type="text" name="age" value="${employer.age}" onchange="validate(age,imageAge)"/>
                <img class="image" name="imageAge" align="right"></td>

        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Add new employer"></td>
        </tr>
    </table>
</form>
<a href="${context}/hibernate-servlet?action=list_employer&id=${idDepartment}">Back</a>
</body>
</html>