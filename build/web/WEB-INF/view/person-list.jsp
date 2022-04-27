<%-- 
    Document   : person-list.jsp
    Created on : Nov 26, 2021, 10:34:52 AM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Person List</title>
    </head>
    <body>
        <h1>List of Person</h1>
        <table border="1">
            <tr>
                <td>ID</td>
                <td>Person Name</td>
                <td>Action</td>
            </tr>
            <!--iterate through list of persons-->
            <c:forEach var="person" items="${persons}">
                <tr>
                    <td>${person.id}</td>
                    <td>${person.name}</td>
                    <td>
                        <a href="person?id=${person.id}">See details</a>
                        &nbsp; &nbsp;
                        <a href="person-delete?id=${person.id}" onclick="return confirm('are you want to delete?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <a href="registration"> <button>Register New Person</button></a>
    </body>
</html>
