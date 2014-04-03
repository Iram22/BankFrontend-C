package commands;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import servlets.Factory;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

public class ListCustomerAccountsCommand extends TargetCommand {

    public ListCustomerAccountsCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request) {
        BankManager manager = Factory.getInstance().getManager();
        String cpr = (String) request.getParameter("cpr");
        if(cpr == null)
            cpr=(String) request.getSession().getAttribute("cpr");
        CustomerIdentifier customer = CustomerIdentifier.fromString((String) cpr);
        Collection<AccountSummary> accounts = manager.listCustomerAccounts(customer);

        request.getSession().setAttribute("accounts", accounts);
        request.setAttribute("cpr", cpr);

        return super.execute(request);
    }

}
