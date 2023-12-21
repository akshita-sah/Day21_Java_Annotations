import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class OpenCSVReadAndParseToBean {
    public static final String SAMPLE_CSV_FILE_PATH = "D:\\Day21_Java_Annotations\\ThirdPartyLibraries\\users.csv";
    public static void main(String[] args) throws CsvException, IOException {
        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CsvToBean<Object> csvUsers = new CsvToBeanBuilder<>(reader).withType(CSVUser.class).
                withIgnoreLeadingWhiteSpace(true).build();
        Iterator<Object> csvUserIterator = csvUsers.iterator();
        while (csvUserIterator.hasNext()) {
            CSVUser csvUser = (CSVUser) csvUserIterator.next();
            System.out.println("Name: " + csvUser.getName());
            System.out.println("Email: " + csvUser.getEmail());
            System.out.println("Phone number: " + csvUser.getPhoneNo());
            System.out.println("Country: " + csvUser.getCountry());
            System.out.println("===================================");
        }
    }
}
