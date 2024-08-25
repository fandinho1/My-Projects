using OpenQA.Selenium;

namespace DotNetSelenium.pages
{
    public class ElementsPage
    {
        private readonly IWebDriver _driver;

        public ElementsPage(IWebDriver driver)
        {
            this._driver = driver;
        }

        private IWebElement TextBoxBtn => _driver.FindElement(By.XPath("//span[text()='Text Box']"));
        private IWebElement WebTablesBtn =>  _driver.FindElement(By.XPath("//span[text()='Web Tables']"));

        public void GoToTexBoxForm()
        {
            TextBoxBtn.Click();
        }

        public void GoToWebTablesPage()
        {
            WebTablesBtn.Click();
        }

    }
}
