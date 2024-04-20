package employee;

import RestUtil.RestUtils;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class EmployeAPIs {
    public Response createEmpData(Map<String,Object>CreateEmpPayLoad){
        String  endpoint = (String) Base.Data.get("createEmployeesData");
        Response response= RestUtils.performPost(endpoint, CreateEmpPayLoad, new HashMap<>());

        return response;

    }
}
