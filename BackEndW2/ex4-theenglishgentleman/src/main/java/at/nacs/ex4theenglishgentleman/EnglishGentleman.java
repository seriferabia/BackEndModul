package at.nacs.ex4theenglishgentleman;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Scope("prototype")
public class EnglishGentleman {
    private final Monocle monocle;
    private final Lighter lighter;
    private Boolean smoke = false;
    private Boolean read = false;

    public void smoke(Cigar cigar) {
        lighter.light(cigar);
        smoke = true;
    }

    public boolean isHasSmoked() {
        return smoke;
    }

    public void read(Newspaper newspaper) {
        monocle.read(newspaper);

    }

    public Boolean isHasRead() {
        return read;
    }

    public boolean hadAGoodDay() {
        if (smoke && read) {
            return true;
        }
        return false;
    }
}
