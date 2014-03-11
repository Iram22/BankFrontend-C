<%-- 
    Document   : customer-edit
    Created on : Mar 9, 2014, 6:12:52 PM
    Author     : Iram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Edit</title>

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
                    <form action="Controller?command=createCustomer" method="post">
                        <h1>Create customer</h1>
                        <label>Cpr: </label><input type="text" name="cpr"><br/>
                        <label>Title: </label><select name="title">
                            <option>Mr.</option>
                            <option>Mrs.</option>
                            <option>Ms.</option>                
                        </select><br/>
                        <label>First name: </label><input type="text" name="firstName"><br/>
                        <label>Last name: </label><input type="text" name="lastName"><br/>
                        <label>Street: </label><input type="text" name="street"><br/>
                        <label>Postal code: </label><input type="text" name="postalCode"><br/>
                        <label>Postal district: </label><input type="text" name="postalDistrict"><br/>
                        <label>Phone: </label><input type="text" name="phone"><br/>
                        <label>Email: </label><input type="text" name="email"><br/>
                        <input type="submit" name="create" value="Save">

                    </form>
                    <br/><a href="Controller?command=customerList">Cancel</a>
                    <br/><a href="Controller?command=back">Back to main page</a>
                </div>
            </div>
            <div class="footer">
                Copyright © 2014 Group-C
            </div>
        </div>


    </body>
</html>
