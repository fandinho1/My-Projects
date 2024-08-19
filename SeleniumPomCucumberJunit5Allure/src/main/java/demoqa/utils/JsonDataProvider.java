package demoqa.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataProvider {
	
	private static final String DATA_PATH = "src/test/resources/data/";
	
	public static Map<String, Object> readJsonFile(String jsonFileName) {
		Map<String,Object> jsonAsMap = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			byte[] mapData = Files.readAllBytes(Paths.get(DATA_PATH.concat(jsonFileName)));
			jsonAsMap = mapper.readValue(mapData, new TypeReference<Map<String, Object>>() {});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        return jsonAsMap;
        
	}

}
