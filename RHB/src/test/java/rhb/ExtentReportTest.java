package rhb;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class ExtentReportTest extends RhbTest implements IResultListener {

	ExtentTest testReporter;
	ExtentReports reporter = new ExtentReports("build/" + getClass() + "Report.html", true, DisplayOrder.NEWEST_FIRST,
			NetworkMode.ONLINE, Locale.ENGLISH);

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		testReporter = reporter.startTest(result.getMethod().getMethodName(), "Description");
		testReporter.log(LogStatus.INFO, "Starting test " + result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		reporter.endTest(testReporter);
		String screenShotPath;
		try {
			screenShotPath = takescreenshot(driver);
			testReporter.log(LogStatus.PASS, "Passed");
			testReporter.log(LogStatus.PASS, "Snapshot below: " + testReporter.addScreenCapture(screenShotPath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		reporter.endTest(testReporter);
		String screenShotPath;
		try {
			testReporter.log(LogStatus.PASS, "Failed");
			screenShotPath = takescreenshot(driver);
			testReporter.log(LogStatus.FAIL, "Snapshot below: " + testReporter.addScreenCapture(screenShotPath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		reporter.flush();

	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConfigurationFailure(ITestResult itr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {
		// TODO Auto-generated method stub

	}

	/*
	 * public static String capture(WebDriver driver) throws IOException {
	 * TakesScreenshot ts = (TakesScreenshot)driver; String imageName =
	 * System.currentTimeMillis() + ".png"; File source =
	 * ts.getScreenshotAs(OutputType.FILE); String dest =
	 * System.getProperty("user.dir") + "\\screenshot\\" + imageName; File
	 * destination = new File(dest);
	 * org.apache.commons.io.FileUtils.copyFile(source, destination);
	 * 
	 * return dest; }
	 */
	// fo appium scripts

	public String takescreenshot(RemoteWebDriver driver) throws IOException {
		System.out.println(driver);
		String imageName = System.currentTimeMillis() + ".png";
		File srcfile = driver.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\screenshot\\" + imageName;
		File destination = new File(dest);
		FileUtils.copyFile(srcfile, destination);
		return dest;
	}
}
