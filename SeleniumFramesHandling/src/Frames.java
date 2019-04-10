import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Frames.html");
		WebElement frame = driver.findElement(By.xpath("//*[@id= 'Single']/iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("html/body/section/div/div/div/input")).sendKeys("Selenium");
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("html/body//div[1]/div/div/div/div[1]/div/ul/li[2]/a")).click();

		driver.switchTo().frame(1);

		driver.switchTo().frame(0);

		driver.findElement(By.cssSelector("body > section > div > div > div > input[type=\"text\"]")).sendKeys("hola");
		
	}

}
