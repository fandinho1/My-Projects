package com.sophos.qa;

import static developmentutilities.QuerysUtilities.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sophos.pom.HomePage;
import com.sophos.pom.MysqlOperations;
import static com.sophos.pom.HomePage.*;

public class MysqlOperationsTest extends BaseTest {
	private MysqlOperations dataBase;
	
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		dataBase = new MysqlOperations();
		new HomePage(driver, wait);
	}
		
	@Test
	public void test(){
		try {
			ArrayList<String> datos = dataBase.consultData(QUERY_SELECT_NAME_USERS);
			System.out.println(datos.size());
			
			for (int i = 0; i < datos.size(); i++) {
				goToSearchBar().sendKeys(datos.get(i));
				goToSearchBar().sendKeys("\n");
				try {
					wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(datos.get(i))));
					String queryUpdateTable1 = "update usuario set resultadoPrueba ='Encontrado'"
							+ " where nombre='"+datos.get(i)+"'";
					dataBase.executeQuery(queryUpdateTable1);
					goToHomePage();
				} catch (TimeoutException ex) {
					String queryUpdateTable2 = "update usuario set resultadoPrueba ='No Encontrado'"
							+ " where nombre='"+datos.get(i)+"'";
					dataBase.executeQuery(queryUpdateTable2);
					goToHomePage();
				} 
			}
		} catch (SQLException e) {
			System.err.println("Error al consultar la base de datos");
		}
	}
	
	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		dataBase.closeConnection();
	}

}
