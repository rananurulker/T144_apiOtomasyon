package tests;

import baseUrl.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C13_BaseUrlRestfull extends RestfulBaseUrl {
    @Test
    public void test02(){
        /*
        https://restful-booker.herokuapp.com/booking endpointine asagidaki body’ye sahip bir POST request gonderdigimizde donen response’un status code’unun 200 oldugunu ve “firstname” degerinin “Ahmet” oldugunu test edin
{
     “firstname” : “Ahmet”,
     “lastname” : “Bulut”,
     “totalprice” : 500,
     “depositpaid” : false,
     “bookingdates” : {
              “checkin” : “2021-06-01”,
              “checkout” : “2021-06-10”
                       },
     “additionalneeds” : “wi-fi”
  }
         */


        specRestfull.pathParam("ilk","booking");
        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin", "2021-06-01");
        bookingdates.put("checkout", "2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname","Murat");
        reqBody.put("lastname","Yigit");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",bookingdates);
        reqBody.put("additionalneeds","wi-fi, breakfast");

        Response response=given().contentType(ContentType.JSON).spec(specRestfull)
                .when().body(reqBody.toString()).post("/{ilk}");
        response.then().assertThat().statusCode(200).body("booking.firstname", Matchers.equalTo("Murat"));

    }
}
