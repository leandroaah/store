package minsa.test.store;

import minsa.test.store.sales.infrastructure.rest.dto.PriceOutputDto;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class PriceHttpClient {

    private final static String SERVER_URL = "http://localhost";
    @LocalServerPort
    private int port;
    private final RestTemplate restTemplate = new RestTemplate();

    public PriceOutputDto getPrice(String url){
        return restTemplate.getForEntity(this.buildUrl(url),PriceOutputDto.class).getBody();
    }

    private String buildUrl(String url) {
        return SERVER_URL + ":" + port + url;
    }
}
