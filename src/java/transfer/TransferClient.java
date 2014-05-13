package transfer;

import dk.cphbusiness.bank.contract.dto.TransferRequest;
import dk.cphbusiness.bank.contract.dto.TransferResponse;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 * Jersey REST client generated for REST resource:BankResource [bank]<br>
 * USAGE:
 * <pre>
 *        try (BankRepositoryClient client = new BankRepositoryClient()) {
 *          Object response = client.XXX(...);
 *          // do whatever with response
 *          }
 * </pre>
 *
 * @author anders
 */
public class TransferClient implements AutoCloseable {
  private WebTarget target;
  private Client client;
  //private static final String BASE_URI = "http://datdb.cphbusiness.dk:8080/BankRepository/ws";

  public TransferClient(String uri) {
    ClientConfig config = new ClientConfig().register(new JacksonFeature());
    client = javax.ws.rs.client.ClientBuilder.newClient();
    target = client.target(uri).path("transfer");
    }
  
  public TransferResponse create(TransferRequest transferRequest) {
    TransferResponse result = 
        target
                .request(APPLICATION_JSON_TYPE)
                .post(
                        Entity.entity(transferRequest, APPLICATION_JSON_TYPE),
                        TransferResponse.class
                );
    return result;
    }

  public void close() {
    client.close();
    }
  
  }
