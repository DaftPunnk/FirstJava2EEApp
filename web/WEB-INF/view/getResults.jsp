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
            
        There are ${fn:length(studentResults)} results for this student 
        
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
            
            <c:forEach var="tempresult" items="${studentResults}">
                <tr>
                    <td>${tempresult.apparatuss.strapparatusName}</td>
                    <td>${tempresult.intresult}</td>
                </tr>
            </c:forEach>
        </table>
        
        <form action="insertNewResult" method="POST">
            <select name="apparatusId" >
                <c:forEach var="apparatusvalue" items="${selectedApparatus}" >
                    <option value="${apparatusvalue.apparatusId}">${apparatusvalue.strapparatusName}</option>
                </c:forEach>
            </select>
            <select name="resultscore">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
            </select>
            <input type="hidden" value="${selectedStudent.studentId}" name="studentId" />
            <input type="submit" value="Add result" name="addresult" />
        </form>
        
        <a href="index.jsp">Take Me Home</a>
    </body>
</html>
