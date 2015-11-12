<%-- 
    Document   : getResults
    Created on : 12/11/2015, 2:36:49 PM
    Author     : william
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results For Students</title>
    </head>
    <body>
        <h1>Results for student ${selectedStudent.strstudentFname}&nbsp
            ${selectedStudent.strstudentLname}</h1>
            
        There are ${fn:length(selectedStudent.studentResultsList)} results for this student 
        
        <table border="1">
            <thead>
                <tr>
                    <td>
                        Apparatus ID
                    </td>
                    <td>
                        Result
                    </td>
                </tr>
            </thead>
            
            <c:forEach var="tempresult" items="${selectedStudent.studentResultsList}">
                <tr>
                    <td>${tempresult.apparatuss.strapparatusName}</td>
                    <td>${tempresult.intresult}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="index.jsp">Take Me Home</a>
    </body>
</html>
