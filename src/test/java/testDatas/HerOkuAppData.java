package testDatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppData {
        /*
                https://restful-booker.herokuapp.com/booking url’ine
                asagidaki body'ye sahip bir POST request gonderdigimizde
                donen response’un bookingid haric asagidaki gibi oldugunu test edin.
                Request body
                       {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                                },
                        "additionalneeds" : "wi-fi"
                        }
               Expected response body
                        {
                         "bookingid":24,
                         "booking":{
                            "firstname":"Ahmet",
                            "lastname":"Bulut",
                            "totalprice":500,
                            "depositpaid":false,
                            "bookingdates":{
                                    "checkin":"2021-06-01",
                                    "checkout":"2021-06-10"
                                            },
                            "additionalneeds":"wi-fi"
                                    }
                          }
     */

    public static JSONObject bookingdatesolustur(String checkIn, String checkOut){
        JSONObject innerData=new JSONObject();
        innerData.put("checkin",checkIn);
        innerData.put("checkout",checkOut);

        return innerData;
    }


/*
Response Body
{
"bookingid": 24,
"booking": {
"firstname": "Ahmet",
"lastname": "Bulut",
"totalprice": 500,
"depositpaid": false,
"bookingdates": {
"checkin": "2021-06-01",
"checkout": "2021-06-10"
},
"additionalneeds": "wi-fi"
}


 */

    public JSONObject expBodyOlusturJson(){
        JSONObject expData=new JSONObject();
        expData.put("bookingid", 24);
        expData.put("booking", bookingOlusturJson());
        return expData;
    }

public JSONObject bookingOlusturJson(){
    JSONObject booking=new JSONObject();
        booking.put("firstname", "Ahmet");
        booking.put("lastname", "Bulut");
        booking.put("totalprice", 500);
        booking.put("depositpaid", false);
        booking.put("additionalneeds", "wi-fi");
        booking.put("bookingdates",bookingOlusturJson());
        return booking;
}

    public static JSONObject reqDataOlustur(String firstname,String lastname, int totalprice, boolean depositpaid,JSONObject bookingdates,String additionalneeds){
        JSONObject reqData=new JSONObject();
        reqData.put("firstname" , firstname);
        reqData.put("lastname" , lastname);
        reqData.put("totalprice" ,totalprice);
        reqData.put("depositpaid",depositpaid);
        reqData.put("bookingdates",bookingdates);
        reqData.put("additionalneeds",additionalneeds);


        return reqData;
    }
/*
{
"firstname" : "Ahmet",
"lastname" : “Bulut",
"totalprice" : 500,
"depositpaid" : false,
"bookingdates" : {
"checkin" : "2021-06-01",
"checkout" : "2021-06-10"
},
"additionalneeds" : "wi-fi"
}
 */

    public static Map<String,Object> innerMAPOlustur(String checkIn, String checkOut){
        Map<String,Object> innerData=new HashMap<>();
        innerData.put("checkin",checkIn);
        innerData.put("checkout",checkOut);

        return innerData;
    }
    public static Map<String,Object> MAPDataOlustur(String firstname, String lastname, double totalprice, boolean depositpaid, Map<String,Object> bookingdates, String additionalneeds){
        Map<String,Object> reqData=new HashMap<>();
        reqData.put("firstname" , firstname);
        reqData.put("lastname" , lastname);
        reqData.put("totalprice" ,totalprice);
        reqData.put("depositpaid",depositpaid);
        reqData.put("bookingdates",bookingdates);
        reqData.put("additionalneeds",additionalneeds);


        return reqData;
    }

    public static Map<String,Object> expMAPDataOlustur(int bookingid,String firstname,String lastname, double totalprice, boolean depositpaid,Map<String,Object> bookingdates, String additionalneeds){
        Map<String,Object> expData=new HashMap<>();
        expData.put("bookingid",bookingid);
        Map<String,Object> booking =MAPDataOlustur(firstname,lastname,totalprice,depositpaid,bookingdates,additionalneeds);
        expData.put("booking",booking);


        return expData;
    }
}