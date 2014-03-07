package servlets;

import commands.AccountDetailCommand;
import dk.cphbusiness.bank.contract.BankManager;
import commands.Command;
import commands.ListAccountsCommand;
import commands.ListCustomersCommand;
import commands.LoginCommand;
import commands.LogoutCommand;
import commands.ShowLoginCommand;
import commands.TargetCommand;
import commands.TransferCommand;
import dk.cphbusiness.dummy.bank.control.DummyBankManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;

public class Factory {

    private static Factory instance = null;
    private final BankManager manager;
    private final Map<String, Command> commands = new HashMap<>();

    private Factory() {
        manager = new DummyBankManager();
        Map<SecurityRole, String> roles = new HashMap();
        roles.put(SecurityRole.Customer, "/customer/account-list.jsp");
        roles.put(SecurityRole.AccountManager, "/accountManager/customer-list.jsp");

        commands.put("login", new LoginCommand(roles, "/login/login.jsp"));
        commands.put("logout", new LogoutCommand("/all/main.jsp", Arrays.asList(SecurityRole.All)));
        commands.put("back", new TargetCommand("/all/main.jsp", Arrays.asList(SecurityRole.All)));
        commands.put("main", new TargetCommand("/all/main.jsp", Arrays.asList(SecurityRole.All)));
        commands.put("showlogin", new ShowLoginCommand("/login/login.jsp", Arrays.asList(SecurityRole.All)));
        commands.put("customerList", new ListCustomersCommand("/accountManager/customer-list.jsp", Arrays.asList(SecurityRole.AccountManager)));
        commands.put("accountList", new ListAccountsCommand("/customer/account-list.jsp", Arrays.asList(SecurityRole.Customer)));
        commands.put("accountDetail", new AccountDetailCommand("/customer/account-detail.jsp", Arrays.asList(SecurityRole.Customer)));
        commands.put("showTransfer", new ListAccountsCommand("/customer/transfer-edit.jsp", Arrays.asList(SecurityRole.Customer)));
        commands.put("transfer", new TransferCommand("/customer/account-detail.jsp", Arrays.asList(SecurityRole.Customer)));
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    private void SecurityCheck(Command command, HttpServletRequest request) throws SecurityException {
        if (command instanceof TargetCommand) {
            List<SecurityRole> requiredRoles = ((TargetCommand) command).getRoles();
            boolean requiredRoleFound = false;
            for (SecurityRole requiredRole : requiredRoles) {
                if (requiredRole == SecurityRole.All || request.isUserInRole(requiredRole.toString())) {
                    requiredRoleFound = true;
                    break;
                }
            }
            if (!requiredRoleFound) {
                throw new SecurityException("You don't have the necessary rights to perform this command");
            }
        }
    }

    public BankManager getManager() {
        return manager;
    }

    public Command getCommand(String command, HttpServletRequest request) {
        if (command == null) {
            command = "main";
        }
        Command cmd = commands.get(command);
        SecurityCheck(cmd, request);
        return cmd;
    }

}
