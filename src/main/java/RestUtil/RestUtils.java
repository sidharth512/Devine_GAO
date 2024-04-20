package RestUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

import java.util.Map;

public class RestUtils {
    private  static RequestSpecification getRequestSpecification(String endpoints, Object requestPayload, Map<String,String>headers){
        return RestAssured.given()
                .baseUri(endpoints)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload);
    }
    private static void printRequestLogInReport(RequestSpecification requestSpecification){
        QueryableRequestSpecification queryableRequestSpecification= SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("End Point : "+queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Request Body : "+queryableRequestSpecification.getBody());
        ExtentReportManager.logInfoDetails("Method Name : "+queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Request Header : "+queryableRequestSpecification.getHeaders().asList().toString());
    }
private static void printResponseLogInReport(Response response){
    ExtentReportManager.logInfoDetails("Response Body : "+response.getBody().asString());
    ExtentReportManager.logInfoDetails("StatusCode Name : "+response.getStatusCode());
    ExtentReportManager.logInfoDetails("Response Header : "+response.getHeaders().asList().toString());
}
    public static Response performPost(String endpoints,String requestPayload, Map<String,String>headers){
        RequestSpecification requestSpecification = getRequestSpecification(endpoints,requestPayload,headers);
        Response response=requestSpecification.post();
        response .then().log().all().extract().response();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }
    public static Response performPost(String endpoints,Map<String,Object> requestPayload, Map<String,String>headers){
        RequestSpecification requestSpecification = getRequestSpecification(endpoints,requestPayload,headers);
        Response response=requestSpecification.post();
        response .then().log().all().extract().response();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }
}
