package at.nacs.ex4theenglishgentleman;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Data
@Scope("prototype")
public class Cigar {
    private Boolean lit = false;

    public Boolean isLit() {
        return lit;
    }

    public void smoke() throws CigarWasNotLitException {
        if (!lit) {
            throw new CigarWasNotLitException("Cigar is not lit!");
        }
    }

}
