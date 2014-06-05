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
        <link rel="stylesheet" type="text/css" href="stylesheets/mystyle.css">
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
                    <h1>Customer details</h1>
                    <form action="Controller?command=editCustomer">
                        <table border="1">

                            <tr><th>Cpr: </th><td id="cpr">${detail.cpr}</td></tr>
                            <tr><th>Title: </th><td><input type="text" id="title" name="title" value=${detail.title}></td></tr>
                            <tr><th>First name: </th><td><input type="text" id="firstName" name="firstName" value=${detail.firstName}></td></tr>
                            <tr><th>Last name: </th><td><input type="text" id="lastName" name="lastName" value=${detail.lastName}></td></tr>
                            <tr><th>Street: </th><td><input type="text" id="street" value=${detail.street}></td></tr>
                            <tr><th>Postal code: </th><td><input type="text" id="postalCode" name="postalCode" value=${detail.postalCode}></td></tr>
                            <tr><th>Postal district: </th><td><input type="text" id="postalDistrict" name="postalDistrict" value=${detail.postalDistrict}></td></tr>
                            <tr><th>Phone: </th><td><input type="text" id="phone" name="phone" value=${detail.phone}></td></tr>
                            <tr><th>Email: </th><td><input type="text" id="email" name="email" value=${detail.email}></td></tr>
                        </table>

                        <input type="submit" name="saveCustomer" value="Save changes"/>
                    </form>
                    <p class="error">${customerDetailError}</p>

                    <br/>
                    <a href="Controller?command=customerList">Back to customer list</a><br/>
                    <a href="Controller?command=back">Back to main page</a>

                </div>
            </div>
            <div class="footer">
                Copyright © 2014 Group-C
            </div>
        </div>



    </body>
</html>
