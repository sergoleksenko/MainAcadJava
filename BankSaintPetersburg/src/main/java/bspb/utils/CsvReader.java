package bspb.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Serg on 5/8/18.
 */
public class CsvReader {

    private static Logger logger = LogManager.getLogger(CsvReader.class);

    public static Iterator<Object[]> readMessagesFromCsv() {
        PropertyConfigurator.configure("log4j.properties");
        List<Object[]> list = new ArrayList<Object[]>();
        String filePath = new File("src/test/java/resources/Messages.csv").getAbsolutePath();

        try {
            logger.info("Getting messages from SCV file.");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                list.add(new Object[]{line});
            }

            bufferedReader.close();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return list.iterator();
    }
}
