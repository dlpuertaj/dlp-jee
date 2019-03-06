<%-- 
    Document   : addPerson
    Created on : 4/03/2019, 10:35:04 PM
    Author     : David Leonardo
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Person</title>
    </head>
    <body>
        <h1>Add New Person</h1>
        <form action="ControllerServlet" method="post">
            <input type="hidden" name="action" value="add"/>
            
            <label for="firstName">First Name:</label>
            <input type="text" name="firstName" style="display: block;"/>
            
            <label for="lastName">Last Name:</label>
            <input type="text" name="lastName" style="display: block;"/>
            
            <label for="idNumber">Id Number:</label>
            <input type="text" name="IdNumber" style="display: block;"/>
            
            <input type="submit" value="Save" />

        </form>
        <a href="index.jsp">Return to index</a>
        <br>
    </body>
</html>
