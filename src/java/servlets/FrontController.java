package servlets;

import commands.Command;
import commands.LogoutCommand;
import commands.ShowLoginCommand;
import dk.cphbusiness.bank.contract.BankManager;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FrontController", urlPatterns = {"/Controller"})
public class FrontController extends HttpServlet {

    @EJB
    private BankManager manager;
    private int PORT_NON_SSL;
    private int PORT_SSL;

    public FrontController() {
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        Factory.getInstance().setManager(manager);
        super.init(config); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void service(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String key = request.getParameter("command");
        Command command = Factory.getInstance().getCommand(key, request);
        String target = command.execute(request);

        if (command instanceof ShowLoginCommand && !request.isSecure()) {
            String SSL = "https://" + request.getServerName() + ":" + PORT_SSL + request.getRequestURI() + "?command=showlogin";
            System.out.println("SSL redirect: " + SSL);
            response.sendRedirect(SSL);
        } else if (command instanceof LogoutCommand) {
            String nonSSL = "http://" + request.getServerName() + ":" + PORT_NON_SSL + request.getRequestURI();
            System.out.println("Non SSL redirect: " + nonSSL);
            response.sendRedirect(nonSSL);
        } else {
            request.getRequestDispatcher(target).forward(request, response);
        }

    }

    @Override
    public void init() throws ServletException {
        PORT_NON_SSL = Integer.parseInt(getServletContext().getInitParameter("portNonSSL"));
        PORT_SSL = Integer.parseInt(getServletContext().getInitParameter("portSSL"));
    }
}
