package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.regex.Matcher;

import static io.restassured.RestAssured.given;

public class C15_BaseUrlJsonPlaceHolder extends JsonPlaceHolderBaseUrl {
    /*
    Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve
Response’ta 100 kayit oldugunu test edin
2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve “title”
degerinin “optio dolor molestias sit” oldugunu test edin
3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve response
body’sinin null oldugunu test edin
     */

    @Test
    public void get01(){
        /*
        1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve
Response’ta 100 kayit oldugunu test edin
         */

        //1-Endpoint
        specJPH.pathParam("pp1","posts");
        //2- expected data

        //3- response kaydet

        Response response=given().spec(specJPH).when().get("/{pp1}");
        response.prettyPrint();

        //4 assert
        response.then().assertThat().statusCode(200).body("title", Matchers.hasSize(100));

    }



    @Test
    public void get02(){
        //2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request
        //gonderdigimizde donen response’un status code’unun 200 oldugunu ve “title”
        //degerinin “optio dolor molestias sit” oldugunu test edin

        //1- url

        specJPH.pathParams("pp1","posts","pp2",44);

        //2-expected data

        //3-response

        Response response=given().spec(specJPH).when().get("/{pp1}/{pp2}");
        response.prettyPrint();


        //4- assertions

        response.then().assertThat().statusCode(200).body("title",Matchers.equalTo("optio dolor molestias sit"));
    }



    @Test
    public void delete(){

        /*
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve response
body’sinin null oldugunu test edin
         */

        specJPH.pathParams("pp1","posts","pp2",50);

        //2-expected data

        //3-response

        Response response= given().spec(specJPH).when().get("/{pp1}/{pp2}");
        response.prettyPrint();

        //4- assertion
        response.then().assertThat().statusCode(200).body("title", Matchers.nullValue());


    }
}
