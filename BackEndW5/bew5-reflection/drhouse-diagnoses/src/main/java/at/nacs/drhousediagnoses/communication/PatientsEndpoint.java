package at.nacs.drhousediagnoses.communication;

import at.nacs.drhousediagnoses.controller.DrHouse;
import at.nacs.drhousediagnoses.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientsEndpoint {
    private final DrHouse drHouse;

    @PostMapping
    Patient post(@RequestBody Patient patient) {
        String diagnose = drHouse.diagnose(patient);
        patient.setDiagnosis(diagnose);
        System.out.println("Diagnosis is "+diagnose);
        return patient;
    }
}
