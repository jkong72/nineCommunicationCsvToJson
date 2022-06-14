package feat;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class SaveJson {
    public void saveFile(String savePath, String content) {
        try{
            OutputStream output = new FileOutputStream(savePath);
            byte[] by=content.getBytes();
            output.write(by);
            output.close();

        }catch (Exception e) {
            e.getStackTrace();
        }
    }
}
