package health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class ReadinessCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        try {
            checkDB();
            return HealthCheckResponse.up("test");
        } catch (Exception e) {
            e.printStackTrace();
            return HealthCheckResponse.down("db connection");
        }
    }

    private void checkDB(){
       throw new RuntimeException("db connection falied");
    }
}
