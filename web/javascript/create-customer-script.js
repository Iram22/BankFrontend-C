/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
//    $("#cpr").focusout(function(){
//            $.ajax({
//                    url: "AjaxServlet",
//                    data: {
//                        cmd: "cprLookUp",
//                        cpr: $("#cpr").val()
//                    },
//                    cache: false,
//                    dataType: "json"
//                }).done(function(data) {
//                    if(data=== true)
//                    {
//                        $("#err").html(data);
//                    }
//                    else
//                    {
//                        $("#err").html("");
//                    }
//                        
//                    
//                });
//    });
    $("#myform").validate({
        rules:
                {
                    cpr: {required: true,
                        remote: {url: "AjaxServlet",
                            type: "get",
                            data: {
                                cmd: function() {
                                    return "cprLookUp";
                                },
                                cpr: function(){
                                    return $("#cpr").val();
                                }
                            }}},
                    firstName: {required: true, minlength: 2},
                    lastName: {required: true, minlength: 2},
                    email: {required: true, email: true},
                    password: {required: true, minlength: 5},
                    repeat: {required: true, equalTo: "#password"}


                },
        message:
                {
                    cpr:
                            {
                                required: "Please enter a cpr",
                                remote: jQuery.validator.format("{0} is already taken.")
                 
                            },
                    firstName:
                            {
                                required: "Please enter the first name",
                                minlength: jQuery.format("Atleast {0} characters required!")
                            },
                    lastName:
                            {
                                required: "Please enter the last name",
                                minlength: jQuery.format("Atleast {0} characters required!")
                            },
                    email:
                            {
                                required: "Please enter the email",
                                email: "Please enter a valid email address"
                            },
                    password:
                            {
                                required: "Please enter a password",
                                minlength: jQuery.format("Atleast {0} characters required!")
                            },
                    repeat:
                            {
                                required: "Please repeat the password",
                                equalTo: "The password must be same as above"
                            }

                }



    });
});