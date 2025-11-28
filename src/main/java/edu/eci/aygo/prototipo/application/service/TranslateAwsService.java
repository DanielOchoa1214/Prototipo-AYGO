package edu.eci.aygo.prototipo.application.service;

import edu.eci.aygo.prototipo.application.port.in.InTranslateAws;
import edu.eci.aygo.prototipo.domain.model.Architecture;
import edu.eci.aygo.prototipo.domain.model.Compute;
import edu.eci.aygo.prototipo.domain.model.VMComputation;
import edu.eci.aygo.prototipo.infrastructure.controller.model.CloudFormationDTO;
import edu.eci.aygo.prototipo.infrastructure.controller.model.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TranslateAwsService implements InTranslateAws {

    @Override
    public String translateToDocker(CloudFormationDTO dto) {
        Architecture architecture = Architecture.builder()
                .computeInstances(getComputeResources(dto))
                .build();
        return architecture.toDockerCompose();
    }

    private Set<Compute> getComputeResources(CloudFormationDTO dto) {
        return getComputeResources(dto.getResources())
                .stream()
                .map(name -> VMComputation.builder()
                        .name(name)
                        .build()
                )
                .collect(Collectors.toSet());
    }

    private List<String> getComputeResources(Map<String, Resource> resources) {
        return resources.entrySet().stream()
                .filter(entry -> entry.getValue().getType().equals("AWS::EC2::Instance"))
                .map(Map.Entry::getKey)
                .toList();
    }
}
