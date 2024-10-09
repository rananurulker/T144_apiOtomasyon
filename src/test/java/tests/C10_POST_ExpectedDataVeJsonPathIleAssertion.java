package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class C10_POST_ExpectedDataVeJsonPathIleAssertion {
    @Test
    public void test01(){
        /*

https://restful-booker.herokuapp.com/booking url'ine
asagidaki body'ye sahip bir POST request gonderdigimizde
donen response'un id haric asagidaki gibi oldugunu test edin.

Request body
      {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        additionalneeds": "wi-fi"
    }

Response Body expected data
 {
    "bookingid": 24,
    "booking": {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        additionalneeds": "wi-fi"
    }
}

 */
        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin", "2021-06-01");
        bookingdates.put("checkout", "2021-06-10");

        JSONObject reqbody=new JSONObject();

        reqbody.put("bookingid", 24);
        reqbody.put("firstname", "Ahmet");
        reqbody.put("lastname", "Bulut");
        reqbody.put("totalprice", 500);
        reqbody.put("depositpaid", false);
        reqbody.put("bookingdates", bookingdates);
        reqbody.put("additionalneeds", "wi-fi");

        JSONObject expBody=new JSONObject();
        expBody.put("bookingId",24);
        expBody.put("booking",reqbody);

        Response response=given().when().contentType(ContentType.JSON).body(reqbody.toString()).post(url);

        JsonPath resJP=response.jsonPath();//Assertion islemi oncesi donen cevabi json path formatina donusturduk.

        assertEquals(expBody.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));
        assertEquals(expBody.getJSONObject("booking").get("lastname"),resJP.get("booking.lastname"));
        assertEquals(expBody.getJSONObject("booking").get("totalprice"),resJP.get("booking.totalprice"));
        assertEquals(expBody.getJSONObject("booking").get("depositpaid"),resJP.get("booking.depositpaid"));
        assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),resJP.get("booking.additionalneeds"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                resJP.get("booking.bookingdates.checkin"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                resJP.get("booking.bookingdates.checkout"));
    }
}
