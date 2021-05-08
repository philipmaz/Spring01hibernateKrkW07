<%--
  Created by IntelliJ IDEA.
  User: filip
  Date: 25.04.2021
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Person add form binded</title>
</head>
<body>
<h1>Are you sure you want to delete the following book? Submit if yes.</h1>
<form:form method="post" modelAttribute="book">
    <form:hidden path="id"/>
    <div>
        <label for="title">Title</label>
        <form:input id="title" path="title"/>
    </div>
    <div>
        <label for="rating">Rating</label>
        <form:input id="rating" path="rating" type="number" min="1" max="10"/>
    </div>
    <div>
        <label for="description">Description</label>
        <form:textarea id="description" path="description"/>
    </div>
    <div>
        <label for="publisher">Publisher</label>
        <form:select id="publisher" path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/>
    </div>
    </div>
    <%--    <div>--%>
    <label for="authorList">Authors</label>
    <form:select id="authorList" path="authorList" items="${authorList}" itemLabel="lastName" itemValue="id"/>
    </div>
    <div>
        <input type="submit">
    </div>
    <div>
        <a href="http://localhost:8060/Spring01hibernateKrkW07_war_exploded/bf/4/edit">Edit Book by id</a>
    </div>
    <div>
        <a href="http://localhost:8060/Spring01hibernateKrkW07_war_exploded/bf/4/delete">Delete Book by id</a>
    </div>

</form:form>
</body>
</html>