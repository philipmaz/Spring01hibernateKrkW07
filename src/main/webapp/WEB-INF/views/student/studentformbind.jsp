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
    <title>Student form binded</title>
</head>
<body>
    <form:form method="post" modelAttribute="student">
        <div>
            <label for="firstName">First Name</label>
            <form:input id="firstName" path="firstName"/>
        </div>
        <div>
            <label for="lastName">Last Name</label>
            <form:input id="lastName" path="lastName"/>
        </div>
        <div>
            <label for="gender">Gender</label>
            Male: <form:radiobutton id="gender" path="gender" value="M"/>
            Female: <form:radiobutton id="gender" path="gender" value="W"/>
        </div>
        <div>
            <label for="country">Country</label>
            <form:select id="country" path="country" items="${countryItems}"/>
        </div>
        <div>
            <label for="notes">Notes</label>
            <form:textarea id="notes" path="notes"/>
        </div>
        <div>
            <label for="mailingList">Mailing List</label>
            <form:checkbox id="mailingList" path="mailingList"/>
        </div>
        <div>
            <label for="programmingSkills">Programming Skills </label>
            <form:select id="programmingSkills" path="programmingSkills" items="${programmingSkills}" multiple="true"/>
        </div>
        <div>
            <label for="hobbies">Hobbies: </label>
            <form:checkboxes items="${hobbies}" path="hobbies"/>
<%--            Swimming: <form:checkbox id="hobbies" path="hobbies" value="swimming"/>--%>
<%--            Hiking: <form:checkbox id="hobbies" path="hobbies" value="hiking"/>--%>
<%--            Running: <form:checkbox id="hobbies" path="hobbies" value="running"/>--%>
<%--            Reading Books: <form:checkbox id="hobbies" path="hobbies" value="reading books"/>--%>
        </div>
        <div>
            <input type="submit">
        </div>
    </form:form>

</body>
</html>
