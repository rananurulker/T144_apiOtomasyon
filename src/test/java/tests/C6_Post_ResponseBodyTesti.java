package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class C6_Post_ResponseBodyTesti {
    @Test
    public void test01(){
        /*
        https://jsonplaceholder.typicode.com/posts url’ine asagidaki body ile bir POST request
gonderdigimizde
{
"title":"API",
"body":"API ogrenmek ne guzel",
"userId":10,
}
donen Response’un,
status code’unun 201,
ve content type’inin application/json
ve Response Body'sindeki,
"title"'in "API" oldugunu
"userId" degerinin 100'den kucuk oldugunu
"body" nin "API" kelimesi icerdigini
test edin.
         */

        //1- URL ve reqBody hazirla
        String url="https://jsonplaceholder.typicode.com/posts";

        /*
        {
"title":"API",
"body":"API ogrenmek ne guzel",
"userId":10,
}
         */
        JSONObject reqBody=new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);
        System.out.println("reqBody = "+reqBody);

        //2- expected data
        //3-Response

        Response response=given()
                    .contentType(ContentType.JSON)
                .when()
                    .body(reqBody.toString()).post(url);
        response.prettyPrint();

        //4-Assertion

        response.then().assertThat()
                .statusCode(201)
                .contentType("application/json")
                .body("title", Matchers.equalTo("API"))
                .body("userId",Matchers.lessThan(100))
                .body("body",Matchers.containsString("API"));


    }

    @Test
    public void test02(){
         /*
        https://jsonplaceholder.typicode.com/posts url’ine asagidaki body ile bir POST request
gonderdigimizde
{
"title":"API",
"body":"API ogrenmek ne guzel",
"userId":10,
}
donen Response’un,
status code’unun 201,
ve content type’inin application/json
ve Response Body'sindeki,
"title"'in "API" oldugunu
"userId" degerinin 100'den kucuk oldugunu
"body" nin "API" kelimesi icerdigini
test edin.
         */

        //1- Endpoint ve reqbody olustur
        String url="https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody=new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        //2-Expected Data

        //3- Response
        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);

        //4- Assertions


        response.then().assertThat().statusCode(201).contentType("application/json")
                .body("title", Matchers.equalTo("API"))
                .body("userId",Matchers.lessThan(100))
                .body("body",Matchers.containsString("API"));

    }
}
