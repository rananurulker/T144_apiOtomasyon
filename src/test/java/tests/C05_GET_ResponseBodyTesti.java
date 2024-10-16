package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C05_GET_ResponseBodyTesti {

    @Test
    public void test01(){
        /*
        C5_Get_ResponseBodyTesti
    https://jsonplaceholder.typicode.com/posts/44 url’ine bir GET request yolladigimizda
     donen Response’in
     status code’unun 200,
    ve content type’inin application/json,
    ve response body’sinde bulunan userId’nin 5,
    ve response body’sinde bulunan title’in “optio dolor molestias sit”
    oldugunu test edin.,
         */
        //1

        String url= "https://jsonplaceholder.typicode.com/posts/44";

        //2 verilmisse expected data hazirlanir
        // bu soruda verilmemis

        //3 response kaydedilir
        Response response=given().when().get(url);

        //4 assertion
        response.then().assertThat().statusCode(200).contentType("application/json")
                .body("title", equalTo("optio dolor molestias sit"))
                .body("userId", equalTo(5));


    }
}
