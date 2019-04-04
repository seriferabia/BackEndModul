package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.Invoice;
import at.nacs.drhouseaccountancy.persistence.Kind;
import at.nacs.drhouseaccountancy.persistence.Patient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

@Service
@ConfigurationProperties("medical")
public class InvoiceParser {

    @Setter
    @Getter
    private Map<String, Double> prices;

    public Invoice getInvoice(PatientDTO patientDTO, Patient patient) {
        Double cost = prices.getOrDefault(getProvided(patientDTO), 0.0);
        return Invoice.builder().patient(patient)
                .kind(getKind(patientDTO))
                .symptoms(patientDTO.getSymptoms())
                .diagnosis(patientDTO.getDiagnosis())
                .provided(getProvided(patientDTO))
                .cost(cost)
                .paid(false)
                .timestamp(LocalDateTime.now()).build();
    }

    private Kind getKind(PatientDTO patientDTO) {
        if (Objects.equals(patientDTO.getMedicine(), null)) {
            return Kind.TREATMENT;
        }
        return Kind.MEDICINE;
    }

    private String getProvided(PatientDTO patientDTO) {
        if (Objects.equals(patientDTO.getMedicine(), null)) {
            return patientDTO.getTreatment();
        }
        return patientDTO.getMedicine();

    }
}
