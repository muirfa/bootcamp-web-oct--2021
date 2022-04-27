<%-- 
    Document   : insert
    Created on : Nov 29, 2021, 2:39:27 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Student Page</title>
    </head>
    <body>
        <h1>Insert Student Page</h1>
        <c:if test="${not empty error}"><p>${error}</p></c:if>
        <form method="POST" action="insert">
            <p>Full Name</p><input type="text" name="fullname" value="${student.fullname}"/>
            <p>Address</p><input type="text" name="address" value="${student.address}"/>
            <p>Status</p><input type="text" name="status" value="${student.status}"/>
            <p>Physics</p><input type="number" name="physics" value="${student.physics}"/>
            <p>Calculus</p><input type="number" name="calculus" value="${student.calculus}"/>
            <p>Biology</p><input type="number" name="biology" value="${student.biology}"/>
            <input type="submit" value="Input Student"/>
        </form>
    </body>
</html>
