<%-- 
    Document   : account-edit
    Created on : Mar 10, 2014, 1:36:31 PM
    Author     : Iram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

                    <h1>Create account</h1>

                    <form action="Controller?command=createAccount">
                        <label>Cpr:</label><input type="text" name="cpr"><br/>
                        <label>Interest:</label><input type="text" name="interest"><br/>

                        <label>Account number:</label><input type="text" name="account"><br/>
                        <input type="submit" name="createAccount" value="Create account">
                        <input type="hidden" name="command" value="createAccount">

                    </form>

                    <br/>
                    <a href="Controller?command=accountList">Cancel</a><br/>
                    <a href="Controller?command=back">Back to main page</a><br/>
                    <p class="error">${createAccountError}</p>
                </div>
            </div>
            <div class="footer">
                Copyright © 2014 Group-C
            </div>
        </div>       
    </body>
</html>
