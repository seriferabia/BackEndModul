package at.nacs.fengshuiprofiler.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    private String name;
    private LocalDate birthday;
    private String sign;
}
