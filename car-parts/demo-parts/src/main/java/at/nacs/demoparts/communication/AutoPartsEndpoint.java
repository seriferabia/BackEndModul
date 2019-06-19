package at.nacs.demoparts.communication;

import at.nacs.demoparts.logic.UrlParser;
import at.nacs.demoparts.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class AutoPartsEndpoint {
  private final UrlParser urlParser;
  private final RestTemplate restTemplate;

  @GetMapping("/part")
  Result getInfo() {
    //String url = urlParser.buildUrl(title);
    String url = "https://datasn.io/data/api/v1/n3.datasn.io/n3_chennan/european_auto_parts/main/list/?client_key=hwZBKc3if7MVhVcE7JmdHEwQWcdmcU60QDNBma2v&where%5B0%5D%5B0%5D=auto_part.title&where%5B0%5D%5B1%5D=%3D&where%5B0%5D%5B2%5D=Rubber%20Mount%20-%20Radiator&app=json&order_by=id%2C%20ASC&limit=10000&manifest=row&tables=auto_part";
    Result result = restTemplate.getForObject(url, Result.class);
    System.out.println(result.getOutput().getRows().get(0).getTitle());
    return result;
  }


}
