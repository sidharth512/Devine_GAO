package employee;

import Utils.JsonUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import RestUtil.RestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class employeeTests extends EmployeAPIs {
    @Test
    public void employs() throws IOException {


   //     String payload= Payload.payloadforemployeebystring("SIDHARTH PATTANAIK","QA Lead"); //Used for String method
        Map<String,Object> payload= Payload.payloadforemployeebymap("Sidharth Pattanaik","QA");
        Response response=createEmpData(payload);
        Assert.assertEquals(response.statusCode(),200);
          String body=response.getBody().asString();
          System.out.println("Response Body is : "+body);
}
}
