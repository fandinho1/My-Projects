package co.com.google.qa.myfirstsearchwithsikulix.pom;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import static co.com.google.qa.myfirstsearchwithsikulix.utils.BrowserUtilis.EXPLICIT_WAIT_TIME;

public class YandexHomePage {
	
	//public static final Pattern SEARCH_BAR = new Pattern("C:\\Users\\SEMILLERO02\\eclipse-workspace\\MyFirstSikulixProject\\images\\searchBar.png");
	//public static final Pattern SEARCH_BUTTON = new Pattern("C:\\Users\\SEMILLERO02\\eclipse-workspace\\MyFirstSikulixProject\\images\\searchButton.png");
	public static final Pattern SEARCH_BAR = new Pattern(System.getProperty("user.dir")+ "\\images\\searchBar.png");
	public static final Pattern SEARCH_BUTTON = new Pattern(System.getProperty("user.dir")+ "\\images\\searchButton.png");
	
	private static Screen screen= new Screen();
	
	public static void clickSearchBar() throws FindFailed {
		screen.wait(SEARCH_BAR, EXPLICIT_WAIT_TIME).click();
	}
	
	public static void writeText(String text) {
		screen.type(text);
	}
	
	public static void clickSearchButton() throws FindFailed {
		screen.wait(SEARCH_BUTTON, EXPLICIT_WAIT_TIME).click();
	}
	
}
	

