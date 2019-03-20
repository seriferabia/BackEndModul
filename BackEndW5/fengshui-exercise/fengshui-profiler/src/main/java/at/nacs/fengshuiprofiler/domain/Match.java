package at.nacs.fengshuiprofiler.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match {
    private Profile profile1;
    private Profile profile2;
    private String signCompatibility;
    private String loveCompatibility;
}
