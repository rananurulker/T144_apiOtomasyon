package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class C10_Get_ResponseBodyTest {

    @Test
    public void test01(){
        /*
        http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request
yolladigimizda
donen Response'in
status code'unun 200,
ve content type'inin Aplication.JSON,
ve response body'sindeki
employees sayisinin 24
ve employee'lerden birinin "Ashton Cox"
ve girilen yaslar icinde 61,21 ve 35 degerinin oldugunu test edin
test edin.
         */


        //1- URL hazirla
        String url="http://dummy.restapiexample.com/api/v1/employees";

        //2-Expected data

        //3- Response kaydet
        Response response= given().when().get(url);
        response.prettyPrint();

        //4- Assertions

        response.then().assertThat().statusCode(200).contentType("Aplication.JSON")
                .body("data.id", Matchers.hasSize(24),
                        ("data.employee_name"),Matchers.hasItem("Ashton Cox"),
                        ("data.employee"),Matchers.hasItems(61,40,30));



    }
}
