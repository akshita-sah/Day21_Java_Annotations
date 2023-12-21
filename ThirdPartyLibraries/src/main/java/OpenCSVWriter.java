import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVWriter {
    public static final String SAMPLE_CSV_FILE_PATH = "D:\\Day21_Java_Annotations\\ThirdPartyLibraries\\users.csv";
    public static void main(String[] args) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        CSVWriter writer = new CSVWriter(new FileWriter(SAMPLE_CSV_FILE_PATH, true));
        List<String []> user = new ArrayList<>();
        user.add(new String[]{"Sundar Pichai", "sundar.pichai@gmail.com", "+1-1111111111", "USA"});
        user.add(new String[]{"Satya Nadella", "satyan@gmail.com", "+1-1111111111", "USA"});
        for(String [] userrecord : user) {
            writer.writeNext(userrecord,false);
        }
        writer.close();
    }
}
