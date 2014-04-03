<%-- 
    Document   : transfer-edit
    Created on : Mar 2, 2014, 4:08:59 PM
    Author     : Iram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js"></script>
        <script>
            $(document).ready(function() {
                $("#myform").validate({
                    rules: {
                        amount: {required: true, number: true}
                    }


                });

            });
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                    <form action="Controller" method="post" id="myform">
                        <label>Amount:</label><input type="text" name="amount" id="amount"/><br/>
                        <label>Source:</label><select name="account">
                            <c:forEach var="account" items="${accounts}">
                                <option value=${account.number}>${account.number}</option>
                            </c:forEach>
                        </select><br/>
                        <label>Target:</label><input type="text" name="target"/>
                        <input type="submit" value="Transfer">
                        <input type="hidden" name="command" value="transfer">

                    </form>
                    <p class="error">${transferError}</p>
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
