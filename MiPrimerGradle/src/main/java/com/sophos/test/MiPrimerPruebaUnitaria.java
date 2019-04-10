package com.sophos.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class MiPrimerPruebaUnitaria {

	WebDriver driver ;
	@Before
	public void setUp() throws Exception {
		//System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver.exe");		
		driver = new ChromeDriver();	
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test() {
		driver.get("http:\\www.google.com.uy");		
		driver.findElement(By.name("q")).sendKeys("selenium get screenshot java");
		driver.findElement(By.name("btnK")).submit();
		
	}
	/*
	@Test
	public void test2() {
		driver.get("http:\\www.google.com.uy");
		WebElement element = driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Buscar con Google']"));
		String texto=element.getText();
		System.out.println(texto);
		Assert.assertEquals("Buscar con Google", texto);
	}
*/
}
