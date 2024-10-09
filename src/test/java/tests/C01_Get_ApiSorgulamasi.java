package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulamasi {


    /*
     https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
    donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve Server isimli Header’in degerinin Cowboy,
    ve status Line’in HTTP/1.1 200 OK
    ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
     */

    @Test
    public void test(){

        //1. asama EndPoint hazirlamak
    String url="https://restful-booker.herokuapp.com/booking/10";

        //2. expected data verilmedigi icin expected data hazirlanmadi

        //3. Donen cevabi kullanabilmek icin bir obje kaydetmek
        Response response=given().when().get(url);

        //4. Assertion istenmmisse bu islemleri yapmak
        System.out.println("Status Code: "+ response.getStatusCode());
        System.out.println("Content Type: "+ response.contentType());
        System.out.println("Header (Server): "+ response.header("Server"));
        System.out.println("Status Line: "+ response.statusLine());
        System.out.println("Response Time "+ response.time());

    }

}
