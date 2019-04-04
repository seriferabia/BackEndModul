package at.nacs.drhouseaccountancy.communication;

import at.nacs.drhouseaccountancy.PatientDTO;
import at.nacs.drhouseaccountancy.logic.Accountant;
import at.nacs.drhouseaccountancy.persistence.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AccountancyEndpoint {
    private final Accountant accountant;

    @PostMapping("/patients")
    PatientDTO post(@RequestBody PatientDTO patientDTO) {
        return accountant.post(patientDTO);
    }

    @GetMapping("/invoices")
    List<Invoice> get() {
        return accountant.getAll();
    }

    @PutMapping("/invoices/{id}/paid")
    void put(@PathVariable Long id) {
        accountant.updatePayment(id);
    }
}
