package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTesti {

    @Test
    public void test01(){
        /*
        https://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
Request Body
{
"status": "success",
"data": {
"name": “Ahmet",
"salary": "1230",
"age": "44",
"id": 40
}
}
Response Body
{ "status": "success",
"data": {
"status": "success",
"data": {
"name": “Ahmet",
"salary": "1230",
"age": "44",
"id": 40 }
},
"message": "Successfully! Record ha
s been updated."}
         */

        //1- Endpoint ve reqbody

        String url="http://dummy.restapiexample.com/api/v1/update/21";
        /*
        Request Body
{
"status": "success",
"data": {
"name": “Ahmet",
"salary": "1230",
"age": "44",
"id": 40
}


         */
        JSONObject data=new JSONObject();
        data.put("name", "Ahmet");
        data.put("salary", "1230");
        data.put("age", "44");
        data.put("id", 40);

        JSONObject reqBody=new JSONObject();
        reqBody.put("status", "success");
        reqBody.put("data", data);

        //2- Expected data

        JSONObject expData=new JSONObject();
        expData.put("data",reqBody);
        expData.put("status", "success");
        expData.put("message", "Successfully! Record has been updated.");


        //3= Response

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);
        response.prettyPrint();

        //4- Assertions

        SoftAssert softAssert=new SoftAssert();
        JsonPath resJP=response.jsonPath();

        softAssert.assertEquals(resJP.get("status"),expData.get("status"));
        softAssert.assertEquals(resJP.get("message"),expData.get("message"));
        softAssert.assertEquals(resJP.get("data.data.name"),expData.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(resJP.get("data.data.salary"),expData.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(resJP.get("data.data.age"),expData.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertEquals(resJP.get("data.data.id"),expData.getJSONObject("data").getJSONObject("data").get("id"));
        softAssert.assertEquals(resJP.get("data.status"),expData.getJSONObject("data").get("status"));
        softAssert.assertAll();
    }
}
