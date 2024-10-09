package tests;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class C02_GET_ResponseBilgileriAssertion {
    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
    donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve Server isimli Header’in degerinin Cowboy,
    ve status Line’in HTTP/1.1 200 OK oldugunu test ediniz
     */

    @Test
    public void test01() {

        //1. asama EndPoint hazirlamak
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2. expected data verilmedigi icin expected data hazirlanmadi

        //3. Donen cevabi kullanabilmek icin bir obje kaydetmek
        Response response=given().when().get(url);

        //4. Assertion istenmmisse bu islemleri yapmak
        response.then().assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK")
                .header("Server","Cowboy");


    }
}
