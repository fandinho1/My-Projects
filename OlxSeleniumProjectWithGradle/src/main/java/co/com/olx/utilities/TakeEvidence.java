package co.com.olx.utilities;

import static co.com.olx.utilities.BasicBrowserConstants.BROWSER;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class TakeEvidence {
	public static void takeScreenshot(WebDriver driver, String browser) {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");
		Date actualDate = new Date();
		String dateWithFormat = dateFormat.format(actualDate);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String pathScreen = System.getProperty("user.dir") + "/src/test/java/Evidence/";
			FileUtils.copyFile(src, new File(pathScreen + BROWSER + "/"+"EvidenceExecution" + dateWithFormat + ".png"));
		} catch (IOException e) {
			System.err.println("It was not possible to take the screenshot");
		}
	}

	public static void HighlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void UnhighlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border=''", element);
	}
}
