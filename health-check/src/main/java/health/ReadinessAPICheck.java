package health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class ReadinessAPICheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        try {
            chekAPI();
            return HealthCheckResponse.up("dependent api");
        } catch (Exception e) {
            e.printStackTrace();
            return HealthCheckResponse.down("dependent api");
        }
    }

    private void chekAPI(){
    }
}
