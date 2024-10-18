package tests;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class C3_JsonObjesiOlusturma {
    @Test
    public void jsonObje01(){

        /*
        Asagidaki JSON Objesini olusturup
konsolda yazdirin.
{
"title":"Ahmet",
"body":"Merhaba",
"userId":1
}
         */


        JSONObject jsonObject=new JSONObject();

        jsonObject.put("title","Ahmet");
        jsonObject.put("body", "Merhaba");
        jsonObject.put("userId",1);

        System.out.println("Ilk Json Objesi: "+jsonObject);
    }
    @Test
    public void jsonObject02(){
        /*
        Asagidaki JSON Objesini olusturup konsolda yazdirin.
{
"firstname":"Jim",
"additionalneeds":"Breakfast",
"bookingdates":{
"checkin":"2018-01-01",
"checkout":"2019-01-01"
},
"totalprice":111,
"depositpaid":true,
"lastname":"Brown"
}
         */

        JSONObject innerJson=new JSONObject();
        innerJson.put("checkin","018-01-01");
        innerJson.put("checkout","2019-01-01");

        JSONObject outerJson=new JSONObject();
        outerJson.put("firstname", "Jim");
        outerJson.put("additionalneeds", "Breakfast");
        outerJson.put("bookingdates",innerJson);
        outerJson.put("totalprice",111);
        outerJson.put("depositpaid",true);
        outerJson.put("lastname","Brown");

    }
}
