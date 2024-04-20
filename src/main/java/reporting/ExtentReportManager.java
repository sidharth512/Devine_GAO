package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class ExtentReportManager {
    public static ExtentReports  extentReporter;
    public static ExtentReports createInstance(String fileName, String reportName,String documentTitle){
        ExtentSparkReporter extentSparkReporter =new ExtentSparkReporter(fileName);
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setDocumentTitle(documentTitle);
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setEncoding("utf-8");
        extentReporter=new ExtentReports();
        extentReporter.attachReporter(extentSparkReporter);
        return extentReporter;
    }
    public static String DateTimeReportName(){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime=LocalDateTime.now();
        String formatedTime=dateTimeFormatter.format(localDateTime);
        String reportName = "TestReport" + formatedTime + ".html";
        return reportName;
    }

    public static void logPassDetails(String log){
        Setup.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));

    }
    public static void logFailureDetails(String log){
        Setup.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }
    public static void logInfoDetails(String log){
        Setup.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
    }
    public static void logWaringDetails(String log){
        Setup.extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }
    public static void logJson(String json){
        Setup.extentTest.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));


    }
}
