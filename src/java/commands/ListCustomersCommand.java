/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.CustomerSummary;
import servlets.Factory;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

/**
 *
 * @author Iram
 */
public class ListCustomersCommand extends TargetCommand {
    
    

    public ListCustomersCommand(String target,List<SecurityRole> roles) {
    super(target,roles);
  }
    
    @Override
    public String execute(HttpServletRequest request)
    {
        BankManager manager = Factory.getInstance().getManager();
        Collection<CustomerSummary> customerList = manager.listCustomers();
        request.setAttribute("customers", customerList);
        return super.execute(request);
    }
    
}
