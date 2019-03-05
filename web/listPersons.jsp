<%-- 
    Document   : listPersons
    Created on : 3/03/2019, 08:10:54 PM
    Author     : David Leonardo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Persons</title>
    </head>
    <body>
        <a href="addPerson.jsp">Add Person</a>
        <h1>List of Persons</h1>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Id Number</th>
            </tr>
            <c:forEach var="person" items="${persons}">
                <tr>
                    <td><a href="ControllerServlet?action=edit&personId=${person.personId}">${person.firstName}</a></td>
                    <td>${person.lastName}</td>
                    <td>${person.idNumber}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="index.jsp">Return to index</a>
    </body>
</html>
