package employee;

import java.util.HashMap;
import java.util.Map;

public class Payload {
    public static String payloadforemployeebystring(String name,String Job){
        String payload = "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+Job+"\"\n" +
                "}";
        return payload;
    }
    public static Map<String, Object> payloadforemployeebymap(String Name, String job){
      Map<String,Object> payload=  new HashMap<>();
        payload.put("name",Name);
        payload.put("Job",job);
        return payload;
    }
}
