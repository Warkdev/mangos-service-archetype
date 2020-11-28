#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest.health;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Provider;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import ${package}.rest.${mainEntity}Resource;

@Readiness
@ApplicationScoped
public class ServiceReadinessCheck implements HealthCheck {

    private static final String readinessCheck = ${mainEntity}Resource.class.getSimpleName() + " Readiness Check";

    @Inject
    @ConfigProperty(name = "eu_getmangos_${mainEntity}_service_inMaintenance")
    Provider<String> inMaintenance;

    @Override
    public HealthCheckResponse call() {
        if (inMaintenance != null && inMaintenance.get().equalsIgnoreCase("true")) {
            return HealthCheckResponse.down(readinessCheck);
        }
        return HealthCheckResponse.up(readinessCheck);
    }
}
