package listener;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import core.ExtentManager;
import core.ExtentTestManager;
import utils.ScreenshotUtil;

public class CustomListener implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		Path extentPath = Paths.get(System.getProperty("user.dir"), "target","extent-report","extent.html");
		ExtentManager.getInstance(extentPath.toString());

	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = ExtentManager.getExtent().createTest(result.getMethod().getMethodName().toUpperCase());
		ExtentTestManager.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().log(Status.PASS, "Test is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		String path = ScreenshotUtil.captureScreenshot(testName);
		ExtentTestManager.getTest().log(Status.FAIL, "Test is failed");
		ExtentTestManager.getTest().addScreenCaptureFromPath(path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(Status.SKIP, "Test is skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentManager.getExtent().flush();
		ExtentTestManager.closeTest();
	}

}
