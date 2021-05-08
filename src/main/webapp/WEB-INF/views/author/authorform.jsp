<%--
  Created by IntelliJ IDEA.
  User: filip
  Date: 27.04.2021
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Author add form</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    <div>
        <label for="firstName">Author First Name</label>
        <form:input id="firstName" path="firstName"/>
        <form:errors path="firstName"/>
    </div>
    <div>
        <label for="lastName">Author Last Name</label>
        <form:input id="lastName" path="lastName"/>
        <form:errors path="lastName"/>
    </div>
    <div>
        <label for="pesel">Author PESEL</label>
        <form:input id="pesel" path="pesel"/>
        <form:errors path="pesel"/>
    </div>
    <div>
        <label for="email">Author Email</label>
        <form:input id="email" path="email"/>
        <form:errors path="email"/>
    </div>
    <div>
        <input type="submit">
    </div>
    <div>
        <form:errors path="*"/>
    </div>
</form:form>
<div>
    <a href="http://localhost:8060/Spring01hibernateKrkW07_war_exploded/af/1/edit"> Edit </a>
</div>
<div>
    <a href="http://localhost:8060/Spring01hibernateKrkW07_war_exploded/af/1/delete"> Delete </a>
</div>

</body>
</html>
