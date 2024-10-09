package tests;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class C03_jSONObjesiOlusturma {


    @Test
    public void test01(){

        /*
            {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":1
        }
         */


        JSONObject data=new JSONObject();

        data.put("title", "Ahmet");
        data.put("body", "Merhaba");
        data.put("UserID", "1");

        System.out.println(data);
    }

    @Test
    public void dataUpdate(){


        /*
        {
    “firstname”:“Jim”,
    “additionalneeds”:“Breakfast”,
    “bookingdates”: {
            “checkin”:“2018-01-01",
            “checkout”:“2019-01-01"
 },
     “totalprice”:111,
     “depositpaid”:true,
     “lastname”:“Brown”
 }
         */

        JSONObject updatedData =new JSONObject();
        JSONObject innerData=new JSONObject();


        // eger iner bir data varsa once onun bilguierli yapilmali
        innerData.put("checkin","2018-01-01");
        innerData.put("checkout","2019-01-01");

        updatedData.put("firstname","Jim");
        updatedData.put("additionalneeds","Breakfast");
        updatedData.put("bookingdates",innerData);
        updatedData.put("totalprice",111);
        updatedData.put("depositpaid",true);
        updatedData.put("lastname","Brown");


        System.out.println("updatedDate: "+updatedData);

    }
}
