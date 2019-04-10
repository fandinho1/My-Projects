package com.sophos.qa.exceltest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sophos.pom.ExcelOperations;
import com.sophos.pom.HomePage;
import static com.sophos.pom.HomePage.*;

import static developmentutilities.ExcelOperationsUtilities.*;

public class ExcelOperationsTest extends BaseTest {
	private File excel;
	private ExcelOperations fileExcel;
	private ArrayList<String> datos;
	
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		excel = new File(RUTA_EXCEL);
		fileExcel = new ExcelOperations(new FileInputStream(excel));
		new HomePage(driver, wait);
		datos = fileExcel.readExcel(0);
	}

	@Test
	public void test() throws FileNotFoundException, IOException {
		for (int i = 0; i < datos.size(); i++) {
			goToSearchBar().sendKeys(datos.get(i));
			clicSearchButton();
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(datos.get(i))));
				fileExcel.writeExcel(fileExcel.getHoja().getRow(i), "Lo encontró");
				goToHomePage();
			} catch (TimeoutException ex) {
				fileExcel.writeExcel(fileExcel.getHoja().getRow(i), "No lo encontró");
				goToHomePage();
			} 
		}
		fileExcel.getLibro().write(new FileOutputStream(excel));
	}
	
	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		fileExcel.clear();
	}

}
