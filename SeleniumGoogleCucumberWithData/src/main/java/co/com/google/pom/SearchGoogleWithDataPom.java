package co.com.google.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidadesdesarrollo.BasePage;

public class SearchGoogleWithDataPom {
	private BasePage basePage;
	private By txtBuscar = By.xpath("//input[@title='Buscar']");
	//private By btnBuscarXpath = By.xpath("//div[@class='FPdoLc VlcLAe']//input[@value='Buscar con Google']");
	private By btnBuscarName = By.name("btnK");
	
	public SearchGoogleWithDataPom(WebDriver driver) {
		basePage = new BasePage(driver);
	}
	
	public void escribirTextoABuscar(String cadenaBuscar) {
		basePage.writeText(txtBuscar, cadenaBuscar);
	}
	
	public void darClicEnBuscar() {
		basePage.click(btnBuscarName);
	}

}
