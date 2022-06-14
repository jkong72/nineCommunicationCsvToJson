package feat;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class ParseJson {
    public ArrayList<String> parseJson(JSONArray jsonData, String parseData) {
        int jsonDataLength = jsonData.size();

        ArrayList<String> result = new ArrayList<String>();
        for (int i=0; i < jsonDataLength; i++){
            JSONObject jsonObject = (JSONObject)jsonData.get(i);
            result.add((String)jsonObject.get(parseData));
            
        }
        return result;
    }
}
