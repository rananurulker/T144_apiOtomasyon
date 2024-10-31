package tests;

import baseUrl.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import testDatas.HerOkuAppData;

import static io.restassured.RestAssured.given;


public class C21_Post_TestDataKullanimi extends RestfulBaseUrl {
    @Test
    public void post01() {
        /*
        https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
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
         */

        //1- URL ve reqBody hazirligi
        specRestfull.pathParam("pp1", "booking");

        HerOkuAppData testdataHerOkuApp=new HerOkuAppData();

        JSONObject reqBody=testdataHerOkuApp.bookingOlusturJson();
        JSONObject expData=testdataHerOkuApp.expBodyOlusturJson();
        Response response=given().spec(specRestfull).contentType(ContentType.JSON).when().body(reqBody.toString()).post("/{pp1}");


       // Assert.assertEquals(testdataHerOkuApp.);

    }
}
