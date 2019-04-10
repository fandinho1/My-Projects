package com.sophos.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExcelTest {
	
	public static final String RUTA_EXCEL = "C:\\Users\\SEMILLERO02\\Desktop\\documentos\\datos.xlsx";
	WebDriver driver ;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver.exe");
		driver = new ChromeDriver();	
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test() throws IOException {
		File excel = new File(RUTA_EXCEL);
		ExcelUtil archivoExcel = new ExcelUtil(new FileInputStream(excel));
		ArrayList<String> datos = archivoExcel.leerExcel(0);
		for (int i = 0; i < datos.size(); i++) {
			driver.get("https://www.google.com/");
			driver.findElement(By.name("q")).sendKeys(datos.get(i));
			driver.findElement(By.name("btnK")).submit();			
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src, new File("C:/selenium/capturas/excelGradle/testBuscarElemento" + i + ".png"));
				explicitWait(driver, datos.get(i));
				archivoExcel.escribirExcel(archivoExcel.getHoja().getRow(i), "Lo encontró");
				//assertEquals(true, explicitWait(driver, datos.get(i)));
			} catch (RuntimeException ex) {
				archivoExcel.escribirExcel(archivoExcel.getHoja().getRow(i), "No lo encontró");
			} catch (IOException ex2) {
				System.err.println("Error al generar la captura de pantalla");
			}
		}
		archivoExcel.getLibro().write(new FileOutputStream(excel));
		archivoExcel.clear();
	}
	
	public static void explicitWait(WebDriver driver, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(text)));
	}
}
