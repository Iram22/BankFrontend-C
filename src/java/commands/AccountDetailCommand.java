/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountDetail;
import dk.cphbusiness.bank.contract.dto.AccountIdentifier;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author Iram
 */
public class AccountDetailCommand extends TargetCommand{

    public AccountDetailCommand(String target,List<SecurityRole> roles) {
    super(target,roles);
  }
    
    @Override
    public String execute(HttpServletRequest request)
    {
        BankManager manager = Factory.getInstance().getManager();
        AccountDetail detail = manager.showAccountHistory(AccountIdentifier.fromString(request.getParameter("account")));
        request.setAttribute("detail", detail);
        return super.execute(request);
    }
    
}
