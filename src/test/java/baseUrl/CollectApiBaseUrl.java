package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.specification.RedirectSpecification;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.InputStream;

public class CollectApiBaseUrl {
    public RequestSpecification specCollectApi;

    @BeforeTest
    public void setUp(){
        specCollectApi=new RequestSpecBuilder().setBaseUri("https://api.collectapi.com").build();
    }
}
