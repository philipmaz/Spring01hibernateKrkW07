<%--
  Created by IntelliJ IDEA.
  User: filip
  Date: 07.05.2021
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Publisher delete form</title>
</head>
<body>
<form:form method="post" modelAttribute="publisher">
    <h3>Delete Publisher:</h3>
    <div>
        <label for="name">Publisher Name</label>
        <form:input id="name" path="name"/>
    </div>
    <input type="submit" value="Delete">
</form:form>
<div>
    <a href="http://localhost:8060/Spring01hibernateKrkW07_war_exploded/pf/1/edit"> Edit </a>
</div>
<div>
    <a href="http://localhost:8060/Spring01hibernateKrkW07_war_exploded/pf/addpublisher"> Add </a>
</div>

</body>
</html>