package dev.hirooka;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/echo")
@RequestScoped
public class EchoResource {

    private final JsonWebToken jwt;
    static final Logger logger = Logger.getLogger(EchoResource.class);

    public EchoResource(JsonWebToken jwt) {
        this.jwt = jwt;
    }

    @GET
    @Path("{value}")
    @RolesAllowed({"Echoer", "Subscriber"})
    @Produces(MediaType.TEXT_PLAIN)
    public String echo(
            @PathParam("value") String value
    ) {
        String issuer = jwt.getIssuer();
        if (issuer != null) {
            logger.info(String.format("issuer name is %s", issuer));
        }
        return value;
    }
}
