<%-- 
    Document   : showSchools
    Created on : 10/09/2015, 1:41:01 PM
    Author     : william
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Show Schools Page</title>
    </head>
    <body>
        <h1>This is the show schools page</h1>
        <table border="1">
         
            <thead>
                <tr>
                    <td>
                        School ID
                    </td>
                    <td>
                        School Name
                    </td>
                </tr>
            </thead>
            
            <c:forEach var="tempschool" items="${schoolslist}">
                <tr>
                    <td>${tempschool.schoolId}</td>
                    <td>${tempschool.strschoolName}</td>
                </tr>
            </c:forEach>
            
        </table>
        <a href="index.jsp"> Take Me Home </a>
    </body>
</html>
