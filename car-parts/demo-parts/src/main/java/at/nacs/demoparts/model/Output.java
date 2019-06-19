package at.nacs.demoparts.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Output {
  private List<Row> rows = new ArrayList<>();

}
