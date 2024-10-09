package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class C09_GET_ExpectedDataOlusturma {
    @Test
    public void test01(){
        /*
        https://jsonplaceholder.typicode.com/posts/22 url’ine bir GET request yolladigimizda
        donen response body’sinin asagida verilen ile ayni oldugunu test ediniz
  Response body :
  (Expected Data)

{
    “userId”: 3,
    “id”: 22,
    “title”: “dolor sint quo a velit explicabo quia nam”,
    “body”: “eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
            um mollitia molestiae aut atque rem suscipit\nnam impedit esse”
}
         */

        //1- endpoint olusturma ve req body hazirlanir

        String url="https://jsonplaceholder.typicode.com/posts/22";

        //2- expected data hazirlanir

        JSONObject expBody=new JSONObject();
        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear um mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        //3- response kaydedilir
        Response response=given().when().get(url);

        //4- Assertion yapilir
        JsonPath resJP= response.jsonPath();

        assertEquals(expBody.get("userId"),resJP.get("userId"));
        assertEquals(expBody.get("id"),resJP.get("id"));
        assertEquals(expBody.get("title"),resJP.get("userId"));
        assertEquals(expBody.get("body"),resJP.get("body"));

    }
}
