package edu.eci.aygo.prototipo.infrastructure.controller;

import edu.eci.aygo.prototipo.application.port.in.InTranslateAws;
import edu.eci.aygo.prototipo.infrastructure.controller.model.CloudFormationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AwsController {

    private final InTranslateAws translateAwsService;

    @PostMapping("/aws")
    public ResponseEntity<String> translateAws(@RequestBody CloudFormationDTO cloudFormationDTO) {
        String compose = translateAwsService.translateToDocker(cloudFormationDTO);
        return ResponseEntity.ok(compose);
    }
}
