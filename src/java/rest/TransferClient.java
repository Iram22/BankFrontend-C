/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rest;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:TransferRessource
 * [transfer]<br>
 * USAGE:
 * <pre>
 *        TransferClient client = new TransferClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Iram
 */
public class TransferClient {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Frontend/repository";

    public TransferClient(String reg) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(reg).path("transfer");
    }

    public <T> T create(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public void close() {
        client.close();
    }
    
}
