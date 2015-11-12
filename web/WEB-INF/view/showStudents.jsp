<%-- 
    Document   : showStudents
    Created on : 05/11/2015, 2:12:26 PM
    Author     : william
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Students Page</title>
    </head>
    <body>
        <h1>This is the Show Students Page</h1>
        <table border="1">
            <c:forEach var="tempschool" items="${schoolslist}">
                <thead>
                    <tr><td colspan="3">${tempschool.strschoolName} has 
                        ${fn:length(tempschool.studentsList)} students</td></tr>
                    <tr>
                        <td>Student ID</td>
                        <td>Student First Name</td>
                        <td>Student Last Name</td>
                    </tr>
                </thead>
                
                <c:forEach var="tempstudent" items="${tempschool.studentsList}">
                    <tr>
                        <td>${tempstudent.studentId}</td>
                        <td>${tempstudent.strstudentFname}</td>
                        <td>${tempstudent.strstudentLname}</td>
                    </tr>
                </c:forEach>
                    <tr><td colspan="3">&nbsp</td></tr>
            </c:forEach>
        </table>
    </body>
</html>
