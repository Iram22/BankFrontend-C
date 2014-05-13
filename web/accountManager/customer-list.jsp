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
        <link rel="stylesheet" type="text/css" href="stylesheets/mystyle.css">
    </head>
     <body class="main">
        <div class="centre">
            <div class="header"> 
                State Bank
            </div>
            <div class="navigation">    
                <ul class="navigationList">

                    <li class="navList"><a href="Controller?command=back" class="navLinks">Home</a></li>
                    <li class="navList"><a href="#" class="navLinks">News</a></li>
                    <li class="navList"><a href="#" class="navLinks">Contact</a></li>
                    <li class="navList"><a href="#" class="navLinks">About us</a></li>

                </ul>

            </div>
            <div>
                <div class="left">
                    <form>
                        <input type="text"/>
                        <input type="submit" value="Search"/>
                    </form>
                    <ul class="sideMenu">
                        <li><a href="#" class="sideLinks">eBanking</a></li>
                        <li><a href="#" class="sideLinks">Day to day</a></li>
                        <li><a href="#" class="sideLinks">Savings</a></li>
                        <li><a href="#" class="sideLinks">Pension & Insurance</a></li>
                        <li><a href="#" class="sideLinks">Investment</a></li>
                        <li><a href="#" class="sideLinks">Terms & Conditions</a></li>
                    </ul>
                </div>
                <div class="right">
                    <div class="logout"><a href="Controller?command=logout">Log out</a></div>
                    <h1>Customer List</h1>
                    <table border="1">
                        <tr><th>Cpr</th><th>Name</th><th>Address</th><th>Phone</th><th>Email</th></tr>
                                <c:forEach var="customer" items="${customers}">
                            <tr><td><a href="Controller?command=customerDetail&cpr=${customer.cpr}">${customer.cpr}</a></td><td>${customer.name}</td><td>${customer.address}</td><td>${customer.phone}</td><td>${customer.email}</td></tr>
                        </c:forEach>                           
                    </table>
                    <form>                        
                            <input type="submit" name="createCustomer" value="Create customer">
                            <input type="hidden" name="command" value="showCreateCustomer"> 
                    </form>

            
                    <br/>
                    <a href="Controller?command=back">Back to main page</a>
                    <p>${error}</p>
                </div>
            </div>
            <div class="footer">
                Copyright © 2014 Group-C
            </div>
        </div>


    </body>
</html>
