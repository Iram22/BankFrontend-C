/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import dk.cphbusiness.bank.contract.BankManager;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author Iram
 */
public class AboutCommand extends TargetCommand{

    public AboutCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    
    }
    
     @Override
    public String execute(HttpServletRequest request) {
        BankManager manager = Factory.getInstance().getManager();
        int count = manager.getCustomerCount();
        request.setAttribute("customer", count);
        return super.execute(request);
    }
    
    
}
