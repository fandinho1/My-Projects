using OpenQA.Selenium;

namespace DotNetSelenium.pages
{
    public class HomePage
    {
        private readonly IWebDriver driver;

        public HomePage(IWebDriver driver)
        {
            this.driver = driver;
        }

        private IWebElement ElementsLink => driver.FindElement(By.XPath("//h5[text()='Elements']"));

        public void GoToElementsPage()
        {
            ElementsLink.Click();
        }
    }
}
