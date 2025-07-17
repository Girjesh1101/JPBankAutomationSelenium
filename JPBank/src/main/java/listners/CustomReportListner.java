package listners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CustomReportListner implements ITestListener {
	 private static ExtentReports extent = createInstance();
	 private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	 
	 private static ExtentReports createInstance() {
	     String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	     String reportName = "Test-Report-" + timeStamp + ".html";
	     ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/" + reportName);
	     
	     ExtentReports extent = new ExtentReports();
	     extent.attachReporter(htmlReporter);
	     
	     extent.setSystemInfo("OS", System.getProperty("os.name"));
	     extent.setSystemInfo("Java Version", System.getProperty("java.version"));
	     extent.setSystemInfo("Selenium Version", "4.x");
	     
	     return extent;
	 }
	 
	 public void onStart(ITestContext context) {
	     System.out.println("Test Suite started: " + context.getName());
	 }
	 
	 public void onTestStart(ITestResult result) {
	     ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName())
	             .assignCategory(result.getMethod().getGroups());
	     test.set(extentTest);
	     System.out.println("Test started: " + result.getName());
	 }
	 
	 public void onTestSuccess(ITestResult result) {
	     test.get().log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED", ExtentColor.GREEN));
	     System.out.println("Test passed: " + result.getName());
	 }
	 
	 public void onTestFailure(ITestResult result) {
	     test.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED", ExtentColor.RED));
	     test.get().fail(result.getThrowable());
	     System.out.println("Test failed: " + result.getName()+" " +result.getThrowable());
	 }
	 
	 public void onFinish(ITestContext context) {
	     extent.flush();
	     System.out.print("Test Suite completed: " + context.getName());
	 }
}
