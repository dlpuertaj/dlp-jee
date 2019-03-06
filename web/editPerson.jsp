<%-- 
    Document   : editPerson
    Created on : 4/03/2019, 10:35:21 PM
    Author     : David Leonardo
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Person</title>
    </head>
    <body>
        <h1>Edit  Person</h1>
        
        <form action="ControllerServlet" method="post">
            <input type="hidden" name="action" value="edit"/>
            
            <input type="hidden" name="personId" value="${person.personId}"/>
            
            <label for="firstName">First Name:</label>
            <input type="text" name="firstName" value="${person.firstName}" style="display:  block"/>
            
            <label for="lastName">Last Name:</label>
            <input type="text" name="lastName" value="${person.lastName}" style="display:  block"/>
            
            <label for="idNumber">Id Number:</label>
            <input type="text" name="idNumber" value="${person.idNumber}" style="display:  block"/>
            
            <input type="submit" name="Save" value="save" style="display:  block"/>
            <input type="submit" name="Delete" value="delete" style="display:  block"/>
        </form>
    </body>
</html>
