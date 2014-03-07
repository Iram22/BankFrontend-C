/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.AccountDetail;
import dk.cphbusiness.bank.contract.dto.AccountIdentifier;
import dk.cphbusiness.bank.contract.eto.InsufficientFundsException;
import dk.cphbusiness.bank.contract.eto.NoSuchAccountException;
import dk.cphbusiness.bank.contract.eto.TransferNotAcceptedException;
import java.math.BigDecimal;
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
public class TransferCommand extends TargetCommand{

    public TransferCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }
    
    @Override
    public String execute(HttpServletRequest request)
    {
        BankManager manager = Factory.getInstance().getManager();
        BigDecimal amount = new BigDecimal(request.getParameter("amount"));
        System.out.println(request.getParameter("amount"));
        AccountIdentifier source = AccountIdentifier.fromString(request.getParameter("account"));
        System.out.println(request.getParameter("account"));
        AccountIdentifier target = AccountIdentifier.fromString(request.getParameter("target"));
        System.out.println(request.getParameter("target"));
        //System.out.println("hehe");
        AccountDetail detail;
        try {        
            detail = manager.transferAmount(amount, source, target);
            request.setAttribute("detail", detail);
        
        return super.execute(request);
        } catch (NoSuchAccountException ex) {
            request.setAttribute("transferError", "There is no such account!");
            Logger.getLogger(TransferCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransferNotAcceptedException ex) {
            request.setAttribute("transferError", "Transfer is not accepted!");
            Logger.getLogger(TransferCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InsufficientFundsException ex) {
            request.setAttribute("transferError", "You do not have sufficient funds for this transfer!");
            Logger.getLogger(TransferCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return "/customer/transfer-edit.jsp";
    }
    
}
