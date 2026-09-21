<%-- 
    Document   : Login
    Created on : 28 jun 2026, 1:33:30
    Author     : march
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ServletLogin" method="post">
            Usuario: <input type="text" name="usuario" value="admin"><br>
            Password: <input type="password" name="password" value="admin123"><br>
            <input type="submit" name="submit" value="Ingresar">
        </form>
        
        <!-- Mensaje de Error -->
        <c:if test="${not empty message}">
            <script>
                alert("${message}");
            </script>
        </c:if>
    </body>
</html>
