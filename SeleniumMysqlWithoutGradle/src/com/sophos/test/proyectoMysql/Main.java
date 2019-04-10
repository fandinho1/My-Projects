package com.sophos.test.proyectoMysql;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
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

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		try {
			ManejoMysql baseDatos = new ManejoMysql();
			String query = "select nombre from usuario";
			ArrayList<String> datos = baseDatos.consultaDatos(query);
			//String queryAlterTable = "alter table usuario add resultadoPrueba varchar(15)";
			//baseDatos.ejecutarConsulta(queryAlterTable);
			
			for (int i = 0; i < datos.size(); i++) {
				driver.get("https://www.google.com/");
				driver.findElement(By.name("q")).sendKeys(datos.get(i));
				driver.findElement(By.name("btnK")).submit();
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(src, new File("C:/selenium/capturas/mysql/testBuscarElemento" + i + ".png"));
					explicitWait(driver, datos.get(i));
					String queryUpdateTable1 = "update usuario set resultadoPrueba ='Encontrado'"
							+ " where nombre='"+datos.get(i)+"'";
					baseDatos.ejecutarConsulta(queryUpdateTable1);
				} catch (RuntimeException ex) {
					String queryUpdateTable2 = "update usuario set resultadoPrueba ='No Encontrado'"
							+ " where nombre='"+datos.get(i)+"'";
					baseDatos.ejecutarConsulta(queryUpdateTable2);
				} catch (IOException ex2) {
					System.err.println("Error al generar la captura de pantalla");
				}
			}
			driver.close();
			baseDatos.cerrar();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error al consultar la base de datos");
		}
	}

	public static void explicitWait(WebDriver driver, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(text)));
	}
}
