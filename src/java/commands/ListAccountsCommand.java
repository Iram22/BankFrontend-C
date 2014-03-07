package commands;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import servlets.Factory;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

public class ListAccountsCommand extends TargetCommand {

  public ListAccountsCommand(String target,List<SecurityRole> roles) {
    super(target,roles);
  }

  @Override
  public String execute(HttpServletRequest request) {
    BankManager manager = Factory.getInstance().getManager();
    
    CustomerIdentifier customer = CustomerIdentifier.fromString((String) request.getSession().getAttribute("cpr"));
      System.out.println("session obj " + request.getSession().getAttribute("cpr"));
    Collection<AccountSummary> accounts = manager.listCustomerAccounts(customer);
    
      request.getSession().setAttribute("accounts", accounts);
    
    
    return super.execute(request);
    }
  
  
  
  }
