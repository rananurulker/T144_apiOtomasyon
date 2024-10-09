package tests;

import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C07_GET_BodyTekrarlardanKurtulma {
    @Test
    public void test01(){

        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
  status code’unun 200,
 ve content type’inin application-json,
 ve response body’sindeki
  “firstname”in, “Susan”,
     ve “lastname”in, “Jackson”,
     ve “totalprice”in, 612,
     ve “depositpaid”in, false,
     ve “additionalneeds”in, “Breakfast”
oldugunu test edin

         */

        String url="https://restful-booker.herokuapp.com/booking/10";

        Response response=given().when().get(url);

        response.then().assertThat().statusCode(200)
                .contentType("application/json")
                .body("firstname", equalTo("Sally"),
                        "lastname", equalTo("Jones")
                ,"totalprice", equalTo(575)
                ,"depositpaid", equalTo(false)
                ,"additionalneeds", equalTo(null));

    }
}
