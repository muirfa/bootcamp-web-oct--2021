<%-- 
    Document   : login
    Created on : Nov 25, 2021, 6:06:46 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Please Login</h1>
        <form method="POST" action="login">
            <p>Username</p><input type="text" name="userName"/>
            <p>Password</p><input type="password" name="password"/>
            <p><input type="submit" value="Login"/></p>
        </form>
    </body>
</html>
