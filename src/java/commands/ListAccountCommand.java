/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author Iram
 */
public class ListAccountCommand extends TargetCommand{

    public ListAccountCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }
    
    public String execute(HttpServletRequest request)
    {
         BankManager manager = Factory.getInstance().getManager();
         Collection<AccountSummary> accounts = manager.listAccounts();
         
         request.setAttribute("accounts", accounts);
        
        return super.execute(request);
    }
}
