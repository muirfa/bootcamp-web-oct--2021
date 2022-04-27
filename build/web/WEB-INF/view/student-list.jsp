<%-- 
    Document   : student-list
    Created on : Nov 29, 2021, 11:53:23 AM
    Author     : Asus
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student List Page</title>
    </head>
    <body>
        <h1>List of Student</h1>
        <table border="1">
            <tr>
                <td>ID</td>
                <td>Student Name</td>
                <td>Address</td>
                <td>Status</td>
                <td>Physics</td>
                <td>Calculus</td>
                <td>Biology</td>
                <td>Action</td>
            </tr>
            <!--iterate through list of persons-->
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.fullname}</td>
                    <td>${student.address}</td>
                    <td>${student.status}</td>
                    <td>${student.physics}</td>
                    <td>${student.calculus}</td>
                    <td>${student.biology}</td>
                    <td>
                        <a href="student?id=${student.id}">Edit Data</a>
                        &nbsp; &nbsp;
                        <a href="student-delete?id=${student.id}" onclick="return confirm('are you want to delete?')">Delete</a>
                    </td>
                    
                </tr>
            </c:forEach>
        </table>
        <br/>
       <a href="insert"> <button>Insert New Student</button></a>
    </body>
</html>
