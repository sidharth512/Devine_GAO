package employee;

import Utils.JsonUtil;

import java.io.IOException;
import java.util.Map;

public class Base {
    public static Map<String, Object> Data;
    static {

        try {
            Data = JsonUtil.getjsonDataMap("employee/QA/employeApiData.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
