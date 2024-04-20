package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Setup implements ITestListener {
    private static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();
    public void onStart(ITestContext context) {
       String filename =ExtentReportManager.DateTimeReportName();
       String fullReportpath = System.getProperty("user.dir") + "\\report\\"+filename;
        extentReports  =ExtentReportManager. createInstance(fullReportpath,"Test API Report","Text Execution Report");
    }

    public void onFinish(ITestContext context) {
        if(extentReports!=null){
            extentReports.flush();
        }
    }
    public void onTestStart(ITestResult result) {
        ExtentTest test=extentReports.createTest("Test Name "+result.getMethod().getMethodName());
        extentTest.set(test);
    }
}
