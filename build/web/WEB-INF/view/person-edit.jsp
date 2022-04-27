<%-- 
    Document   : person-edit
    Created on : Nov 26, 2021, 1:23:52 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>edit page</title>
    </head>
    <body>
        <h1>Edit Person Data</h1>
        <c:if test="${not empty error}"><p>${error}</p></c:if>
        <form method="POST" action="person">
            <p>User Name</p><input type="text" name="userName" value="${person.name}"/>
            <p>Password</p><input type="password" name="password" value="${person.password}"/>
            <p>Confirm Password</p><input type="password" name="confirmPassword" value="${person.password}"/>
            <input hidden="id" name="id" value="${person.id}"/>
            <input type="submit" value="Update"/>
        </form>
    </body>
</html>
