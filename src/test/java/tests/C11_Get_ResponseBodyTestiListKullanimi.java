package tests;

import baseUrl.CollectApiBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C11_Get_ResponseBodyTestiListKullanimi extends CollectApiBaseUrl {
    @Test
    public void test01(){
        /*
        C11_Get_ResponseBodyTestiListKullanimi -Suspended
    https://api.collectapi.com/health/dutyPharmacy?il=Kırıkkale url’ine
  bir GET request yolladigimizda
    donen Response’in
    status code’unun 200,
    ve content type’inin Aplication.JSON,
    ve response body’sindeki
        eczane sayısıın sayisinin 4
        ve eczane’lerden birinin “DELİCE ECZANESİ”
        ve eczanele ilçelerinde icinde Merkez ,Delice ve Keskin degerinin oldugunu test edin.
         */

       //1- endpoint ve varsa request data hairla

        specCollectApi.pathParams("pp1","health","pp2","dutyPharmacy").queryParam("il","Kırıkkale");

        //2-expected data olusturma

        //3-response kaydetme

    }
}
