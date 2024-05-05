package employee;

import com.aventstack.extentreports.ExtentTest;
import employee.Pojos.Gender;
import employee.Pojos.employee;
import net.datafaker.Faker;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Payload {
    ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();

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
    public static Map<String, Object> payloadforemployeebymap(){
        Map<String,Object> payload=  new HashMap<>();
        Faker faker = new Faker();
        payload.put("name",faker.name().fullName());
        payload.put("Job",faker.job().position());
        return payload;
    }
    public static String payloadinfile(String fileName) throws IOException {

            String body;
            String file = ClassLoader.getPlatformClassLoader().getResource("./resource/Payloads" +fileName+"").getFile();
            byte[] filebody = Files.readAllBytes(Paths.get(file));
            String payload = new String(filebody);
            return  body = payload;

    }
    public static employee payloadFromPojo(){
        Faker faker = new Faker();
       //  String genderEmp = Stream.of("male","female","others").findAny().get();
         Gender genderEmp=Arrays.stream(Gender.values()).findAny().get(); // reading the gender data from enum class
       return employee
                .builder()
                .name(faker.name().fullName())
                .job(faker.job().position())
                .gender(genderEmp)
                .build();
    }

    }

