package beweek1.reflection1.controller;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;
@UtilityClass
public class DeliveryInformation {
    public List<String> getInformation(String filePath){
        return FileReader.lines(filePath)
                .collect(Collectors.toList());
    }

}
