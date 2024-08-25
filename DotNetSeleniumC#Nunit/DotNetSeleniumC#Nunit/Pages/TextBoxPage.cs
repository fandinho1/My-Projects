using OpenQA.Selenium;

namespace DotNetSelenium.pages
{
    public class TextBoxPage
    {
        private readonly IWebDriver driver;

        public TextBoxPage(IWebDriver driver)
        {
            this.driver = driver;
        }

        private IWebElement FullNameInput => driver.FindElement(By.Id("userName"));
        private IWebElement EmailInput => driver.FindElement(By.Id("userEmail"));
        private IWebElement CurrentAddresslInput => driver.FindElement(By.Id("currentAddress"));
        private IWebElement PermanentAddresslInput => driver.FindElement(By.Id("permanentAddress"));

        public void FillAllPersonalData(string name, string email, string currentAddress, string permanentAddress)
        {
            FullNameInput.SendKeys(name);
            EmailInput.SendKeys(email);
            CurrentAddresslInput.SendKeys(currentAddress);
            PermanentAddresslInput.SendKeys(permanentAddress);
        }
    }
}
