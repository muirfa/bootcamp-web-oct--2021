<%-- 
    Document   : student-edit
    Created on : Nov 29, 2021, 12:53:55 PM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Edit Page</title>
    </head>
    <body>
        <h1>Student Edit Data</h1>
        <c:if test="${not empty error}"><p>${error}</p></c:if>
        <form method="POST" action="student">
            <p>Full Name</p><input type="text" name="fullname" value="${student.fullname}"/>
            <p>Address</p><input type="text" name="address" value="${student.address}"/>
            <p>Status</p><input type="text" name="status" value="${student.status}"/>
            <p>Physics</p><input type="number" name="physics" value="${student.physics}"/>
            <p>Calculus</p><input type="number" name="calculus" value="${student.calculus}"/>
            <p>Biology</p><input type="number" name="biology" value="${student.biology}"/>
            <input hidden="id" name="id" value="${student.id}"/>
            <input type="submit" value="Update"/>
        </form>
    </body>
</html>
