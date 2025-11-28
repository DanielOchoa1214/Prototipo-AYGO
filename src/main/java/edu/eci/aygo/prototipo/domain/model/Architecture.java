package edu.eci.aygo.prototipo.domain.model;

import edu.eci.aygo.prototipo.common.utils.YmlUtils;
import edu.eci.aygo.prototipo.domain.service.Dockerizable;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class Architecture implements Dockerizable {
    private Set<Compute> computeInstances;

    @Override
    public String toDockerCompose() {
        String services = getServices();
        return services.isBlank()
                ? "services:\n"
                : "services:\n%s\n".formatted(services);
    }

    private String getServices() {
        if (computeInstances == null || computeInstances.isEmpty()) {
            return "";
        }
        return computeInstances.stream()
                .filter(instance -> instance instanceof Dockerizable)
                .map(instance -> (Dockerizable) instance)
                .map(Dockerizable::toDockerCompose)
                .filter(s -> s != null && !s.isBlank())
                .map(YmlUtils::indentLines)
                .collect(Collectors.joining("\n"));
    }
}
