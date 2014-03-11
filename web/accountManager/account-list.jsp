<%-- 
    Document   : account-list
    Created on : Mar 10, 2014, 8:41:35 PM
    Author     : Iram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" type="text/css" href="stylesheets/mystyle.css">
        <link rel="stylesheet" type="text/css" href="stylesheets/accountstyle.css">
        <title>JSP Page</title>
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
                    <h1>Account List</h1>
                    <table border="1">
                        <tr><th>Number</th><th>Type</th><th>Balance</th></tr>
                        <c:forEach var="account" items="${accounts}">
                            <td>${account.number}</a></td>
                            <td>${account.type}</td>
                            <td>${account.balance}</td></tr> 
                        </c:forEach>                           
                    </table>
                    <form>                        
                        <input type="submit" name="createAccount" value="Create account">
                        <input type="hidden" name="command" value="showCreateAccount"> 
                    </form>


                    <br/>
                    <a href="Controller?command=back">Back to main page</a>
                </div>
            </div>
            <div class="footer">
                Copyright © 2014 Group-C
            </div>
        </div>
    </body>
</html>
