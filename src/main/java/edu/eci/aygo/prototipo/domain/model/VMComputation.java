package edu.eci.aygo.prototipo.domain.model;

import edu.eci.aygo.prototipo.domain.service.Dockerizable;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class VMComputation extends Compute implements Dockerizable {

    private static final String DEFAULT_IMAGE = "amazonlinux:2";
    private String name;

    @Builder
    public VMComputation(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toDockerCompose() {
        return """
                %s:
                \timage: %s
                \tcontainer_name: %s
                \tcommand: sleep infinity
                """.formatted(name, DEFAULT_IMAGE, name);
    }
}
