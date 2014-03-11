/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.CustomerDetail;
import dk.cphbusiness.bank.contract.dto.CustomerSummary;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author Iram
 */
public class CreateCustomerCommand extends TargetCommand {

    public CreateCustomerCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }

    public String execute(HttpServletRequest request) {
        BankManager manager = Factory.getInstance().getManager();
        CustomerDetail customer = new CustomerDetail(
                request.getParameter("cpr"),
                request.getParameter("title"),
                request.getParameter("firstName"),
                request.getParameter("lastName"),
                request.getParameter("street"),
                request.getParameter("postalCode"),
                request.getParameter("postalDistrict"),
                request.getParameter("phone"),
                request.getParameter("email"));
        manager.saveCustomer(customer);
        Collection<CustomerSummary> customerList = manager.listCustomers();
        request.setAttribute("customers", customerList);
        return super.execute(request);
    }

}
