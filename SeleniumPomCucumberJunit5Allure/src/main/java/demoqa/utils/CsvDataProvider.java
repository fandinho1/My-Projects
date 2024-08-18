package demoqa.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CsvDataProvider {
	
	private static final String DATA_PATH = "src/test/resources/data/";
	
	private static List<CSVRecord> records;
    private static String[] headers;
	
	private static void getRecordsAndHeaders(String csvName) throws IOException {

        try (FileReader reader = new FileReader(DATA_PATH.concat(csvName))) {
            CSVFormat csvFormat = CSVFormat.Builder.create()
                .setHeader()
                .setSkipHeaderRecord(true)
                .build();

            try (CSVParser csvParser = new CSVParser(reader, csvFormat)) {
				records = csvParser.getRecords();
				headers = csvParser.getHeaderNames().toArray(new String[0]);
			}
        }
	}
	

	public static Map<String, String> getDataForRow(String csvName, int rowIndex) throws IOException {
		getRecordsAndHeaders(csvName);
        
        if (rowIndex < 0 || rowIndex >= records.size()) {
            throw new IndexOutOfBoundsException("Row index out of range.");
        }
        CSVRecord record = records.get(rowIndex);
        Map<String, String> dataMap = new HashMap<>();
        for (String header : headers) {
            dataMap.put(header, record.get(header));
        }
        return dataMap;
    }


    public static List<Map<String, String>> getAllData(String csvName) throws IOException {
    	getRecordsAndHeaders(csvName);

        List<Map<String, String>> allData = new ArrayList<>();
        for (CSVRecord record : records) {
            Map<String, String> dataMap = new HashMap<>();
            for (String header : headers) {
                dataMap.put(header, record.get(header));
            }
            allData.add(dataMap);
        }
        return allData;
    }
}
