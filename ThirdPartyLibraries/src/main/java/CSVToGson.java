import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVToGson {
    public static final String SAMPLE_CSV_FILE_PATH = "D:\\Day21_Java_Annotations\\ThirdPartyLibraries\\users.csv";

    public static void main(String[] args) throws IOException {
        //String[] user = {"Sundar Pichai", "sundar.pichai@gmail.com", "+1-1111111111", "USA"};
        File file = new File(SAMPLE_CSV_FILE_PATH);
        Gson gson = new Gson();
        String myjson = gson.toJson(file);
        System.out.println(myjson);
        FileWriter writer = new FileWriter("users.json");
        gson.toJson(file, writer);
    }
}
