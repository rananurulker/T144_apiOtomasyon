package testDatas;

import org.json.JSONObject;

public class JsonPlaceData {
    public static int basariliSC=200;
    public static String contentType="application/json; charset=utf-8";


    public static JSONObject expBodyolustur() {


        JSONObject expBody=new JSONObject();
        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\\nsed omnis non odio\\nexpedita ear\n" +
                "                 um mollitia molestiae aut atque rem suscipit\\nnam impedit esse");

        return expBody;
    }
}
