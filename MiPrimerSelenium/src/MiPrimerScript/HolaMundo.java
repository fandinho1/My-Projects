package MiPrimerScript;
//package com.sophos.testing.qa.MiPrimerScript;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;

public class HolaMundo {

	public static void main(String[] args) {
		//Se configura el driver con Google Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver.exe");		
		WebDriver driver = new ChromeDriver();		
		driver.get("http:\\www.google.com.uy");
		
		
		driver.findElement(By.name("q")).sendKeys("selenium get screenshot java");
		driver.findElement(By.name("btnK")).submit();
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:/SELENIUM/Capturas/capturaTest.png"));
			//para multiples screenshots puedo crear un metodo y usar el codigo:
			//FileUtils.copyFile(src, new File("C:/selenium/capturas/"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error con el archivo");
		}
		
		driver.close();
	}
}
