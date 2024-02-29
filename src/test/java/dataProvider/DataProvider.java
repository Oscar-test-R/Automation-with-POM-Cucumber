package dataProvider;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;


public class DataProvider {
    public static HashMap<String, String> data(){
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;

        //Read Json file
            try {
                Object obj = parser.parse(new FileReader("data/testData.json"));
                jsonObject = (JSONObject) obj;
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

        //Store JSON data as value in a hashmap
        HashMap <String, String> hashMap = new LinkedHashMap<>();
        if (jsonObject != null) {
            Set<String> jsonObjKeys = jsonObject.keySet();
            for (String jsonObjKey : jsonObjKeys){
                hashMap.put(jsonObjKey, (String) jsonObject.get(jsonObjKey));
            }
        }else {
            System.out.println("Error with the Json data");
            throw new RuntimeException();
        }
        return hashMap;
    }
}
