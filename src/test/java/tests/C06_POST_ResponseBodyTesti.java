package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class C06_POST_ResponseBodyTesti {
    /*
    C6_Post_ResponseBodyTesti
       https://jsonplaceholder.typicode.com/posts url’ine asagidaki body ile bir POST request gonderdigimizde
                {
                “title”:“API”,
                “body”:“API ogrenmek ne guzel”,
                 “userId”:10,
                }
donen Response’un,
        status code’unun 201,
        ve content type’inin application/json
        ve Response Body’sindeki,
           “title”’in “API” oldugunu
           “userId” degerinin 100’den kucuk oldugunu
           “body” nin “API” kelimesi icerdigini
        test edin.
     */

    @Test
    public void test01(){
        String url="https://jsonplaceholder.typicode.com/posts";

        JSONObject reqbody=new JSONObject();
        reqbody.put("title", "API");
        reqbody.put("body", "API ogrenmek ne guzel");
        reqbody.put("UserID", 10);

        //2 yok]


        //3
        Response response=given().contentType(ContentType.JSON).when()
                .body(reqbody.toString()).post(url);

        response.then().assertThat().statusCode(201)
                .contentType("application/json")
                .body("title", Matchers.equalTo("API"))
                .body("userId",Matchers.lessThan(100))
                .body("body",Matchers.contains("API"));

    }
}
