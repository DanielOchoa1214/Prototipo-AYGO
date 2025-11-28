package edu.eci.aygo.prototipo.application.port.in;

import edu.eci.aygo.prototipo.infrastructure.controller.model.CloudFormationDTO;

public interface InTranslateAws {
    String translateToDocker(CloudFormationDTO dto);
}
