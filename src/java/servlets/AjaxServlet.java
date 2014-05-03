/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.CustomerIdentifier;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Scanner;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Iram
 */
@WebServlet(name = "AjaxServlet", urlPatterns = {"/AjaxServlet"})
public class AjaxServlet extends HttpServlet {

    @EJB
    private BankManager manager;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");
        String AjaxCmd = request.getParameter("cmd");

        if ("cprLookUp".equals(AjaxCmd)) {
            CustomerIdentifier cpr = CustomerIdentifier.fromString(request.getParameter("cpr"));
            boolean check = manager.checkCustomer(cpr);
            try (PrintWriter out = response.getWriter()) {
                out.println(check);
            }
        }
      
        if ("autofill".equals(AjaxCmd)) {
            String server = getServletContext().getInitParameter("server");
            String parameter = request.getParameter("phone");
            String restResource = "/service/person/";
            String mime = "application/json";
            String val = callRest(server, restResource, parameter, mime, "GET");
            System.out.println(val);
            try (PrintWriter out = response.getWriter()) {
                out.println(val);
            }
        }
        
        if("count".equals(AjaxCmd))
        {
            String server = getServletContext().getInitParameter("server");
            String parameter = "";
            String restResource = "/service/request/thisuser";
            String mime = "text/plain";
            String val = callRest(server, restResource, parameter, mime, "GET");
            System.out.println(val);
            try (PrintWriter out = response.getWriter()) {
                out.println(val);
            } 
        }

    }

    //connect to restful webservice(wannabe krak)
    private static String callRest(String server, String restResource, String parameter, String mime, String method) {
        String data = "";
        try {
            URL url = new URL(server + restResource + parameter);
            System.out.println("xxxxxx: "+server + restResource + parameter);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("group-c", "test".toCharArray());//Add your team password here 
                }
            });
            conn.setRequestProperty("Accept", mime);
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed: HTTP Response Code= " + conn.getResponseCode());
            }
            Scanner scan = new Scanner(conn.getInputStream());
            while (scan.hasNextLine()) {
                data += scan.next();
            }
            conn.disconnect();
        } catch (IOException | RuntimeException e) {
            System.out.println("Error: " + e);
        }
        return data;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
