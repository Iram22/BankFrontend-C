<%-- 
    Document   : customer-detail
    Created on : Mar 10, 2014, 12:20:09 PM
    Author     : Iram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Customer details</h1>
        
        <table>
            <tr><th>Cpr: </th><td>${detail.cpr}</td></tr>
            <tr><th>Title: </th><td>${detail.title}</td></tr>
            <tr><th>First name: </th><td>${detail.firstName}</td></tr>
            <tr><th>Last name: </th><td>${detail.lastName}</td></tr>
            <tr><th>Street: </th><td>${detail.street}</td></tr>
            <tr><th>Postal code: </th><td>${detail.postalCode}</td></tr>
            <tr><th>Postal district: </th><td>${detail.postalDistrict}</td></tr>
            <tr><th>Phone: </th><td>${detail.phone}</td></tr>
            <tr><th>Email: </th><td>${detail.email}</td></tr>

            
            
           
        </table>
    </body>
</html>
