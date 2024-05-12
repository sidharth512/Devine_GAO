package employee;

import Utils.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import employee.Pojos.employee;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import RestUtil.RestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class employeeTests extends EmployeAPIs {
 //   @Test
//    public void employs() throws IOException {
//
//
//      //  String payload= Payload.payloadforemployeebystring("SIDHARTH PATTANAIK","QA Lead"); //Used for String method
//   //     Map<String,Object> payload= Payload.payloadforemployeebymap("Sidharth Pattanaik","QA"); // Used for given the data in Map
//    //   Map<String,Object> payload= Payload.payloadforemployeebymap(); // Data creation by faker data api
//     //   String payload  = Payload.payloadinfile("employeeDetails.json"); //payload as json file
//        employee payload= Payload.payloadFromPojo();
//         Response response=createEmpData(payload);
//        Assert.assertEquals(response.statusCode(),201);
//    //    Assert.assertEquals(response.jsonPath().getString("name"),payload.getName());
//          String body=response.getBody().asString();
//          System.out.println("Response Body is : "+body);
//        ObjectMapper objectMapper = new ObjectMapper();
//       employee createEmployee  =objectMapper.readValue(response.getBody().asString(),employee.class);
//       Assert.assertEquals(createEmployee,payload);
//
//
//
//}

 // Payload as pojo object and validation of payload and response as pojo object
  @Test
public void employs() throws IOException {

    employee payload= Payload.payloadFromPojo();
    Response response=createEmpData(payload);
    Assert.assertEquals(response.statusCode(),201);
    //    Assert.assertEquals(response.jsonPath().getString("name"),payload.getName());
    String body=response.getBody().asString();
    System.out.println("Response Body is : "+body);
    ObjectMapper objectMapper = new ObjectMapper();
    employee createEmployee  =objectMapper.readValue(response.getBody().asString(),employee.class);
    Assert.assertEquals(createEmployee,payload);



}

}
