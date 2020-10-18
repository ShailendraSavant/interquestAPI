package interquestPrototype;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class stepdefination {
    int locationIndex;
    List<Map<String, String>> location;
    @Given("^I made a get request for API$")
    public void i_made_a_get_request_for_API() throws Throwable {
        Response response = RestAssured.
                given()
                .get("http://api.citybik.es/v2/networks");
        System.out.println("Status Code is : "+response.getStatusCode());
        //System.out.println(response.jsonPath().prettify());

        location = response.jsonPath().getList("networks.location");
        locationIndex = location.size();
        System.out.println("Current Size "+locationIndex);
      }

    @Then("^I want to verify response latitude and longitude of Germany$")
    public void i_want_to_verify_response_latitude_and_longitude_of_Germany() throws Throwable {
        for (int i = 0; i < locationIndex; i++) {
            if (location.get(i).get("city").equals("Frankfurt")) {
                System.out.println(location.get(i).get("city"));
                System.out.println(location.get(i).get("country"));
                String lon = String.valueOf(location.get(i).get("longitude"));
                String lat = String.valueOf(location.get(i).get("latitude"));
                System.out.println(lon);
                System.out.println(lat);
            }

        }

    }

}
