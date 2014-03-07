<%-- 
    Document   : customer-list
    Created on : Feb 26, 2014, 11:59:14 AM
    Author     : Iram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer List</title>
    </head>
    <body>
        <h1>Customers</h1>
        <br/><form action="Controller?command=back">
            <select name="customerName">
                <c:forEach var="customer" items="${customers}">
                    <option value="customer">${customer.name}</option>         
                </c:forEach>
            </select>
            <input type="hidden" name="command" value="list-accounts"/>
            <button name="submit"/>Account</button>
    </form>
    <br/>
    <a href="Controller?command=back">Back to main page</a>

</body>
</html>
