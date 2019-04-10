package com.sophos.test.archivosExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		File excel = new File("C:\\Users\\SEMILLERO02\\Desktop\\documentos\\datos.xlsx");
		ExcelFile archivoExcel = new ExcelFile(new FileInputStream(excel));
		ArrayList<String> datos = archivoExcel.leerExcel();
		for (int i = 0; i < datos.size(); i++) {
			driver.get("https://www.google.com/");
			driver.findElement(By.name("q")).sendKeys(datos.get(i));
			driver.findElement(By.name("btnK")).submit();
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src, new File("C:/selenium/capturas/excel/testBuscarElemento" + i + ".png"));
				explicitWait(driver, datos.get(i));
				archivoExcel.escribirExcel(archivoExcel.getHoja().getRow(i), "Lo encontró");
			} catch (RuntimeException ex) {
				archivoExcel.escribirExcel(archivoExcel.getHoja().getRow(i), "No lo encontró");
			} catch (IOException ex2) {
				System.err.println("Error al generar la captura de pantalla");
			}
		}
		FileOutputStream outputStream = new FileOutputStream(excel);
		archivoExcel.getLibro().write(outputStream);
		archivoExcel.clear();
		driver.close();
	}

	public static void explicitWait(WebDriver driver, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(text)));
	}

}
