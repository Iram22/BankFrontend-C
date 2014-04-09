/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
    $("#btn").click(function() {
        
        autofill();
    });
    
    function autofill(){
        $.ajax({
            url:"AjaxServlet",
            cache: false,
            data:{phone: $("#phone").val(),cmd: "autofill"},
            datatype: "json"      
        }).done(function(data){
            
            $("#street").val(data.address);
            $("#postalCode").val(data.zip);
            $("#email").val(data.email);
            $("#firstName").val(data.firstName);
            $("#lastName").val(data.lastName);
            $("#postalDistrict").val(data.city);
            
            
        });
        
    }
    

});
