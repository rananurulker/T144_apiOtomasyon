package testDatas;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RestFullData {
    /*
    {
           “firstname” : “Ahmet”,
           “lastname” : “Bulut”,
           “totalprice” : 500,
           “depositpaid” : false,
           “bookingdates” : {
               “checkin” : “2021-06-01”,
               “checkout” : “2021-06-10”
           },
           “additionalneeds” : “wi-fi”
       }
     */
    public static JSONObject bookingdatesOlustur(String checkin, String checkout) {
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", checkin);
        bookingdates.put("checkout", checkout);
        return bookingdates;
    }

    public static JSONObject jsonDataOlustur(String firstname, String lastname, int totalprice, boolean depositpaid, JSONObject bookingdates, String additionalneeds) {
        JSONObject booking = new JSONObject();
        booking.put("firstname", firstname);
        booking.put("lastname", lastname);
        booking.put("totalprice", totalprice);
        booking.put("depoistpaid", depositpaid);
        booking.put("bookingdates", bookingdates);
        booking.put("additionalneeds", additionalneeds);
        return booking;
    }

    public static Map<String, Object> MapDataOlustur() {
        Map<String, Object> innerMap = new HashMap<>();
        innerMap.put("checkin", "2021-06-01");
        innerMap.put("checkout", "2021-06-10");


        Map<String, Object> bookingMAP = new HashMap<>();
        bookingMAP.put("firstname", "Ahmet");
        bookingMAP.put("lastname", "Bulut");
        bookingMAP.put("totalprice", 500);
        bookingMAP.put("depositpaid", false);
        bookingMAP.put("bookingdates", innerMap);
        bookingMAP.put("additionalneeds", "wi-fi");

    return bookingMAP;
    }

    public static Map<String, Object> expMapOlustur(){

        Map<String, Object> expMap = new HashMap<>();
        expMap.put("bookingid", 24);
        expMap.put("booking",MapDataOlustur());
        return expMap;
    }
}





