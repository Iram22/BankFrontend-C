/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountDetail;
import dk.cphbusiness.bank.contract.dto.AccountSummary;
import dk.cphbusiness.bank.contract.dto.CheckingAccountDetail;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import dk.cphbusiness.bank.contract.eto.CustomerBannedException;
import dk.cphbusiness.bank.contract.eto.NoSuchCustomerException;
import java.math.BigDecimal;
import java.util.Collection;
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
public class CreateAccountCommand extends TargetCommand {

    public CreateAccountCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }

    @Override
    public String execute(HttpServletRequest request) {
        BankManager manager = Factory.getInstance().getManager();
        String cpr = request.getParameter("cpr");
        CustomerIdentifier customer = CustomerIdentifier.fromString(cpr);
        BigDecimal interest = new BigDecimal(request.getParameter("interest"));
        String account = request.getParameter("account");
        CheckingAccountDetail detail = new CheckingAccountDetail(account, interest,null );
        try {
            manager.createAccount(customer, detail);
        } catch (NoSuchCustomerException ex) {
            request.setAttribute("createAccountError", "No such customer exists");
        } catch (CustomerBannedException ex) {
            request.setAttribute("createAccountError", "Customer is banned");
        }
        Collection<AccountSummary> accounts = manager.listAccounts();
        request.setAttribute("accounts", accounts);

        return super.execute(request);
    }
}
