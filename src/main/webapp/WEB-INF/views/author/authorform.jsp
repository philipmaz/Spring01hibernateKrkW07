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
    </div>
    <div>
        <label for="lastName">Author Last Name</label>
        <form:input id="lastName" path="lastName"/>
    </div>
        <input type="submit">
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
