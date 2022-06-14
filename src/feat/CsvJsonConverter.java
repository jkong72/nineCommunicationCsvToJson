package feat;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * CsvJsonConverter
 */
public class CsvJsonConverter {

    // csv파일을 각 행 별로 분리하는 중첩 리스트[ [행1], [행2]... ]를 생성하는 메서드
    public List<List<String>> csvReader(String filePath) {

        List<List<String>> result = new ArrayList<List<String>>();
        BufferedReader bufferedReader = null;

        try {
            // 파일 불러오기
            bufferedReader = Files.newBufferedReader(Paths.get(filePath));
            String line = "";
            
            // 각 행을 리스트로 변환
            while ((line = bufferedReader.readLine()) != null) {

                List<String> stringList = new ArrayList<>();
                String stringArray[] = line.split(",");

                stringList = Arrays.asList(stringArray);
                result.add(stringList);
            }
        // 예외 처리
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }


    // 나눠진 값들을 바탕으로 JSON 형식으로 구성하는 메서드
    public JSONArray csvJsonConverter(List<List<String>> csvList) {

        List<String> csvID = csvList.get(0);
        int colLength = csvID.size();
        int rowLength = csvList.size();

        
        JSONArray jsonResult = new JSONArray();
        for (int row = 1; row < rowLength; row++){ // csv의 행만큼 반복
            JSONObject item = new JSONObject();
            for (int col = 0; col < colLength; col++) { // csv의 id값 만큼 반복
                String key = csvID.get(col);
                String val = csvList.get(row).get(col);
                item.put(key, val); // 필요한 키-값을 인덱싱
            }
            jsonResult.add(item); // csv 행 단위로 리스트 생성
        }

        return jsonResult;
    }
}