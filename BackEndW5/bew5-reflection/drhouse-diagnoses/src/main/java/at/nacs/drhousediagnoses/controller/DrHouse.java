package at.nacs.drhousediagnoses.controller;

import at.nacs.drhousediagnoses.domain.Patient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("medical")
public class DrHouse {
    @Getter
    @Setter
    private Map<String,String> diagnosis;

    public String diagnose(Patient patient){
        if(diagnosis.containsKey(patient.getSymptoms())){
            return diagnosis.get(patient.getSymptoms());
        }
        return "lupus";
    }
}
