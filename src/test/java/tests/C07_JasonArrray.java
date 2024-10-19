package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class C07_JasonArrray {
    /*
    {
"firstName":"Ahmet",
"lastName":"Bulut",
"address":{
"streetAddress":"Kurtulus cad.",
"city":"Ankara",
"postalCode":"06100" },
"age":49,
"phoneNumbers":[
{
"number":"532-555 55 55",
"type":"cep" },
{
"number":"0312-123 4567",
"type":"ev " }
]
}
     */
    @Test
    public void Jasonpath(){
        JSONObject ceptel=new JSONObject();
        ceptel.put("type","cep");
        ceptel.put("number","532-555 55 55");

        JSONObject evtel=new JSONObject();
        evtel.put("type", "ev ");
        evtel.put("number", "0312-123 4567");

        JSONArray phonenumbers=new JSONArray();

        phonenumbers.put(0,ceptel);
        phonenumbers.put(1,evtel);


        JSONObject adress=new JSONObject();
        adress.put("streetAddress","Kurtulus cad.");
        adress.put("city","Ankara");
        adress.put("postalCode","06100");

        JSONObject kisiBilgisi=new JSONObject();
        kisiBilgisi.put("firstName","Ahmet");
        kisiBilgisi.put("lastName","Bulut");
        kisiBilgisi.put("age",49);
        kisiBilgisi.put("address",adress);
        kisiBilgisi.put("phone numbers",phonenumbers);

        System.out.println("kisiBilgisi ="+kisiBilgisi);


    }
}
