package testDatas;

import org.json.JSONObject;
import org.testng.collections.Objects;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceData {
    public static int basariliSC=200;
    public static String contentType="application/json; charset=utf-8";
    public static String header="keep-alive";


    public static JSONObject expBodyolustur() {


        JSONObject expData=new JSONObject();

        expData.put("userId", 3);
        expData.put("id", 22);
        expData.put("title", "dolor sint quo a velit explicabo quia nam");
        expData.put("body", "eos qui et ipsum ipsam suscipit aut\\nsed omnis non odio\\nexpedita earum mollitia molestiae aut atque rem suscipit\\nnam impedit esse");
        return expData;
    }
    public static JSONObject jsonDataOlustur(String title,String body,int userId,int id){


    JSONObject jsonData=new JSONObject();
        jsonData.put("title",title);
        jsonData.put("body",body);
        jsonData.put("userId",userId);
        jsonData.put("id",id);

        return jsonData;


    }
    public static Map<String, Object> MAPDataOlustur(String title,String body,double userId,double id){
        Map<String, Object> reqMAPbody=new HashMap<>();
        reqMAPbody.put("title",title);
        reqMAPbody.put("body",body);
        reqMAPbody.put("int",userId);
        reqMAPbody.put("id",id);
        return reqMAPbody;
    }
}
