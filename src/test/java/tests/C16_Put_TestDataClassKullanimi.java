package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C16_Put_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {
    @Test
    public void test01(){
        /*

        https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body'e sahip
    bir PUT request yolladigimizda donen response'in
    status kodunun 200, content type'inin "application/json; charset=utf-8",
    Connection header degerinin "keep-alive"
    ve response body'sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
            "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
        }
   Response Body
              {
            "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
        }

         */

    specJPH.pathParams("pp1","posts","pp2","70");

        JSONObject reqBody= JsonPlaceData.jsonDataOlustur("Ahmet","Merhaba",10,70);
        JSONObject expBody=JsonPlaceData.jsonDataOlustur("Ahmet","Merhaba",10,70);

        Response response=given().contentType(ContentType.JSON).when().spec(specJPH).body(reqBody.toString()).put("/{pp1}/{pp2}");

        //response.then().assertThat().statusCode(200);
        //assert islemlerinde once actua sonra expected yazilirsa testng
        //assert islemlerinde once expected sonra actua yazilirsa junit kullanilir
        JsonPath resJP=response.jsonPath();
        assertEquals(response.getStatusCode(),JsonPlaceData.basariliSC);
        assertEquals(response.getHeader("Connection"),JsonPlaceData.header);



        assertEquals(resJP.getString("title"),expBody.getString("title"));
        assertEquals(resJP.getString("body"),expBody.getString("body"));
        assertEquals(resJP.getInt("userId"),expBody.getInt("userId"));
        assertEquals(resJP.getInt("id"),expBody.getInt("id"));


    }
}
