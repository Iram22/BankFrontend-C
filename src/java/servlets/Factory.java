package servlets;

import commands.AccountDetailCommand;
import dk.cphbusiness.bank.contract.BankManager;
import commands.Command;
import commands.CreateAccountCommand;
import commands.CustomerDetailCommand;
import commands.ListCustomerAccountsCommand;
import commands.ListCustomersCommand;
import commands.LoginCommand;
import commands.LogoutCommand;
import commands.ShowLoginCommand;
import commands.TargetCommand;
import commands.TransferCommand;
import commands.CreateCustomerCommand;
import commands.ListAccountCommand;
import commands.SayHelloCommand;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Entity;
import clients.Bank;
import clients.BankRepositoryClient;
import security.SecurityRole;

public class Factory {
    //BankManager bankManagerBean = lookupBankManagerBeanRemote();

    private static Factory instance = null;
    private BankManager manager;
    private final Map<String, Command> commands = new HashMap<>();

    private Factory() {
        registerBank();

        //manager = new DummyBankManager();
        Map<SecurityRole, String> roles = new HashMap();

        roles.put(SecurityRole.AccountManager, "/all/main.jsp");
        roles.put(SecurityRole.Customer, "/customer/account-list.jsp");

        commands.put("login", new LoginCommand(roles, "/login/login.jsp"));
        commands.put("logout", new LogoutCommand("/all/main.jsp", Arrays.asList(SecurityRole.All)));
        commands.put("back", new TargetCommand("/all/main.jsp", Arrays.asList(SecurityRole.All)));
        commands.put("main", new TargetCommand("/all/main.jsp", Arrays.asList(SecurityRole.All)));
        commands.put("showlogin", new ShowLoginCommand("/login/login.jsp", Arrays.asList(SecurityRole.All)));
        commands.put("customerList", new ListCustomersCommand("/accountManager/customer-list.jsp", Arrays.asList(SecurityRole.AccountManager)));
        commands.put("accountList", new ListAccountCommand("/accountManager/account-list.jsp", Arrays.asList(SecurityRole.AccountManager)));
        commands.put("customerAccountList", new ListCustomerAccountsCommand("/customer/account-list.jsp", Arrays.asList(SecurityRole.Customer)));
        commands.put("accountDetail", new AccountDetailCommand("/customer/account-detail.jsp", Arrays.asList(SecurityRole.Customer)));
        commands.put("showTransfer", new ListCustomerAccountsCommand("/customer/transfer-edit.jsp", Arrays.asList(SecurityRole.Customer)));
        commands.put("transfer", new TransferCommand("/customer/account-detail.jsp", Arrays.asList(SecurityRole.Customer)));
        commands.put("showCreateCustomer", new TargetCommand("/accountManager/customer-edit.jsp", Arrays.asList(SecurityRole.AccountManager)));
        commands.put("showCreateAccount", new TargetCommand("/accountManager/account-edit.jsp", Arrays.asList(SecurityRole.AccountManager)));
        commands.put("createCustomer", new CreateCustomerCommand("/accountManager/customer-list.jsp", Arrays.asList(SecurityRole.AccountManager)));
        commands.put("customerDetail", new CustomerDetailCommand("/accountManager/customer-detail.jsp", Arrays.asList(SecurityRole.AccountManager)));
        commands.put("createAccount", new CreateAccountCommand("/customer/account-list.jsp", Arrays.asList(SecurityRole.AccountManager)));
        commands.put("customerAccounts", new ListCustomersCommand("/accountManager/customer-accounts.jsp", Arrays.asList(SecurityRole.AccountManager)));
        commands.put("hello", new SayHelloCommand("/all/hello.jsp", Arrays.asList(SecurityRole.All)));
        commands.put("count", new TargetCommand("/accountManager/request-count.jsp", Arrays.asList(SecurityRole.AccountManager)));
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

    public void setManager(BankManager manager) {
        this.manager = manager;
    }
    
    

    public Command getCommand(String command, HttpServletRequest request) {
        if (command == null) {
            command = "main";
        }
        Command cmd = commands.get(command);
        SecurityCheck(cmd, request);
        return cmd;
    }
    
    public void registerBank()
    {
        BankRepositoryClient repository = new BankRepositoryClient();
        repository.save(new Bank("7933", "State Bank",  "http://localhost:8080/Frontend/repository"));
    }

}
