/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.CustomerDetail;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.eto.NoSuchCustomerException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author Iram
 */
public class CustomerDetailCommand extends TargetCommand{

    public CustomerDetailCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }
    
    @Override
    public String execute(HttpServletRequest request)
    {
        
        BankManager manager = Factory.getInstance().getManager();
        CustomerIdentifier customer = CustomerIdentifier.fromString(request.getParameter("cpr"));
        try {
            CustomerDetail detail = manager.showCustomer(customer);
            request.setAttribute("detail", detail);
        } catch (NoSuchCustomerException ex) {
            request.setAttribute("customerDetailError", "No such customer exists");
        }
        return super.execute(request);
    }
}
