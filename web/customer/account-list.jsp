<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account list</title>
        <link rel="stylesheet" type="text/css" href="stylesheets/mystyle.css">
        <link rel="stylesheet" type="text/css" href="stylesheets/accountstyle.css">
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
                    <h1>Account list for ${cpr}</h1>
                    <table border="1">
                        <tr><th>Account number</th><th>Account type</th><th>Balance</th></tr>
                                <c:forEach var="account" items="${accounts}">
                            <tr>
                                <td><a href="Controller?command=accountDetail&account=${account.number}">${account.number}</a></td>
                                <td>${account.type}</td>
                                <td>${account.balance}</td></tr>
                            </c:forEach>
                    </table><br/>
                    <c:if test="${pageContext.request.isUserInRole('AccountManager')==true}"> 
                        <a href="Controller?command=showCreateAccount&cpr=${cpr}">Create accounts</a>
                    </c:if >
                    <br/><a href="Controller?command=showTransfer">Transfer amount</a>
                    <br/><a href="Controller?command=back">Back to main page</a>
                </div>
            </div>
            <div class="footer">
                Copyright © 2014 Group-C
            </div>
        </div>


    </body>
</html>
