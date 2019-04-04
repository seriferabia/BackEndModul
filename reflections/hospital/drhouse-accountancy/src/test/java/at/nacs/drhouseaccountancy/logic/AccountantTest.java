package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.Invoice;
import at.nacs.drhouseaccountancy.persistence.InvoiceRepository;
import at.nacs.drhouseaccountancy.persistence.Kind;
import at.nacs.drhouseaccountancy.persistence.PatientRepository;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("data")
class AccountantTest {
    @Autowired
    Accountant accountant;

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    PatientRepository patientRepository;

    @Setter
    @Getter
    private PatientDTO patientWithMedicine;

    @Setter
    @Getter
    private PatientDTO patientWithTreatment;

    @BeforeEach
    void setUp() {
        invoiceRepository.deleteAll();
        patientRepository.deleteAll();
    }


    @Test
    void testMedicineInvoice() {
        accountant.post(patientWithMedicine);
        Invoice invoice = accountant.getAll().get(0);
        assertThat(invoice.getKind()).isEqualTo(Kind.MEDICINE);
    }

    @Test
    void testTreatmentInvoice() {
        accountant.post(patientWithTreatment);
        Invoice invoice = accountant.getAll().get(0);
        assertThat(invoice.getKind()).isEqualTo(Kind.TREATMENT);
    }

    @Test
    void updatePayment() {
        accountant.post(patientWithMedicine);
        Invoice invoice = accountant.getAll().get(0);
        assertThat(invoice.isPaid()).isFalse();

        accountant.updatePayment(invoice.getId());
        invoice = accountant.getAll().get(0);
        assertThat(invoice.isPaid()).isTrue();
    }
}