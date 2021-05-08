<%--
  Created by IntelliJ IDEA.
  User: filip
  Date: 25.04.2021
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>PersonDetails form</title>
</head>
<body>
    <form:form method="post" modelAttribute="persondetails">
        <div>
            <label for="firstName">First Name</label>
            <form:input id="firstName" path="firstName"/>
        </div>
        <div>
            <label for="lastName">Last Name</label>
            <form:input id="lastName" path="lastName"/>
        </div>
        <div>
            <label for="streetNumber">Street Number</label>
            <form:input id="streetNumber" path="streetNumber"/>
        </div>
        <div>
            <label for="street">Street</label>
            <form:input id="street" path="street"/>
        </div>
        <div>
            <label for="city">City</label>
            <form:input id="city" path="city"/>
        </div>
        <div>
            <input type="submit">
        </div>
    </form:form>

</body>
</html>
