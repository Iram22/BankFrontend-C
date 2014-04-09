/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
    $("#btn").click(function() {

        count();
    });

    function count() {
        $.ajax({
            url: "AjaxServlet",
            cache: false,
            data: {cmd: "count"},
            datatype: "json"
        }).done(function(data) {
                $("#count").html(data);

        });
    }
});