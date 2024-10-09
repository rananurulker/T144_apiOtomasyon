package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class JsonPlaceHolderBaseUrl {

    protected RequestSpecification specJPH;

    @BeforeTest
    public void setUp(){
        specJPH=new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
    }
}