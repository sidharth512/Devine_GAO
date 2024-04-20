package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonUtil {
    private static ObjectMapper OM = new ObjectMapper();
public static Map<String,Object> getjsonDataMap(String jsonFileName) throws IOException {
    String completeJsonfilePath = System.getProperty("user.dir")+ "/src/test/resource/"+jsonFileName;
    Map<String,Object>data=OM.readValue(new File(completeJsonfilePath), new TypeReference<>() {}); // TypeReference is use to get the data from json file as Map
    return data;
}
}
