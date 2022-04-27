<%-- 
    Document   : registration
    Created on : Nov 26, 2021, 11:27:39 AM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <h1>Registration</h1>
        <c:if test="${not empty error}"><p>${error}</p></c:if>
        <form method="POST" action="registration">
            <p>User Name</p><input type="text" name="userName" value="${userName}"/>
            <p>Password</p><input type="password" name="password"/>
            <p>Confirm Password</p><input type="password" name="confirmPassword"/>
            <input type="submit" value="Register"/>
        </form>
    </body>
</html>
