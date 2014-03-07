<%-- 
    Document   : newjsp
    Created on : Mar 2, 2014, 4:19:13 PM
    Author     : Iram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                    <h1>Account detail</h1>
                    <b>Account type:</b> ${detail.type}<br/>
                    <b>Interest:</b> <fmt:formatNumber value="${detail.interest}" groupingUsed="true" maxFractionDigits="3"/>
                    <h4>Transfer History</h4>
                    <table border="1">
                        <tr><th>Date</th><th>Amount</th><th>Account number</th></tr>
                                <c:forEach var="transfer" items="${detail.transfers}">
                            <tr><td><fmt:formatDate pattern="yyyy-MM-dd" value="${transfer.date}"/></td>
                                <td>${transfer.amount}</td>
                                <td>${transfer.accountNumber}</td></tr>
                            </c:forEach>
                    </table><br/>
                    <a href="Controller?command=showTransfer">Transfer amount</a><br/>
                    <a href="Controller?command=back">Back to main page</a><br/>
                    <a href="Controller?command=accountList">Back to account list</a>
                </div>
            </div>
            <div class="footer">
                Copyright © 2014 Group-C
            </div>
        </div>





    </body>
</html>
