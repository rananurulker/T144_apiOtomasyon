package tests;

import baseUrl.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import testDatas.RestFullData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C19_Post_DeSerialization extends RestfulBaseUrl {
    @Test
    public void test01(){
        /*
        https://restful-booker.herokuapp.com/booking url’ine
asagidaki body’ye sahip bir POST request gonderdigimizde
donen response’un id haric asagidaki gibi oldugunu test edin.
Request body
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
Response Body // expected data
 {
    “bookingid”: 24,
    “booking”: {
        “firstname”: “Ahmet”,
        “lastname”: “Bulut”,
        “totalprice”: 500,
        “depositpaid”: false,
        “bookingdates”: {
            “checkin”: “2021-06-01",
            “checkout”: “2021-06-10"
        },
        “additionalneeds”: “wi-fi”
    }
}
         */

        specRestfull.pathParams("pp1","booking");
        Map<String, Object> reqMap= RestFullData.MapDataOlustur();
        Map<String, Object> exMapBody= RestFullData.MapDataOlustur();
        Response response=given().spec(specRestfull).contentType(ContentType.JSON).when().body(reqMap).post("/{pp1}");

        Map<String,Object> respMAP=response.as(HashMap.class);
        Assert.assertEquals(((Map)exMapBody.get("booking")).get("firstname"),((Map)respMAP.get("booking")).get("firstname"));
        Assert.assertEquals(((Map)exMapBody.get("booking")).get("lastname"),((Map)respMAP.get("booking")).get("lastname"));
        Assert.assertEquals(((Map)exMapBody.get("booking")).get("totalprice"),((Map)respMAP.get("booking")).get("totalprice"));
        Assert.assertEquals(((Map)exMapBody.get("booking")).get("depositpaid"),((Map)respMAP.get("booking")).get("depositpaid"));
        Assert.assertEquals(((Map)exMapBody.get("booking")).get("additionalneeds"),((Map)respMAP.get("booking")).get("additionalneeds"));
        Assert.assertEquals(((Map)((Map)exMapBody.get("booking")).get("bookingdates")).get("checkin"),((Map)((Map)exMapBody.get("booking")).get("bookingdates")).get("checkin"));
        Assert.assertEquals(((Map)((Map)exMapBody.get("booking")).get("bookingdates")).get("checkout"),((Map)((Map)exMapBody.get("booking")).get("bookingdates")).get("checkout"));

    }
}
