package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import testDatas.JsonPlaceData;

import static io.restassured.RestAssured.given;

public class C18_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
yolladigimizda donen response’in status kodunun 200 ve response body’sinin
asagida verilen ile ayni oldugunutest ediniz
Response body :
{
"userId": 3,
"id": 22,
"title": "dolor sint quo a velit explicabo quia nam",
"body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}
     */

    @Test
    public void test01(){

        //url hazirla
        specJPH.pathParams("pp1","posts","pp2","22");

        //expected body hazirla

        JsonPlaceData testJsonPlaceData=new JsonPlaceData();
        JSONObject expData=testJsonPlaceData.expBodyolustur();

        // response kaydet

        Response response=given(specJPH).when().get("/{pp1}/pp2");

        //assertion
        JsonPath respJP=response.jsonPath();

        Assert.assertEquals(expData.get("userId"),respJP.get("userId"));
        Assert.assertEquals(expData.get("id"),respJP.get("id"));
        Assert.assertEquals(expData.get("title"),respJP.get("title"));
        Assert.assertEquals(expData.get("body"),respJP.get("body"));





    }
}
