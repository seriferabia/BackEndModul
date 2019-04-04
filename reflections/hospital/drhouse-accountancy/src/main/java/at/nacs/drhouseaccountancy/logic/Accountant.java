package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.Invoice;
import at.nacs.drhouseaccountancy.persistence.InvoiceRepository;
import at.nacs.drhouseaccountancy.persistence.Patient;
import at.nacs.drhouseaccountancy.persistence.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Accountant {
    private final InvoiceRepository invoiceRepository;
    private final PatientRepository patientRepository;
    private final InvoiceParser parser;

    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    public void updatePayment(Long id) {
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(id);
        optionalInvoice.ifPresent(invoice -> invoice.setPaid(true));
        invoiceRepository.save(optionalInvoice.get());
    }

    public PatientDTO post(PatientDTO patientDTO) {
        Patient patient = new Patient(null, patientDTO.getId(), patientDTO.getName());
        patientRepository.save(patient);
        Invoice invoice = parser.getInvoice(patientDTO, patient);
        invoiceRepository.save(invoice);
        return patientDTO;
    }
}
