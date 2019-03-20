package at.nacs.drhouseadmission.communication;

import at.nacs.drhouseadmission.controller.Admission;
import at.nacs.drhouseadmission.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {
    private final Admission admission;
    private final RestTemplate restTemplate;

    @Value("${diagnoses.url}")
    private String url;


    @PostMapping
    Patient post(@RequestBody Patient patient) {
        Patient registeredPatient = admission.register(patient);
        return restTemplate.postForObject(url,registeredPatient,Patient.class);
    }

}
