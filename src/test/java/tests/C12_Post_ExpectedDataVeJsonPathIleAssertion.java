package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {
    @Test
    public void test01(){
        /*
        https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
Request body
{
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
"checkin" : "2021-06-01",
"checkout" : "2021-06-10"
},
"additionalneeds" : "wi-fi"
}

Response Body
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
"additionalneeds": "wi-fi"
}
}
         */



        //1- ENdpoint ve reqBody gerekli req body post oldugu icin gerekli

        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin", "2021-06-01");
        bookingDates.put("checkout", "2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname", "Ahmet");
        reqBody.put("lastname", "Bulut");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("additionalneeds" , "wi-fi");
        reqBody.put("bookingdates", bookingDates);

        //2- Expected Data hazirla

        JSONObject expData=new JSONObject();
        expData.put("bookingid",24);
        expData.put("booking",reqBody);

        //3- Response body hazirla

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);
        response.prettyPrint();

        //4- Assertion yap

        JsonPath resJP=response.jsonPath();

        Assertions.assertEquals(expData.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));
        Assertions.assertEquals(expData.getJSONObject("booking").get("lastname"),resJP.get("booking.lastname"));
        Assertions.assertEquals(expData.getJSONObject("booking").get("totalprice"),resJP.get("booking.totalprice"));
        Assertions.assertEquals(expData.getJSONObject("booking").get("depositpaid"),resJP.get("booking.depositpaid"));
        Assertions.assertEquals(expData.getJSONObject("booking").get("additionalneeds"),resJP.get("booking.additionalneeds"));
        Assertions.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                resJP.get("booking.bookingdates.checkin"));
        Assertions.assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                resJP.get("booking.bookingdates.checkout"));





    }
}
