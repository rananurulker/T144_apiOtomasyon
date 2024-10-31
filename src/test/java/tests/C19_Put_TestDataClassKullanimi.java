package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import testDatas.JsonPlaceData;

import static io.restassured.RestAssured.given;

public class C19_Put_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {
    /*
    C19_Put_TestDataClassKullanimi
https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
PUT request yolladigimizda donen response’in
status kodunun 200, content type’inin “application/json; charset=utf-8”,
Connection header degerinin “keep-alive”
ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
TEST DATA CLASS KULLANIMI
Expected Data :
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
Request Body
{
"title": "Ahmet",
"body": "Merhaba",
"userId": 10,
"id": 70
}
     */

    @Test
    public void put01(){
        //1- URL ve req body hazirla
        specJPH.pathParams("pp1","posts","pp2",70);

        JSONObject reqBody= JsonPlaceData.reqBodyOlustur();

        //2- Expected Body olustur

        JSONObject expBody= JsonPlaceData.reqBodyOlustur();

        //3- Response kaydet

        Response response= given().spec(specJPH)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .put("/{pp1}/{pp2}");
        response.prettyPrint();

        JsonPath respJP=response.jsonPath();

        Assert.assertEquals(JsonPlaceData.basariliSC,response.getStatusCode());
        Assert.assertEquals(JsonPlaceData.contentType,response.getContentType());
        Assert.assertEquals(JsonPlaceData.header,response.getHeader("Connection"));

        Assert.assertEquals(expBody.get("userId"),respJP.get("userId"));
        Assert.assertEquals(expBody.get("id"),respJP.get("id"));
        Assert.assertEquals(expBody.get("title"),respJP.get("title"));
        Assert.assertEquals(expBody.get("body"),respJP.get("body"));

    }
}
