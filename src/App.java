import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;

import feat.CsvJsonConverter;
import feat.ParseJson;
import feat.SaveJson;

public class App {
    public static void main(String[] args) throws Exception {
        String filePath = "bin/data/top20.csv";
        String savePath = "top20.JSON";
        CsvJsonConverter csvJsonConverter = new CsvJsonConverter();
        SaveJson saveJson = new SaveJson();
        ParseJson parseJson = new ParseJson();

        // csv를 행마다 리스트로 하는 중첩 리스트
        List<List<String>> csvList = csvJsonConverter.csvReader(filePath); 
        // System.out.println(csvList);

        // JSON배열 생성
        JSONArray JsonResult = csvJsonConverter.csvJsonConverter(csvList); 
        // System.out.println(JsonResult);

        // JSON 파일 저장
        String jsonString = JsonResult.toString();
        saveJson.saveFile(savePath, jsonString); 

        // 파싱
        String parseData = "licenseOrgan";
        ArrayList<String> result = parseJson.parseJson(JsonResult, parseData);
        System.out.println(result);
        
    }
}
