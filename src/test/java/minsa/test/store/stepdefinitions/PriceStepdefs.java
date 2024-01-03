package minsa.test.store.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import minsa.test.store.PriceHttpClient;
import minsa.test.store.sales.infrastructure.rest.dto.PriceOutputDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class PriceStepdefs {

    @Autowired
    PriceHttpClient priceHttpClient;

    private final ThreadLocal<PriceOutputDto> priceOutputDtoFeature = new ThreadLocal<>();
    private final ThreadLocal<String> inputDate = new ThreadLocal<>();

    private static final String ROUTE = "/api/store/price";
    private static final String PARAM_DEFAULT = "&productId=35455&brandId=1";


    @Given("A request filter is filled with {string} {string} productId and brandId")
    public void a_request_filter_is_filled_with_product_id_and_brand_id(String day, String hour) {
        String date = "2020-06-" + day + "T" + hour + ":00:00";
        inputDate.set(date);
    }

    @When("Request is sent to backend")
    public void requestIsSentToBackend() {
        PriceOutputDto priceOutputDto = priceHttpClient.getPrice(this.getRouteAndParams());
        priceOutputDtoFeature.set(priceOutputDto);
    }

    private String getRouteAndParams() {
        return ROUTE + "?date=" + inputDate.get() + PARAM_DEFAULT;
    }

    @Then("Endpoint price response with {string} {string} {string} and {string}")
    public void endpointPriceResponseWithAnd(String priceList, String startDate, String endDate, String price) {
        PriceOutputDto response = priceOutputDtoFeature.get();
        assertEquals(Integer.valueOf(priceList), Integer.valueOf(response.getPriceList())) ;
        assertEquals(startDate, response.getStartDate().format(DateTimeFormatter.ISO_DATE_TIME));
        assertEquals(endDate, response.getEndDate().format(DateTimeFormatter.ISO_DATE_TIME));
        assertEquals(Double.parseDouble(price), response.getPrice(), 0.001);
    }
}
