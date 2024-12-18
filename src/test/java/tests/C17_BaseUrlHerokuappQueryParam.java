package tests;

import baseUrl.RestfulBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlHerokuappQueryParam extends RestfulBaseUrl {

    /*
    Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
1- https://restful-booker.herokuapp.com/booking endpointine bir GET request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve Response’ta
12 booking oldugunu test edin
2- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon oldugunu test
edecek bir GET request gonderdigimizde, donen response’un status code’unun 200
oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri “Jackson”
olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde, donen
response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip en az bir
booking oldugunu test edin
     */

    @Test
    public void get01(){
        /*
        1- https://restful-booker.herokuapp.com/booking endpointine bir GET request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve Response’ta
12 booking oldugunu test edin
         */

        specRestfull.pathParam("pp1","booking");
        Response response=given().spec(specRestfull).when().get("/{pp1}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(12));

    }

    @Test
    public void get02(){
        /*
        2- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon oldugunu test
edecek bir GET request gonderdigimizde, donen response’un status code’unun 200
oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin
         */

        specRestfull.pathParam("pp1","booking").queryParam("firstname","Eric");
        Response response=given().spec(specRestfull).when().get("/{pp1}");
        response.then().assertThat().statusCode(200).body("bookingid",Matchers.hasSize(2));
    }

    @Test
    public void get03(){
        /*
        - https://restful-booker.herokuapp.com/booking endpointine gerekli Query
parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri “Jackson”
olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde, donen
response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip en az bir
booking oldugunu test edin
         */
    }
}
