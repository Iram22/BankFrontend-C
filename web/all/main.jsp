<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bank main page</title>
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
                    <ul>
                        <c:if test="${pageContext.request.isUserInRole('Customer')==true}">
                            <li><a href="Controller?command=customerAccountList">View accounts</a></li>
                            </c:if >
                            <c:if test="${pageContext.request.isUserInRole('AccountManager')==true}"> 
                            <li><a href="Controller?command=customerList">Manage customers</a></li>
                            </c:if >
                        <c:if test="${pageContext.request.isUserInRole('AccountManager')==true}"> 
                            <li><a href="Controller?command=customerAccounts">Manage accounts</a></li>
                            </c:if >

                        <c:choose >
                            <c:when test="${pageContext.request.remoteUser== null}">

                                <li><img src="images/lock.png" width="30px"><a href="Controller?command=showlogin" class="login">Login</a></li>
                                </c:when>
                                <c:otherwise>
                                <li><a href="Controller?command=logout">Log out</a></li>
                                </c:otherwise>
                            </c:choose>
<li><a href="Controller?command=hello">hello</a></li>
                    </ul>
                </div>
            </div>
            <div class="footer">
                Copyright © 2014 Group-C
            </div>
        </div>








    </body>
</html>
