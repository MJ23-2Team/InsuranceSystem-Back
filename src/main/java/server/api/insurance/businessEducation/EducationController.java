package server.api.insurance.businessEducation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EducationController {
    private final EducationService educationService;
}
