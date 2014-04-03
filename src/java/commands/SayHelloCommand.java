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
public class SayHelloCommand extends TargetCommand{

    public SayHelloCommand(String target, List<SecurityRole> roles) {
        super(target, roles);
    }
    
    public String execute(HttpServletRequest request)
    {
        BankManager manager = Factory.getInstance().getManager();
        request.setAttribute("hello", manager.sayHello("iram"));
        
        return super.execute(request);
        
    }
    
}
