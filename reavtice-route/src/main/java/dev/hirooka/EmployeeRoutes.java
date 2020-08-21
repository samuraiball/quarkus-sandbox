package dev.hirooka;

import io.quarkus.vertx.web.ReactiveRoutes;
import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RoutingExchange;
import io.smallrye.mutiny.Multi;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Duration;

@ApplicationScoped
public class EmployeeRoutes {

    @Route(path = "employee")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    Multi<Employee> employees(RoutingExchange rx) {
        return ReactiveRoutes.asJsonArray(
                Multi.createFrom().ticks().every(Duration.ofSeconds(1))
                        .onItem().transform(n -> new Employee("employee nama:" + n.toString()))
                        .transform().byTakingFirstItems(6));
    }
}
