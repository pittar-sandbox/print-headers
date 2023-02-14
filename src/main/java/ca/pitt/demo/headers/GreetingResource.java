package ca.pitt.demo.headers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestHeader;

@Path("/hello")
public class GreetingResource {

    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@RestHeader("X-Forwarded-For") String forwarded,
                        @RestHeader("X-Forwarded-Host") String host) {

        LOG.info("Forwarded: " + forwarded);
        LOG.info("Host: " + host);
        
        return "Hello from RESTEasy Reactive";
    }
}