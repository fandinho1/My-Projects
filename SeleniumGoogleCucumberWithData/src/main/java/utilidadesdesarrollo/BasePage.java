package utilidadesdesarrollo;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
    public WebDriverWait wait;
 
    //Constructor
    public BasePage (WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,5);
    }
 
    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    //Wait Wrapper Method
    public WebElement waitClickable(By elementBy) {
    	return wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }
 
    //Click Method
    public void click (By elementBy) {
       // waitVisibility(elementBy);
        waitClickable(elementBy).click();
        //driver.findElement(elementBy).click();
    }
 
    //Write Text
    public void writeText (By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }
 
    //Read Text
    public String readText (By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }
 
    //Assert
    public void assertEquals (By elementBy, String expectedText) {
        waitVisibility(elementBy);
        //Assert.assertEquals(readText(elementBy), expectedText);
    }
    
    public void getEvidence(String nombre) throws Exception{
    	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
		FileUtils.copyFile(src, new File("C:/selenium/"+nombre+".png"));    	
    }
}
