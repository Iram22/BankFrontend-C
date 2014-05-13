/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import dk.cphbusiness.bank.contract.BankManager;
import dk.cphbusiness.bank.contract.dto.TransferRequest;
import dk.cphbusiness.bank.contract.dto.TransferResponse;
import dk.cphbusiness.bank.contract.eto.InsufficientFundsException;
import dk.cphbusiness.bank.contract.eto.NoSuchAccountException;
import dk.cphbusiness.bank.contract.eto.TransferNotAcceptedException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import servlets.Factory;

/**
 * REST Web Service
 *
 * @author Iram
 */
@Path("transfer")
public class TransferRessource {

    @Context
    private UriInfo context;

    public TransferRessource() {
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public TransferResponse create(TransferRequest transfer) {
        BankManager manager = Factory.getInstance().getManager();
        try {
            manager.transferAmount(transfer.getAmount(), transfer.getSource(), transfer.getTarget());
            return new TransferResponse(true, "Transfered");
        } catch (NoSuchAccountException | TransferNotAcceptedException | InsufficientFundsException ex) {
            return new TransferResponse(false, "Failed");
        }
    }

}
