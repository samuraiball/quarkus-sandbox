package dev.hirooka;


import io.quarkus.vertx.web.ReactiveRoutes;
import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RoutingExchange;
import io.smallrye.mutiny.Multi;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Duration;

@ApplicationScoped
public class ExampleResource {

    @Route(methods = HttpMethod.GET)
    void hello(RoutingContext rc){
        rc.response().end("hello");
    }

    // RoutingExchange is convenient wrapper of RoutingContext
    @Route
    void greeting(RoutingExchange rx){
        rx.ok("hello " + rx.getParam("name").orElse("world"));
    }

    @Route(path = "/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    Multi<Employee> stream(){
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1))
                .onItem().transform(n -> new Employee(n.toString()))
                .transform().byTakingFirstItems(6);
    }


    @Route(path = "/reactiveStream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    Multi<Employee> reactiveStream(){
        return ReactiveRoutes.asJsonArray(
                Multi.createFrom().ticks().every(Duration.ofSeconds(1))
                        .onItem().transform(n -> new Employee(n.toString()))
                        .transform().byTakingFirstItems(6));
    }
}
