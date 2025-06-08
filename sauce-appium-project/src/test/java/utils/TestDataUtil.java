package utils;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestDataUtil {
    public static Object[][] readCsv(String filePath) {
        List<Object[]> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length == 3) {
                    String username = line[0];
                    String password = line[1];
                    boolean isValidLogin = Boolean.parseBoolean(line[2]);

                    data.add(new Object[]{username, password, isValidLogin});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data.toArray(new Object[0][0]);
    }
}
