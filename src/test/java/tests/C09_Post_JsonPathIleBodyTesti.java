package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class C09_Post_JsonPathIleBodyTesti {
    @Test
    public void test01(){
        /*
        https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
request gonderdigimizde
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
POST REQUEST, RESPONSE BODY BILGILERINI
ASSERT YAPARKEN JSONPATH KULLANMA
donen Response’un,
status code’unun 200,
ve content type’inin application-json,
ve response body’sindeki
"firstname“in,"Ahmet",
ve "lastname“in, "Bulut",
ve "totalprice“in,500,
ve "depositpaid“in,false,
ve "checkin" tarihinin 2021-06-01
ve "checkout" tarihinin 2021-06-10
ve "additionalneeds“in,"wi-fi"
oldugunu test edin
         */

        //1- EndPoint ve reqBody

        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin", "2021-06-01");
        bookingDates.put("checkout" , "2021-06-10");

        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname","Ahmet");
        reqBody.put("lastname", "Bulut");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",bookingDates);
        reqBody.put("additionalneeds" , "wi-fi");

        //2- expectedData

        //3-Response

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        response.prettyPrint();
        //4- assert

        //donen response uzerinden assert yapmak icin jason path formati kulamak gerekli

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("booking.firstaname", equalTo("Ahmet")
                ,"booking.lastname", equalTo(500)
                ,"booking.depositpaid", equalTo(false)
                ,"booking.additionalneeds", equalTo("wi-fi")
                ,"booking.bookingdates.checkin",equalTo("2021-06-01")
                ,"booking.bookingdates.checkout",equalTo("2021-06-10"));







    }
}
