package dev.hirooka;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RegisterRestClient
@RegisterClientHeaders
public interface GreetingClient {

    @GET
    @Path("/hello")
    String fetchHello();
}
