package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {

    ExtentSparkReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        // Initialize the ExtentSparkReporter and specify the file path where the report will be saved
        htmlReporter = new ExtentSparkReporter("extentReports.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test in the report when a test starts
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Mark the test as passed in the report
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Mark the test as failed in the report and log the error
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Mark the test as skipped in the report
        test.skip("Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // You can leave this method empty if you're not using success percentages
    }

    @Override
    public void onFinish(ITestContext context) {
        // Write the report to the file
        extent.flush();
    }
}
