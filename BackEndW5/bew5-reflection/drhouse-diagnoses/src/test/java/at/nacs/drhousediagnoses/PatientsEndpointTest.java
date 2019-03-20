package at.nacs.drhousediagnoses;

import at.nacs.drhousediagnoses.domain.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PatientsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void testPost() {
        Patient patientWithoutDiagnosis = new Patient("1","serife","headache","");
        String url = "http://localhost:9002/patients";
        Patient actual = testRestTemplate.postForObject(url, patientWithoutDiagnosis, Patient.class);
        Patient expected = new Patient("1","serife","headache","migren");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testPost2() {
        Patient patientWithoutDiagnosis = new Patient("2","hala","backache","");
        String url = "http://localhost:9002/patients";
        Patient actual = testRestTemplate.postForObject(url, patientWithoutDiagnosis, Patient.class);
        Patient expected = new Patient("2","hala","backache","lupus");
        assertThat(actual).isEqualTo(expected);
    }
}